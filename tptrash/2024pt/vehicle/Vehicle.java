package vehicle;

public abstract class Vehicle {
    private final String id;
    private final int maxSeatingPlaces;
    private final double maxEnergyCapacity;
    private double currentEnergy;
    private double energyPrice;
    private double energyConsumption;

    public Vehicle(String id, int maxSeatingPlaces, double maxEnergyCapacity, double currentEnergy, double energyPrice, double energyConsumption) {
        this.id = id;
        this.maxSeatingPlaces = maxSeatingPlaces;
        this.maxEnergyCapacity = maxEnergyCapacity;
        this.currentEnergy = currentEnergy;
        this.energyPrice = energyPrice;
        this.energyConsumption = energyConsumption;
    }


    public String getId() {
        return id;
    }

    public int getMaxSeatingPlaces() {
        return maxSeatingPlaces;
    }

    public double getMaxEnergyCapacity() {
        return maxEnergyCapacity;
    }

    public double getCurrentEnergy() {
        return currentEnergy;
    }

    public double getEnergyPrice() {
        return energyPrice;
    }

    public double getEnergyConsumption() {
        return energyConsumption;
    }


    public abstract String getEnergyUnit();
    public abstract String getEnergyConsumptionUnit();
    public abstract String getEnergyPriceUnit();
    public abstract double chargingTime(double energyDemanded);
    public abstract double energyCost(double distance, double vitesse_moy);
    public double travelTime(double distance, double vitesse_moyenne) {
        double energy_cost = energyCost(distance, vitesse_moyenne);
        System.out.println(chargingTime(energy_cost) + (distance/vitesse_moyenne));
        return chargingTime(energy_cost);
    }

}
