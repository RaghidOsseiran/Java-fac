package fr.ubx.poo.td2;

public class Vehicule {
    final double cost;
    String name;
    protected Position position; // change the visibility of position to protected so the child classes have access to this field
    double energy;

    public Position getPosition() {
        return new Position(this.position);
    }

    int range() {
        return (int) Math.floor(this.energy / this.cost);
    }

    int distance(Position target) {
        return 0;
    }

    boolean canMove(Position target) {
        if (this.range() >= this.distance(target)) return true;
        return false;
    }

    void move(Position target) {
        if (this.canMove(target)) {
            this.energy = this.energy - (this.distance(target) * this.cost);
            this.getStats(target);
            this.position = new Position(target);
            System.out.println("Move completed: "+ this + "\n");
        }
    }

    Position[] getPathTo(Position target) {
        return null;
    }

    void getStats(Position target) {
        System.out.println("Remaining energy: " + this.energy + " ");
        System.out.println("Cost of current movement: " + (this.distance(target) * this.cost) + " ");
        System.out.println("Current position: (" + this.position.getX() + " , " + this.position.getY() + ")");
        System.out.println("Target position: (" + target.getX() + " , " + target.getY() + ")");
    }



    @Override
    public String toString(){
        return " "+getClass().getSimpleName()+" "+this.name+": energy = "+this.energy+" ";
    }


    public Vehicule(String name, Position position, double energy, double cost) {
        this.name = name;
        this.position = new Position(position);
        this.energy = energy;
        this.cost = cost;
    }
}
