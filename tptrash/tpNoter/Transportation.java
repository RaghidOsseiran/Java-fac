import vehicle.*;
import journey.*;

public class Transportation {

    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[6];
        vehicles[0] = new Train("tgv", 1032, 300, 100);
        Train ter = new Train ("ter", 500, 100, 50);
        vehicles[1] = ter;
        Bus ouibus = new Bus("ouibus", 40, 70, 10);
        vehicles[2] = ouibus;
        vehicles[3] = new Bus(ouibus);
        vehicles[4] = new Train(ter);
        vehicles[5] = new Bus(new Bus("harley", 2000, 30, 3));

        for (Vehicle v : vehicles)
            System.out.println(v);
        System.out.println();

        City paris = new City("Paris", true);
        City bordeaux = new City ("Bordeaux", true);
        City saucats = new City("Saucats", false);

        Journey[] journeys = new Journey[2];
        journeys[0] = new Journey(paris, bordeaux, 600, 50);
        journeys[1] = new Journey(bordeaux, saucats, 20, 4);

        for (Vehicle v: vehicles){
            for (Journey j : journeys){
                if (j.addVehicle(v))
                    System.out.println(v.getName() + "[speed : "+ v.getSpeed() +
                            ", kmCost : " + v.getKmCost()+", passengers : " + v.getPassengers()+"] added to " + j);
            }
        }

        System.out.println();

        int benefit = 0;
        for (Journey j : journeys) {
            System.out.println(j + " -> passagers/day:" + j.passengersPerDay() +
                    " income/day:" + j.incomePerDay() + " cost/day:" + j.costPerDay());
            benefit += j.benefitPerDay();
        }

        System.out.println("benefit : "+ benefit );

        City Beirut = new City("Beirut", false);
        City Baalbek = new City("Baalbek", true);
        Journey test = new Journey(Beirut, Baalbek, 20, 3);
        Vehicle[] vehicleTest = new Vehicle[3];
        vehicleTest[0] = new Bus("bus ra2em 4", 200, 2, 1);
        vehicleTest[1] = new Train("men wen byeje", 3000, 40, 2);
        vehicleTest[2] = new Bus("Bus el maderse", 30, 4, 2);
        for(Vehicle v: vehicleTest){
            if (v != null){
                System.out.println(test.addVehicle(v));
            }
        }
    }
}