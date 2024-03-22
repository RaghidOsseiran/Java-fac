package journey;

import vehicle.Vehicle;

public class Journey {
    private City city1;
    private City city2;
    private int distance;
    private int passengerTicket;
    private Vehicle[] vehicles;
    private int indx = 0;

    public Journey(City city1, City city2, int distance, int passengerTicket) {
        this.city1 = city1;
        this.city2 = city2;
        this.distance = distance;
        this.passengerTicket = passengerTicket;
        this.vehicles = new Vehicle[100];
    }


    public boolean addVehicle(Vehicle v){
        if(v.compatibleWith(city1) && v.compatibleWith(city2)){
            vehicles[indx] = v;
            indx++;
            return true;
        }
        return false;
    }

    public int passengersPerDay(){
        int res = 0;
        for(Vehicle v: vehicles){
            if (v != null){
                res += v.getPassengers() * v.nbJourneyPerDay(distance);
            }
        }
        return res;
    }

    public boolean contains(Vehicle ve){
        for(Vehicle v: vehicles){
            if(v != null && v == ve){
                return true;
            }
        }
        return false;
    }


    public int costPerDay(){
        int res = 0;
        for(Vehicle v: vehicles){
            if (v != null){
                res += v.getKmCost() * distance * v.nbJourneyPerDay(distance);
            }
        }
        return res;
    }

    public int incomePerDay(){
        return passengersPerDay() * passengerTicket;
    }

    public int benefitPerDay(){
        return incomePerDay() - costPerDay();
    }

    @Override
    public String toString(){
        return city1.getName()+"-"+city2.getName();
    }
}
