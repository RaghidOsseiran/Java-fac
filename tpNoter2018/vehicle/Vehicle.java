package vehicle;

import journey.City;

import java.util.Objects;

public abstract class Vehicle {
    private final String name;
    private final int passengers;
    private final int speed;
    private final int kmCost;


    public String getName(){
        return this.name;
    }

    public int getSpeed(){
        return this.speed;
    }

    public int getKmCost(){
        return this.kmCost;
    }

    public int getPassengers(){
        return this.passengers;
    }

    public Vehicle(String name, int passengers, int speed, int kmCost){
        this.name = name;
        this.passengers = passengers;
        this.speed = speed;
        this.kmCost = kmCost;
    }

    public Vehicle(Vehicle vehicle){
        this.name = vehicle.getName();
        this.passengers = vehicle.getPassengers();
        this.speed = vehicle.getSpeed();
        this.kmCost = vehicle.getKmCost();
    }

    // nombre de voyage d'un vehicule en 24 heure
    public int nbJourneyPerDay(int distance){
        int oneJourney = distance/speed;
        return 24/oneJourney;
    }

    // return true s'il existe un lien(partir/arriver) entre notre vehicule et la gare de la cite
    // un train peut relier que des villes qui disposent d'une gare, un bus n'a aucune contrainte.
    public abstract boolean compatibleWith(City c);


    @Override
    public String toString(){
        return this.getClass().getSimpleName()+" "+this.getName()+" - nb passengers:"+this.getPassengers()+" - speed:"+this.getSpeed()+" km/h - cost:"+this.getKmCost()+" euros/km";
    }



    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o instanceof Vehicle v){
            return this.speed == v.speed && this.kmCost == v.kmCost &&
                    Objects.equals(this.name, v.name) && this.passengers == v.passengers;
        }
        return false;
    }

}
