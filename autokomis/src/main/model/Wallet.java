package main.model;

import main.model.vehicle.Car;

import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private int balance;
    private List<String> transactionHistory;

    public Wallet(int balance) {
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
    }

    public int getBalance() {
        return balance;
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

    public boolean payForCar (Car car){
        String name = "Zakup auta ";
        int price = car.getPrice();
        if (balance > price){
            balance -= price;
            transactionHistory.add("-" + price + "\tPLN\t" + name + "\t" + car.getBrand() );
            payTax(car);
            payWash(car);
            return true;
        }
        return false;
    }

    public boolean payForRepair (int amount){
        String name = "Naprawa ";
        if (balance > amount){
            balance -= amount;
            transactionHistory.add("-" + amount + "\tPLN\t" + name);
            return true;
        }
        return false;
    }

    public boolean payForAdvertisement (int amount){
        String name = "Zakup reklamy";
        if (balance > amount){
            balance -= amount;
            transactionHistory.add("-" + amount + "\tPLN\t" + name);
            return true;
        }
        return false;
    }

    public boolean sellCar (Car car, int clientCash){
        String name = "Sprzedaż auta";
        int price = car.getPrice();
        if (clientCash > price){
            balance += price;
            transactionHistory.add("+" + price + "\tPLN\t" + name + "\t" + car.getBrand() );
            payTax(car);
            payWash(car);
            return true;
        }
        return false;
    }

    private void payTax (Car car){
        String name = "Podatek ";
        int tax = (int) (car.getPrice() * 0.02);
        balance -= tax;
        transactionHistory.add("-" + tax + "\tPLN\t" + name + "\t"+ car.getBrand());
    }

    private void payWash (Car car){
        String name = "Myjnia ";
        int wash = 100;
        car.addCostRepairAndWash(wash);
        balance -= wash;
        transactionHistory.add("-" + wash + "\tPLN\t" + name + "\t\t" + car.getBrand());
    }
}
