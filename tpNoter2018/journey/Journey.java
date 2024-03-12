package journey;

import vehicle.Vehicle;

public class Journey {
    private City city1;
    private City city2;
    private final int distance;
    private final int passengerTicket;
    private final Vehicle[] vehicles = new Vehicle[100];

    private int nb_index = 0;




    public Journey(City city1, City city2, int distance, int passengerTicket){
        this.city1 = city1;
        this.city2 = city2;
        this.distance = distance;
        this.passengerTicket = passengerTicket;
    }


    // rajouter un vehicle au trajet,
    // 1) faut verifier que les deux villes du trajet peuvent acceullir le vehicle.
    // 2) si c'est possible le vehicle est ajouter et on renvoie true, sinon pas ajouter et false
    public boolean addVehicle(Vehicle V){
        if (V.compatibleWith(city1) && V.compatibleWith(city2)) {
            vehicles[nb_index] = V;
            nb_index++;
            return true;
        }
        return false;
    }


    // returns le nombre de passager transportes sur une journee, on suppose que tout les vehicles sont pleins.
    public int passengersPerDay(){
        int res = 0;
        for(Vehicle v: vehicles){
            if (v != null){
                res += v.getPassengers() * v.nbJourneyPerDay(distance);
            }
        }
        return res;
    }

    // verifie si un vehicle appartient au trajet ou pas.
    public boolean contains(Vehicle V){
        for(int i = 0; i < nb_index; i++){
            if (vehicles[i].equals(V)) return true;
        }
        return false;
    }

    // calcule le cout de tous les vehicles du trajet pendant une journee.
    public int costPerDay(){return 0;}

    // calcule le chiffre d'affait du trajet pendant une journee
    public int incomePerDay(){return 0;}

    // calcul le revenu du trajet par jour, logically incomePerDay - costPerDay.
    public int benefitPerDay(){return 0;}


    @Override
    public String toString(){
        return city1.getName()+"-"+city2.getName();
    }

}
