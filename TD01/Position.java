public class Position {
    int x;
    int y;
    void afficher(){
        System.out.println("("+this.x+","+this.y+")");
    }

    void deplacement (int dx, int dy){
        this.x += dx;
        this.y += dy;
    }

    void deplacement(int delta){
        this.x += delta;
        this.y += delta;
    }



    Position(int x, int y){
        this.x = x;
        this.y = y;
    }
}
