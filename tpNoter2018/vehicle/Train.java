package vehicle;

import journey.City;

public class Train extends Vehicle {

    public Train(String name, int passengers, int speed, int kmCost) {
        super(name, passengers, speed, kmCost);
    }

    @Override
    public boolean compatibleWith(City c) {
        return c.getStation();
    }

    public Train(Train ter) {
        super(ter);
    }
}
