package main.model.mechanic;

import main.model.Wallet;
import main.model.vehicle.Car;

public class Mechanic implements MechanicI {
    protected String name;

    public boolean fixBreaks (Car car, Wallet wallet) {
        String partName = "hamulce";
        int fixCost = (int) (getPrice() * 0.2);
        int totalCost = fixCost + getCostBreaks(car);
        if (wallet.payForRepair(totalCost)) {
            car.addCostRepairAndWash(totalCost);
            if (isSuccessRepair()) {
                car.setPrice((int) (car.getPrice() * 1.1));
                car.setBreaks(true);
                printFixed(partName, totalCost);
                return true;
            } else {
                printDamage(partName, totalCost);
                return false;
            }
        }
        printNotEnoughMoney(partName, totalCost);
        return false;
    }


    public boolean fixSuspension (Car car, Wallet wallet){
        String partName = "zawieszenie";
        int fixCost = (int) (getPrice() * 0.5);
        int totalCost = fixCost + getCostSuspension(car);
        if (wallet.payForRepair(totalCost)){
            car.addCostRepairAndWash(totalCost);
            if (isSuccessRepair()){
                car.setPrice((int) (car.getPrice()*1.2));
                car.setSuspension(true);
                printFixed(partName, totalCost);
                return true;
            } else {
                printDamage(partName, totalCost);
                return false;
            }
        }
        printNotEnoughMoney(partName, totalCost);
        return false;
    }

    public boolean fixEngine (Car car, Wallet wallet){
        String partName = "silnik";
        int fixCost = getPrice();
        int totalCost = fixCost + getCostEngine(car);
        if (wallet.payForRepair(totalCost)){
            car.addCostRepairAndWash(totalCost);
            if (isSuccessRepair()){
                car.setPrice( (car.getPrice()*2));
                car.setEngine(true);
                printFixed(partName, totalCost);
                return true;
            } else {
                printDamage(partName, totalCost);
                return false;
            }
        }
        printNotEnoughMoney(partName, totalCost);
        return false;
    }

    public boolean fixBody (Car car, Wallet wallet){
        String partName = "nadwozie";
        int fixCost = (int) (getPrice() * 0.6);
        int totalCost = fixCost + getCostBody(car);
        if (wallet.payForRepair(totalCost)){
            car.addCostRepairAndWash(totalCost);
            if (isSuccessRepair()){
                car.setPrice((int) (car.getPrice()*1.5));
                car.setBody(true);
                printFixed(partName, totalCost);
                return true;
            } else {
                printDamage(partName, totalCost);
                return false;
            }
        }
        printNotEnoughMoney(partName, totalCost);
        return false;
    }

    public boolean fixTransmission (Car car, Wallet wallet){
        String partName = "skrzynia biegów";
        int fixCost = (int) (getPrice() * 0.9);
        int totalCost = fixCost + getCostTransmission(car);
        if (wallet.payForRepair(totalCost) ){
            car.addCostRepairAndWash(totalCost);
            if (isSuccessRepair()){
                car.setPrice((int) (car.getPrice()*1.5));
                car.setTransmission(true);
                printFixed(partName, totalCost);
                return true;
            } else {
                printDamage(partName, totalCost);
                return false;
            }
        }
        printNotEnoughMoney(partName, totalCost);
        return false;
    }

    public int getCostBreaks(Car car){
        int cost = 500;
        if (car.getBrand().isExpensiveBrand(car)){
            cost *=  2;
        }
        if (car.getBrand().isAverageBrand(car)){
            cost *= 1.5;
        }
        return cost;
    }

    public int getCostSuspension(Car car){
        int cost = 800;
        if (car.getBrand().isExpensiveBrand(car)){
            cost *=  2;
        }
        if (car.getBrand().isAverageBrand(car)){
            cost *= 1.5;
        }
        return cost;
    }

    public int getCostEngine(Car car) {
        int cost = 1500;
        if (car.getBrand().isExpensiveBrand(car)){
            cost *=  2;
        }
        if (car.getBrand().isAverageBrand(car)){
            cost *= 1.5;
        }
        return cost;
    }

    public int getCostBody(Car car){
        int cost = 1000;
        if (car.getBrand().isExpensiveBrand(car)){
            cost *=  2;
        }
        if (car.getBrand().isAverageBrand(car)){
            cost *= 1.5;
        }
        return cost;
    }

    public int getCostTransmission(Car car){
        int cost = 1300;
        if (car.getBrand().isExpensiveBrand(car)){
            cost *=  2;
        }
        if (car.getBrand().isAverageBrand(car)){
            cost *= 1.5;
        }
        return cost;
    }

    protected Car damagePart (Car car, int index){
        if (index == 1){ // damage breaks
            car.setBreaks(false);
            System.out.println("Niestety podczas naprawy mechanik zepsuł hamulce.");
        }
        if (index == 2){ //damage suspension
            car.setSuspension(false);
            System.out.println("Niestety podczas naprawy mechanik zepsuł zawieszenie.");
        }
        if (index == 3){ //damage engine
            car.setEngine(false);
            System.out.println("Niestety podczas naprawy mechanik zepsuł silnik.");
        }
        if (index == 4){ //damage body
            car.setBody(false);
            System.out.println("Niestety podczas naprawy mechanik zepsuł nadwozie.");
        }
        if (index == 5){ //damage transmission
            car.setTransmission(false);
            System.out.println("Niestety podczas naprawy mechanik zepsuł skrzynię biegów.");
        }
        return car;
    }

    protected boolean isSuccessRepair(){
        return true;
    }

    private void printFixed (String typeOfPart, int totalCost){
        System.out.println(name + ": naprawiono " + typeOfPart + ". Koszt usługi: " + totalCost + " PLN");
    }

    private void printDamage (String typeOfPart, int totalCost){
        System.out.println(name + ": niestety nie nie naprawiono " + typeOfPart
                            + ".\nKoszt usługi: " + totalCost + " PLN");
    }

    private void printNotEnoughMoney (String typeOFPart, int totalCost){
        System.out.println(name + ": masz za mało gotówki. Potrzebujesz na naprawę "
                            + typeOFPart + " potrzebujesz: " + totalCost + " PLN");
    }

    @Override
    public int getPrice() {
        return 0;
    }

}
