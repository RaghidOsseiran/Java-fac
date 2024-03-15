package journey;

public class City {
    public City(String name, boolean station) {
        this.name = name;
        this.station = station;
    }

    public String getName() {
        return name;
    }

    public boolean isStation() {
        return station;
    }

    private String name;
    private boolean station;
}
