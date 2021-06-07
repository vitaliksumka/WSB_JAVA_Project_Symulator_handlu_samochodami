package main.model.mechanic;

import main.model.vehicle.Car;

public class JanuszMechanic extends Mechanic {

    private final int price = 2000;

    public JanuszMechanic() {
        this.name = "Janusz";
    }

    @Override
    public int getPrice() {
        return price;
    }





}
