package model;

import fr.ubx.poo.td2.World;

public abstract class Vehicule {
    final double cost;
    String name;
    protected Position position; // change the visibility of position to protected so the child classes have access to this field
    double energy;

    protected World world;

    public Position getPosition() {
        return new Position(this.position.x(), this.position.y());
    }

    int range() {
        return (int) Math.floor(this.energy / this.cost);
    }

    public abstract int distance(Position target);

    public boolean canMove(Position target) {
        if (this.range() >= this.distance(target)) return true;
        return false;
    }

    public void move(Position target) {
        if (this.canMove(target)) {
            this.energy = this.energy - (this.distance(target) * this.cost);
            this.getStats(target);
            this.position = new Position(target.x(), target.y());
            System.out.println("Move completed: "+ this + "\n");
        }
    }

    public abstract Position[] getPathTo(Position target) ;

    public void getStats(Position target) {
        System.out.println("Remaining energy: " + this.energy + " ");
        System.out.println("Cost of current movement: " + (this.distance(target) * this.cost) + " ");
        System.out.println("Current position: (" + this.position.x() + " , " + this.position.y() + ")");
        System.out.println("Target position: (" + target.x() + " , " + target.y() + ")");
    }



    @Override
    public String toString(){
        return " "+getClass().getSimpleName()+" "+this.name+": energy = "+this.energy+" ";
    }


    public Vehicule(String name, Position position, double energy, double cost, World world) {
        this.name = name;
        this.position = new Position(position.x(), position.y());
        this.energy = energy;
        this.cost = cost;
        this.world = world;
    }
}
