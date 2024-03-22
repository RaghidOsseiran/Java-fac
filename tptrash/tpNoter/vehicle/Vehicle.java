package vehicle;

import journey.City;

import java.util.Objects;

public abstract class Vehicle {

    private String name;
    private int passengers;
    private int speed;
    private int kmCost;



    public String getName() {
        return name;
    }

    public int getPassengers() {
        return passengers;
    }

    public int getSpeed() {
        return speed;
    }

    public int getKmCost() {
        return kmCost;
    }

    public Vehicle(String name, int passengers, int speed, int kmCost){
        this.name = name;
        this.passengers = passengers;
        this.speed = speed;
        this.kmCost = kmCost;
    }

    public Vehicle(Vehicle v){
        this(v.name, v.passengers, v.speed, v.kmCost);
    }


    public int nbJourneyPerDay(int distance){
        return 24 * getSpeed()/distance;
    }

    public abstract boolean compatibleWith(City c);


    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o instanceof Vehicle){
            Vehicle v = (Vehicle) o;
            return (Objects.equals(this.name, v.name) && this.kmCost == v.kmCost && this.passengers == v.passengers && this.speed == v.speed);
        }
        return false;
    }


    @Override
    public String toString(){
        return getClass().getSimpleName()+" "+getName()+" - nb passengers:"+getPassengers()+" - speed:"+getSpeed()+" km/h - cost:"+getKmCost()+" euros/km";
    }
}
