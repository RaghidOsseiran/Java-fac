package vehicle;

public class ElectricCar extends Vehicle{
    private int maxChargingTime;

    public ElectricCar(String id, int maxSeatingPlaces, double maxEnergyCapacity, double currentEnergy, double energyPrice, double energyConsumption, int maxChargingTime) {
        super(id, maxSeatingPlaces, maxEnergyCapacity, currentEnergy, energyPrice, energyConsumption);
        this.maxChargingTime = maxChargingTime;
    }


    @Override
    public String getEnergyUnit() {
        return "Kwh";
    }

    @Override
    public String getEnergyConsumptionUnit(){
        return "Kwh";
    }

    @Override
    public String getEnergyPriceUnit(){
        return "euro/Kwh";
    }

    @Override
    public double chargingTime(double energyDemanded) {
        double e = energyDemanded - getCurrentEnergy();
        if (e > 0){
            return (e * maxChargingTime)/(getMaxEnergyCapacity());
        }
        return 0;
    }

    @Override
    public double energyCost(double distance, double vitesse_moy){
        return (distance/vitesse_moy) * getEnergyConsumption() * ((vitesse_moy/90)*(vitesse_moy/90));
    }


}
