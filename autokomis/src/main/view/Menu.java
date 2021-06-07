package main.view;

import main.controller.Controller;
import main.model.vehicle.Car;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private Scanner scanner;
    private Controller controller;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.controller = new Controller();
    }

    public void displayMenu(){
        boolean flag = true;
        int id;
        int partId;
        int mechanicId;
        printOptions();

        while (flag){
            switch (scanner.next()){
                case "1":
                    controller.showCarsOnSale();
                    break;
                case "2":
                    try {
                        System.out.println("Wpisz ID auta które chcesz kupić");
                        id = scanner.nextInt(); // try catch exception
                        controller.buyCar(id);
                    } catch (InputMismatchException e){
                        System.out.println("Wpisałeś nieprawidłową wartość dozwolone są tylko cyfry");
                    }
                    break;
                case "3":
                    controller.showMyCars();
                    break;
                case "4":
                    System.out.println("Wpisz ID auta które chcesz naprawić");
                    try {
                        id = scanner.nextInt();
                        printPartList();
                        System.out.println("Wybierz którą część chcesz naprawić");
                        partId = scanner.nextInt();
                        System.out.println("Wybierz mechanika u którego chcesz dokonać naprawy");
                        printMechanicList();
                        mechanicId = scanner.nextInt();
                        controller.repairCar(id, partId, mechanicId);
                    } catch (InputMismatchException e){
                        System.out.println("Wpisałeś nieprawidłową wartość dozwolone są tylko cyfry");
                    }
                    break;
                case "5":
                    controller.showClientList();
                    break;
                case "6":
                    System.out.println("Sprzedaj auto potencjalnemu klientowi");
                    try {
                        System.out.println("Wpisz ID klienta któremu chcesz sprzedać auto: ");
                        id = scanner.nextInt();
                        List<Car> carsForClient = controller.availableCarForClient(id);
                        if (carsForClient.size()> 0){
                            System.out.println("Wpisz ID auta które chcesz sprzedać");
                            int idCar = scanner.nextInt();
                            controller.sellCar(carsForClient, idCar, id);
                        } else {
                            System.out.println("Nie posiadasz żadnego auta które spełnia preferencje klienta");
                        }
                    } catch (InputMismatchException e){
                        System.out.println("Wpisałeś nieprawidłową wartość dozwolone są tylko cyfry");
                    }
                    break;
                case "7":
                    System.out.println("Wybierz rodzaj reklamy reklame");
                    try {
                        printAdvList();
                        id = scanner.nextInt();
                        controller.buyAdvertisement(id);
                    } catch (InputMismatchException e){
                        System.out.println("Wpisałeś nieprawidłową wartość dozwolone są tylko cyfry");
                    }
                    break;
                case "8":
                    controller.balance();
                    break;
                case  "9":
                    controller.transactionHistory();
                    break;
                case "10":
                    System.out.println("Sprawdź historię napraw każdego pojazdu");
                    controller.repairHistory();
                    break;
                case "11":
                    controller.washAndRepairCost();
                    break;
                case "0":
                    printOptions();
                    break;
                case "Q":
                    System.out.println("Wyjście");
                    flag = false;
                    break;
                default:
                    System.out.println("Błędnie wprowadzone dane - spróbuj ponownie");
                    break;
            }
            if (controller.playerMoney() > 2* controller.INIT_CASH){
                System.out.println("Gratulecja podwoiłeś swoją gotówkę w " + controller.getCounter() + " turach");
                System.out.println("KONIEC GRY");
                flag = false;
            }
        }
    }

    public static void printOptions(){
        String menu = "Auto handel" +
                "\n1  Przeglądaj bazę samochodów do kupienia " +
                "\n2  Kup samochód" +
                "\n3  Przeglądaj baze posiadanych samochodów " +
                "\n4  Napraw samochód" +
                "\n5  Przejrzyj potencjalnych klientów" +
                "\n6  Sprzedaj auto potencjalnemu klientowi" +
                "\n7  Kup reklamę" +
                "\n8  Sprawdź stan konta" +
                "\n9  Sprawdź historię transakcji" +
                "\n10 Sprawdź historię napraw każdego pojazdu" +
                "\n11 Sprawdź sumę kosztów napraw i mycia dla każdego z posiadanych aut" +
                "\n0 Wyświetl menu" +
                "\nQ Wyjście";
        System.out.println(menu);
    }

    public static void printPartList (){
        System.out.println("\n1 Hamulce" +
                            "\n2 Zawieszenie" +
                            "\n3 Silnik" +
                            "\n4 Karoseria" +
                            "\n5 Skrzynia biegów\n");
    }

    public static void printMechanicList (){
        System.out.println("\n1 Janusz \n2 Marian \n3 Adrian");
    }

    public static void printAdvList(){
        System.out.println("\n1 Reklama w internecie \n2 Reklama w gazecie");
    }


}
