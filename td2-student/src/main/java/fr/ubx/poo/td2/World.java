package fr.ubx.poo.td2;

import model.Position;

public class World {
    public static final int EMPTY = 0;
    public static final int ROCK = 1;
    public static final int DUST = 2;

    public final int width;
    public final int height;

    private double percentageRock;
    private double percentageDust;


    private final int[][] map;

    public World(int width, int height){
        this.width = width;
        this.height = height;
        this.map = new int[height][width];
    }

    public World(int width, int height, double percentageRock, double percentageDust){
        this(width, height);
        this.percentageDust = percentageDust;
        this.percentageRock = percentageRock;
    }

    public double getPercentageDust() {
        return this.percentageDust;
    }

    public double getPercentageRock() {
        return this.percentageRock;
    }

    public int get(Position position){
        if (position.x() < this.height && position.y() < this.width){
            return map[position.x()][position.y()];
        }
        return 0;
    }

    public void set(Position position, int kind){
        if (position.x() < this.width && position.y() < this.height && (kind >=0 && kind <= 2) ){
            map[position.x()][position.y()] = kind;
        }
    }
    public boolean isRock(Position pos){
        if (pos.x() < 0 || pos.x() > this.width || pos.y() < 0 || pos.y() > this.height) return true;
        if (map[pos.x()][pos.y()] == 1) return true;
        return false;
    }
}
