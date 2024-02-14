package model;

import fr.ubx.poo.td2.World;

public class Drone extends Vehicule {


    public Drone(String name, Position position, double energy, double cost, World world){
        super(name, position, energy, cost, world);
    }

    @Override
    public int distance(Position target) { // euclidean distance for drone
        return (int)Math.sqrt(Math.pow(target.x() - this.position.x(), 2) + Math.pow(target.y() - this.position.y(), 2));
    }

    @Override
    public Position[] getPathTo(Position target){
        Position[] res = new Position[1];
        res[0] = new Position(target.x(), target.y());
        return res;
    }


    @Override
    public void getStats(Position target){
        super.getStats(target);
        System.out.println("Distance between our drone and target: "+this.distance(target)+" ");
    }
}
