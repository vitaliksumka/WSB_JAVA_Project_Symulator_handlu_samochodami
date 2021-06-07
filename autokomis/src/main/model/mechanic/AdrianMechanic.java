package main.model.mechanic;

import main.model.Wallet;
import main.model.vehicle.Car;

import java.util.Random;

public class AdrianMechanic extends Mechanic{

    private final int price = 1000;

    public AdrianMechanic() {
        this.name = "Adrian";
    }

    @Override
    public boolean fixBreaks(Car car, Wallet wallet) {
        if (isDamagedSomething()){
            damagePart(car, damageId());
        }
        return super.fixBreaks(car, wallet);
    }

    @Override
    public boolean fixSuspension(Car car, Wallet wallet) {
        if (isDamagedSomething()){
            damagePart(car, damageId());
        }
        return super.fixSuspension(car, wallet);
    }

    @Override

    public boolean fixEngine(Car car, Wallet wallet) {
        if (isDamagedSomething()){
            damagePart(car, damageId());
        }
        return super.fixEngine(car, wallet);
    }

    @Override
    public boolean fixBody(Car car, Wallet wallet) {
        if (isDamagedSomething()){
            damagePart(car, damageId());
        }
        return super.fixBody(car, wallet);
    }

    @Override
    public boolean fixTransmission(Car car, Wallet wallet) {
        if (isDamagedSomething()){
            damagePart(car, damageId());
        }
        return super.fixTransmission(car, wallet);
    }

    @Override
    public int getPrice() {
        return super.getPrice();
    }

    private int damageId (){
        Random random = new Random();
        return random.nextInt(5) +1;
    }

    private boolean isDamagedSomething (){
        Random random = new Random();
        return random.nextInt(100) < 2;
    }

    @Override
    protected boolean isSuccessRepair() {
        Random random = new Random();
        return random.nextInt(10) >= 2; // 10 % szansy ze sie nie uda
    }


}
