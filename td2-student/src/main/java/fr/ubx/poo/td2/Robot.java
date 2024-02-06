package fr.ubx.poo.td2;

public class Robot {
    final double cost;
    String name;
    private Position position;
    double energy;

    boolean canMove = true;

    public Position getPosition(){
        return new Position(this.position); /* we create a new instance of the class position with the same attribute
        // values as the robots current position, so then whoever calls this methode doesn't directly have access to
        our robots position instance. */
    }
    public Robot(String name, Position position, double energy, double cost) {
        this.name = name;
        this.position = new Position(position);
        this.energy = energy;
        this.cost = cost;
    }

    // TODO
    // Robot's range of action
    int range() { return (int) Math.floor(this.energy/this.cost); }

    // TODO
    // Manhattan distance between the robot and the target
    int distance(Position target) {
        return ( Math.abs(target.getX() - this.position.getX() ) + Math.abs( target.getY() - this.position.getY()) );
    }

    // TODO
    // Can the robot move to the target position?
    boolean canMove(Position target) {
        if (this.range() >= this.distance(target)) return true;
        return false;
    }

    // TODO
    // Actions to perform when the robot moves to the target: update the robot's coordinates, remaining energy, etc.
    void move(Position target) {
        if (this.canMove(target)){
            this.energy = this.energy - (this.distance(target) * this.cost);
            this.getStats(target);
            this.position = new Position(target);
        }
    }

    // TODO
    // Calculate the path between the robot and the target to be reached
    Position[] getPathTo(Position target){
        boolean isRest = false;

        // calculating the total X and Y distances between us and the target
        int totalXDistance = Math.abs(target.getX() - this.position.getX());
        int totalYDistance = Math.abs(target.getY() - this.position.getY());

        // calculate the minimum between the 2 distances so we can use it later so equalise then number of vert and hori steps.
        int minDistance = Math.min(totalXDistance, totalYDistance);
        int maxDistance = Math.max(totalXDistance, totalYDistance);
        int currentX = this.getPosition().getX();
        int currentY = this.getPosition().getY();
        Position[] res;

        // we treat the cases where we only move in 1 direction so then the minimum would be 0, and dividing by 0 would cause errors.
        if (minDistance == 0){
            res = new Position[1];
            int dx = (target.getX() > this.getPosition().getX()) ? maxDistance : -maxDistance;
            int dy = (target.getY() > this.getPosition().getY()) ? maxDistance : -maxDistance;
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
                    currentX += (target.getX() > this.getPosition().getX()) ? 1 : -1;
                } else { // if its not the minimum then we move by maxDistance/minDistance
                    currentX += (target.getX() > this.getPosition().getX()) ? maxDistance/minDistance : -(maxDistance/minDistance);
                }
            } else {
                if (minDistance == totalYDistance){
                    currentY += (target.getY() > this.getPosition().getY()) ? 1 : -1;
                } else {
                    currentY += (target.getY() > this.getPosition().getY()) ? maxDistance / minDistance : -(maxDistance / minDistance);
                }
            }
            res[i] = new Position(currentX, currentY);
        }

        // treating the last position for the rest
        if (isRest){
            if(minDistance == totalXDistance){
                currentY += (target.getY() > this.getPosition().getY()) ? reste : -reste;
            } else if (minDistance == totalYDistance){
                currentX += (target.getX() > this.getPosition().getX()) ? reste : -reste;
            }
        }
        res[i] = new Position(currentX, currentY);
        return res;
    }


    void getStats(Position target){
        System.out.println("Remaining energy: "+this.energy+" ");
        System.out.println("Cost of current movement: "+(this.distance(target) * this.cost)+" ");
        System.out.println("Current position: ("+this.position.getX()+" , "+this.position.getY()+") \n");

        System.out.println("Target position: ("+target.getX()+" , "+target.getY()+") ");
        System.out.println("Distance between our robot and target: "+this.distance(target)+" ");
    }


}
