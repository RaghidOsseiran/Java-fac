public abstract class Vehicle {
    private int speed;
    private int kmCost;
    private String name;


    public int getSpeed() {
        return speed;
    }

    public int getKmCost(){
        return kmCost;
    }

    public String getName(){
        return name;
    }

    public Vehicle(int speed, int kmCost, String name){
        this.speed = speed;
        this.kmCost = kmCost;
        this.name = name;
    }

    void run(){
        System.out.println(getClass().getSimpleName() + " is moving");
    }

}
