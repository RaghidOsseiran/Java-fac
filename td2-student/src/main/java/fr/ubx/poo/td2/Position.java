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

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj instanceof Position){
            Position i = (Position)obj;
            return this.x == i.x && this.y == i.y;
        }
        return false;
    }

}
