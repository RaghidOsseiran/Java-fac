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
    Position[] getPathTo(Position target) {
        int totalXDistance = Math.abs(target.getX() - this.position.getX());
        int totalYDistance = Math.abs(target.getY() - this.position.getY());
        int totalSteps = totalXDistance + totalYDistance;
        Position[] res = new Position[totalSteps];
        int currentX = this.getPosition().getX();
        int currentY = this.getPosition().getY();

        int step = 0;
        while (step < totalSteps) {
            // Determine whether to move in X or Y based on the ratio of distances left to cover
            boolean moveInX = (totalXDistance > 0) && ((step % (totalXDistance + totalYDistance) < totalXDistance) || totalYDistance == 0);
            // we calculate the remainder when the current step number is divided by the sum of the remaining horizontal and vertical distances.
            // the idea is to ensure that horizontal moves are made as long as the remainder is less then the total horizontal distance hat needs
            // to be covered
            if (moveInX) {
                currentX += (target.getX() > this.getPosition().getX()) ? 1 : -1;
                totalXDistance--;
            } else {
                currentY += (target.getY() > this.getPosition().getY()) ? 1 : -1;
                totalYDistance--;
            }

            res[step] = new Position(currentX, currentY);
            step++;
        }
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
