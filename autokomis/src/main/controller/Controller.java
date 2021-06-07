package main.controller;

import main.model.Advertisement;
import main.model.Generator;
import main.model.Wallet;
import main.model.client.Client;
import main.model.mechanic.AdrianMechanic;
import main.model.mechanic.JanuszMechanic;
import main.model.mechanic.MarianMechanic;
import main.model.mechanic.Mechanic;
import main.model.vehicle.Car;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    public static final int INIT_CASH = 50000;

    List<Car> carsOnSale;
    List<Car> myCars;
    List<Client> clients;

    Wallet wallet;
    Advertisement advertisement;
    Generator generator;

    JanuszMechanic januszMechanic;
    MarianMechanic marianMechanic;
    AdrianMechanic adrianMechanic;

    private int counter;

    public Controller() {
        this.carsOnSale = new ArrayList<>();
        this.myCars = new ArrayList<>();
        this.clients = new ArrayList<>();
        this.wallet = new Wallet(INIT_CASH);
        this.advertisement = new Advertisement();
        this.generator = new Generator();
        this.januszMechanic = new JanuszMechanic();
        this.marianMechanic = new MarianMechanic();
        this.adrianMechanic = new AdrianMechanic();

        carsOnSale.addAll(generator.newCars(10)); // 10  do kupienia na start gry
        clients.addAll(generator.newClients(5)); // 10 klientow na start
        this.counter = 0;
    }

    public void showCarsOnSale (){
        System.out.println("Baza samochodów do kupienia");
        printCarListLabel();
        for (int i =0 ; i < carsOnSale.size(); i ++){
            System.out.println();
            carsOnSale.get(i).printLine(i+1);
        }
        System.out.println();
    }

    public void buyCar (int id){
        try {
            Car carOnSale = carsOnSale.get(id -1);
            if (wallet.payForCar(carOnSale)){
                counter++;
                myCars.add(carOnSale);
                carsOnSale.addAll(generator.newCars(3));
                System.out.println("Kupiono auto " + carOnSale.getBrand() + " za " + carOnSale.getPrice() + " PLN");
                carsOnSale.remove(carOnSale);
            }
            else {
                System.out.println("Nie masz wystarczającej ilości środków na koncie");
            }
        } catch (IndexOutOfBoundsException e){
            System.out.println("ID auta nie ma na liście aut do sprzedarzy");
        }

    }

    public void showMyCars (){
        System.out.println("Baza posiadancyh samochodów");
        printCarListLabel();
        for (int i =0 ; i < myCars.size(); i ++){
            System.out.println();
            myCars.get(i).printLine(i+1);
        }
        System.out.println();
    }

    public void repairCar(int index, int partId, int mechanicId){
        if (partId < 1 || partId > 5 ){
            System.out.println("Brak części o takim numerze");
            return;
        }
        if (mechanicId <1 || mechanicId > 3){
            System.out.println("Brak mechanika o takim numerze");
        }
        try {
            Car car = myCars.get(index -1);
            switch (mechanicId){
                case 1:
                    System.out.println("Janusz");
                    repairAtMechanic(car, partId, januszMechanic);
                    counter++;
                    break;
                case 2:
                    System.out.println("Marian");
                    repairAtMechanic(car, partId, marianMechanic);
                    counter++;
                    break;
                case 3:
                    System.out.println("Adrian");
                    repairAtMechanic(car, partId, adrianMechanic);
                    counter ++;
                    break;
            }
        } catch (IndexOutOfBoundsException e){
            System.out.println("ID auta nie ma na liście Twoich aut");
        }
    }

    public void showClientList (){
        System.out.println("Lista klientów");
        System.out.printf("%1$-4s %2$-15s %3$-15s %4$-15s %5$-13s %6$-13s %7$-13s %8$-13s %9$-18s %10$-13s %11$-10s",
                "ID", "Imie", "Marka", "Marka 2", "Hamulce", "Zawieszenie", "Silnik",
                "Nadwozie", "Skrzynia biegów", "Rodzaj auta", "Gotówka" );
        for (int i =0 ; i < clients.size(); i ++){
            System.out.println();
            clients.get(i).printLine(i+1);
        }
        System.out.println();
    }

    public List<Car> availableCarForClient (int id){
        List<Car> carsForClient = new ArrayList<>();
        try {
            Client client = clients.get(id -1);
            for (Car car: myCars){
                if (car.getBrand().equals(client.getBrands()[0]) || car.getBrand().equals(client.getBrands()[1])){
                    if (    (car.isBreaks() || !client.isBreaks()) &&
                            (car.isSuspension() || !client.isSuspension()) &&
                            (car.isEngine() || !client.isEngine()) &&
                            (car.isBody() || !client.isBody()) &&
                            (car.isTransmission() || !client.isSuspension())){
                        if (!client.isTruck() && car.getLoadingSpace() == 0){
                            carsForClient.add(car);
                        }
                        if (client.isTruck() && car.getLoadingSpace() > 0){
                            carsForClient.add(car);
                        }
                    }
                }
            }
            for (int i =0 ; i < carsForClient.size(); i ++){
                System.out.println();
                carsForClient.get(i).printLine(i+1);
            }
        } catch (IndexOutOfBoundsException e){
            System.out.println("ID klienta nie ma na liście potencjalnych klientów");
            return carsForClient;
        }
        System.out.println();
        return carsForClient;
    }

    public void sellCar(List<Car> carsForClient, int idCar, int idClient){
        try {
            Car carForClient = carsForClient.get(idCar-1);
            Client client = clients.get(idClient-1);

            if (wallet.sellCar(carForClient, client.getCash())){
                System.out.println("Sprzedałeś " + carForClient.getBrand() + " za " + carForClient.getPrice() +
                        " PLN " + " klientowi " + client.getName());
                counter ++;
                myCars.remove(carForClient);
                clients.remove(client);
                clients.addAll(generator.newClients(2));
            }
            else {
                System.out.println("Niestety " + client.getName() + " posiada za mało gotówki");
            }

        } catch (IndexOutOfBoundsException e){
            System.out.println("ID auta nie ma na liście");
        }
    }

    public void buyAdvertisement (int id){
        switch (id){
            case 1:
                Client client = advertisement.buyInternet(wallet);
                if (client != null){
                    counter ++;
                    clients.add(client);
                }
                break;
            case 2:
                List<Client> newClients = advertisement.buyNewspaper(wallet);
                if (newClients != null){
                    counter++;
                    clients.addAll(newClients);
                }
                break;
            default:
                System.out.println("ID reklamy nie poprawne");
                break;
        }
    }


    public void balance (){
        System.out.println("Stan konta: " + wallet.getBalance() + " PLN");
    }

    public void transactionHistory (){
        System.out.println("Historia transakcji");
        List<String> transHistory = wallet.getTransactionHistory();
        for (String s: transHistory){
            System.out.println(s);
        }
    }

    public void repairHistory(){
        System.out.println("Historia napraw aut");
        for (int i =0 ; i < myCars.size(); i ++){
            Car car = myCars.get(i);
            System.out.println("\n" + (i+1) + "\t" + car.getBrand());
            for (int j = 0; j < car.getRepairHistory().size(); j ++){
                System.out.print("\t" + car.getRepairHistory().get(j));
            }
        }
        System.out.println();
    }

    public void washAndRepairCost (){
        System.out.println("Suma kosztów napraw i mycia dla każdego z aut");
        for (int i =0 ; i < myCars.size(); i ++){
            Car car = myCars.get(i);
            System.out.println("\n" + (i+1) + "\t" + car.getBrand() + "\t" + car.getCostRepairAndWash());
        }
        System.out.println();
    }

    private void printCarListLabel (){
        System.out.printf("%1$-4s %2$-15s %3$-15s %4$-15s %5$-10s %6$-13s %7$-13s %8$-13s %9$-13s %10$-18s %11$-10s  %12$-13s", "ID",
                "Marka", "Segment", "Kolor", "Przebieg", "Hamulce", "Zawieszenie", "Silnik", "Nadwozie",
                "Skrzynia biegów", "Cena", "Przestrzeń ładunkowa\n");
    }

    private void repairAtMechanic (Car car, int partId, Mechanic mechanic){
        switch (partId){
            case 1:
                mechanic.fixBreaks(car, wallet);
                break;
            case 2:
                mechanic.fixSuspension(car, wallet);
                break;
            case 3:
                mechanic.fixEngine(car, wallet);
                break;
            case 4:
                mechanic.fixBody(car, wallet);
                break;
            case 5:
                mechanic.fixTransmission(car, wallet);
                break;
        }
    }

    public int playerMoney(){
        return wallet.getBalance();
    }

    public int getCounter() {
        return counter;
    }
}
