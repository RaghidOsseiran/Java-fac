public class Test {
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Test(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private int x;
    private int y;


    void afficher(){
        System.out.println("coordinates: ("+this.x+","+this.y+")");
    }
}
