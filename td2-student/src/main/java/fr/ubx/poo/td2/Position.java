package fr.ubx.poo.td2;

public class Position {
    private int x;
    private int y;

    public int getX(){ return this.x ; }
    public int getY(){ return this.y ; }


    public void translate(int dx, int dy){
        this.x += dx;
        this.y += dy;
    }


    public void translate(int delta){
        this.x += delta;
        this.y += delta;
    }

    public Position (Position p){
        this.x = p.x;
        this.y = p.y;
    }

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
