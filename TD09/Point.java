package fr.ubx.poo.td9;

public class Point implements Comparable<Point> {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point position) {
        this(position.x, position.y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void translate(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (o instanceof Point) {
            Point position = (Point) o;
            return position.x == this.x && position.y == this.y;
        }
        return false;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    @Override
    public int compareTo(Point o) {
        if (this.x < o.getX()) return -1;
        else if (this.x == o.getX()){
            return Integer.compare(this.y, o.getY());
        }
        else return 1;
    }
}
