package journey;

public class City {
    private final String name;
    private boolean station;

    public City(String name, boolean has_station){
        this.name = name;
        this.station = has_station;
    }



    public String getName(){
        return this.name;
    }
    public boolean getStation(){
        return this.station;
    }
}
