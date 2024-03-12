package vehicle;

import journey.City;

public class Bus extends Vehicle {
    public Bus(String name, int passengers, int speed, int kmCost) {
        super(name, passengers, speed, kmCost);
    }

    @Override
    public boolean compatibleWith(City c) {
        return true;
    }

    public Bus(Bus ouibus) {
        super(ouibus);
    }
}
