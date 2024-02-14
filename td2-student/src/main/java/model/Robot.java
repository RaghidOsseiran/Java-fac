package model;

import fr.ubx.poo.td2.World;

public class Robot extends Vehicule {

    public Robot(String name, Position position, double energy, double cost, World world) {
        super(name, position, energy, cost, world);
    }



    // TODO
    // Manhattan distance between the robot and the target
    @Override
    public int distance(Position target) {
        return ( Math.abs(target.x() - this.position.x() ) + Math.abs( target.y() - this.position.y()) );
    }


    // TODO
    @Override
    // Calculate the path between the robot and the target to be reached
    public Position[] getPathTo(Position target){
        boolean isRest = false;



        // calculating the total X and Y distances between us and the target
        int totalXDistance = Math.abs(target.x() - this.position.x());
        int totalYDistance = Math.abs(target.y() - this.position.y());

        // calculate the minimum between the 2 distances so we can use it later so equalise then number of vert and hori steps.
        int minDistance = Math.min(totalXDistance, totalYDistance);
        int maxDistance = Math.max(totalXDistance, totalYDistance);
        int currentX = this.getPosition().x();
        int currentY = this.getPosition().y();
        Position[] res;

        // we treat the cases where we only move in 1 direction so then the minimum would be 0, and dividing by 0 would cause errors.
        if (minDistance == 0){
            res = new Position[1];
            int dx = (target.x() > this.getPosition().x()) ? maxDistance : -maxDistance;
            int dy = (target.y() > this.getPosition().y()) ? maxDistance : -maxDistance;
            if (totalXDistance == 0){
                res[0] = new Position(currentX, currentY+dy);
            } else {
                res[0] = new Position(currentX+dx, currentY);
            }
            return res;
        }
        // in case where the total number of steps is uneven we calculate the number of extra steps in the variable res.
        int reste = maxDistance % minDistance;
        if (reste != 0) isRest = true;
        int i = 0;
        res = new Position[minDistance*2+1]; // the + 1 for the case where there is a rest
        for(i = 0; i < minDistance*2; i++){
            if (i%2 == 0){
                // its always the minimum that has to move by 1 or -1
                if (minDistance == totalXDistance){
                    currentX += (target.x() > this.getPosition().x()) ? 1 : -1;
                } else { // if its not the minimum then we move by maxDistance/minDistance
                    currentX += (target.x() > this.getPosition().x()) ? maxDistance/minDistance : -(maxDistance/minDistance);
                }
            } else {
                if (minDistance == totalYDistance){
                    currentY += (target.y() > this.getPosition().y()) ? 1 : -1;
                } else {
                    currentY += (target.y() > this.getPosition().y()) ? maxDistance / minDistance : -(maxDistance / minDistance);
                }
            }
            if (world.isRock(new Position(currentX, currentY))){
                System.out.println("on a rock");
            }
            res[i] = new Position(currentX, currentY);
        }

        // treating the last position for the rest
        if (isRest){
            if(minDistance == totalXDistance){
                currentY += (target.y() > this.getPosition().y()) ? reste : -reste;
            } else if (minDistance == totalYDistance){
                currentX += (target.x() > this.getPosition().x()) ? reste : -reste;
            }
        }
        if (world.isRock(new Position(currentX, currentY))){
            System.out.println("on a rock");
        }
        res[i] = new Position(currentX, currentY);
        return res;
    }

    @Override
    public void getStats(Position target){
        super.getStats(target);
        System.out.println("Distance between our robot and target: "+this.distance(target)+" ");
    }


}
