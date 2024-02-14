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


    private int[][] map;

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
        if (position.x() < this.height && position.y() < this.width && (kind >=0 && kind <= 2) ){
            map[position.x()][position.y()] = kind;
        }
    }
}
