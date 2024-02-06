package fr.ubx.poo.td2;

public class Drone extends Vehicule{


    public Drone(String name, Position position, double energy, double cost){
        super(name, position, energy, cost);
    }

    @Override
    int distance(Position target) { // euclidean distance for drone
        return (int)Math.sqrt(Math.pow(target.getX() - this.position.getX(), 2) + Math.pow(target.getY() - this.position.getY(), 2));
    }

    @Override
    Position[] getPathTo(Position target){
        Position[] res = new Position[1];
        res[0] = new Position(target.getX(), target.getY());
        return res;
    }


    @Override
    void getStats(Position target){
        super.getStats(target);
        System.out.println("Distance between our drone and target: "+this.distance(target)+" ");
    }
}
