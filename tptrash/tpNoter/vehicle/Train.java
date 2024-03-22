package vehicle;

import journey.City;

public class Train extends Vehicle {
    public Train(String name, int passengers, int speed, int kmCost) {
        super(name, passengers, speed, kmCost);
    }

    public Train(Train T){
        super(T);
    }

    @Override
    public boolean compatibleWith(City c) {
        if (c.isStation()) return true;
        return false;
    }
}
