package vehicle;

public class ThermicCar extends Vehicle{
    public ThermicCar(String id, int maxSeatingPlaces, double maxEnergyCapacity, double currentEnergy, double energyPrice, double energyConsumption) {
        super(id, maxSeatingPlaces, maxEnergyCapacity, currentEnergy, energyPrice, energyConsumption);
    }

    @Override
    public String getEnergyUnit() {
        return "l";
    }

    @Override
    public String getEnergyConsumptionUnit(){
        return "l/100km";
    }

    @Override
    public String getEnergyPriceUnit(){
        return "euro/l";
    }

    @Override
    public double chargingTime(double energyDemanded) {
        return 0;
    }

    @Override
    public double energyCost(double distance, double vitesse_moy) {
        return distance * (getEnergyConsumption()/100) *((vitesse_moy/90) * (vitesse_moy/90));
    }


}
