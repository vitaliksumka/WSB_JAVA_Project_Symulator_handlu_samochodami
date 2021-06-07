package main.model.mechanic;

import main.model.vehicle.Car;

import java.util.Random;

public class MarianMechanic  extends Mechanic {

    private final int price = 1500;

    public MarianMechanic() {
        this.name = "Marian";
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    protected boolean isSuccessRepair() {
        Random random = new Random();
        return random.nextInt(10) >= 1; // 10 % szansy ze sie nie uda
    }

}

