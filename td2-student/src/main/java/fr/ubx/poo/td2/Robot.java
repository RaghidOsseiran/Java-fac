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

        for(int i = 0; i < totalSteps; i++){
            // we use a very basic alternation methode which is i % 2, if i is even then we move horizontally
            // if not then vertically.
            if (i % 2 == 0){
                currentX += (target.getX() > this.position.getX()) ? 1 : -1; // we check to see if we have to move
                // to the right or to the left based on the targets position and our position
            } else {
                currentY += (target.getY() > this.position.getY()) ? 1 : -1; // same as the x
            }
            res[i] = new Position(currentX, currentY);
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
