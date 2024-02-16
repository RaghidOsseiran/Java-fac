package model;

import fr.ubx.poo.td2.World;

import java.util.ArrayList;

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
        int tx = Math.abs(target.x() - this.position.x()); int ty = Math.abs(target.y() - this.position.y());

        int md = Math.min(tx, ty); int mxd = Math.max(tx, ty);

        int currentX = this.getPosition().x(); int currentY = this.getPosition().y();

        Position[] res;

        // we treat the cases where we only move in 1 direction so then the minimum would be 0, and dividing by 0 would cause errors.
        if (md == 0){
            res = new Position[1];
            int dx = (target.x() > currentX) ? mxd : -mxd;
            int dy = (target.y() > currentY) ? mxd : -mxd;
            if (tx == 0){
                res[0] = new Position(currentX, currentY+dy);
            } else {
                res[0] = new Position(currentX+dx, currentY);
            }
            res = rockInMyWay(res, this.position.x(), this.position.y());
            if (res.length == 1 && this.position.equals(res[0])) return new Position[0];
            return res;
        }
        // in case where the total number of steps is uneven we calculate the number of extra steps in the variable res.
        int reste = mxd % md;
        if (reste != 0) isRest = true;
        int i = 0;
        res = new Position[md*2+1]; // the + 1 for the case where there is a rest
        for(i = 0; i < md*2; i++){
            if (i%2 == 0){
                // its always the minimum that has to move by 1 or -1
                if (md == tx){
                    currentX += (target.x() > currentX) ? 1 : -1;
                } else { // if its not the minimum then we move by maxDistance/minDistance
                    currentX += (target.x() > currentX) ? mxd/md : -(mxd/md);
                }
            } else {
                if (md == ty){
                    currentY += (target.y() > currentY) ? 1 : -1;
                } else {
                    currentY += (target.y() > currentY) ? mxd / md : -(mxd / md);
                }
            }
            res[i] = new Position(currentX, currentY);
        }

        // treating the last position for the rest
        if (isRest){
            if(md == tx){
                currentY += (target.y() > currentY) ? reste : -reste;
            } else if (md == ty){
                currentX += (target.x() > currentX) ? reste : -reste;
            }
        }
        res[i] = new Position(currentX, currentY);
        for(int j = 0 ; j < res.length; j++){
            System.out.println("res["+j+"], "+this+": (x: "+res[j].x()+" ,y: "+res[j].y()+")");
        }
        res = rockInMyWay(res, this.position.x(), this.position.y());
        if (res.length == 1 && this.position.equals(res[0])) return new Position[0];
        return res;
    }

    @Override
    public void getStats(Position target){
        super.getStats(target);
        System.out.println("Distance between our robot and target: "+this.distance(target)+" ");
    }


    public Position[] rockInMyWay(Position[] posTab, int initX, int initY) {
        if (posTab == null) return null;
        boolean rockFound = false;
        ArrayList<Position> tmp = new ArrayList<>(); // using array lists since we dont know how many positions we will have at then end

        for(int i = 0; i < posTab.length; i++){
            if (rockFound) break;
            int dx = (posTab[i].x() > initX) ? 1 : -1;
            int dy = (posTab[i].y() > initY) ? 1 : -1;
            while(initX != posTab[i].x()){
                Position nextMove = new Position(initX+dx, initY);
                if (world.isRock(nextMove)) {
                    rockFound = true;
                    break;
                } else {
                    initX+= dx;
                }
            }

            while(initY != posTab[i].y()){
                Position nextMove = new Position(initX, initY+dy);
                if (world.isRock(nextMove)) {
                    rockFound = true;
                    break;
                } else {
                    initY+= dy;
                }
            }
            tmp.add(new Position(initX, initY));
        }

        Position[] ret = tmp.toArray(new Position[0]);
        System.out.println("new position's after rock detection: ");
        for(int i = 0 ; i < ret.length; i++){
            System.out.println("res["+i+"], "+this+": (x: "+ret[i].x()+" ,y: "+ret[i].y()+")");
        }
        return ret;
    }
}
