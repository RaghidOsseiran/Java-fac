public class Robot {
    String name;
    Position p;
    double energie;
    double cout;

    double rayonAction(){
        double res = this.energie/this.cout;
        return res;
    }

    boolean peutSeDeplacer(Position cible){
        double distance = this.distance(cible);
        if (distance > this.rayonAction()) return false;
        return true;
    }

    int distance(Position cible){
        int res = Math.abs(cible.x - this.p.x) + Math.abs(cible.y - this.p.y);
        return res;
    }


    void afficher(){
        System.out.println("Robot curiosity");
        System.out.println("Position: ("+this.p.x+","+this.p.y+")");
        System.out.println("Energie: "+this.energie+"");
        System.out.println("Cout: "+this.cout+"");
    }


    boolean deplacer(Position cible){
        if (this.peutSeDeplacer(cible)){
            this.energie -= this.distance(cible) * this.cout; // car on se deplacer distance fois le cout
            this.p = cible;
            return true;
        }
        return false;
    }

    Robot(Position p, String name, double energie, double cout){
        this.p = p;
        this.name = name;
        this.energie = energie;
        this.cout = cout;
    }
}
