public class TestRobot {
    public static void main(String[] args) {
        Position p1 = new Position(2, 2);
        Robot r1 = new Robot(p1, "broski", 600, 10);
        r1.afficher();

        Position p2 = new Position(30, 30);
        Robot r2 = new Robot(p2, "cous", 200, 15);
        double rA = r1.rayonAction();
        System.out.println("the range of action of the robot: "+r1.name+" is: "+ rA);
        if (r1.peutSeDeplacer(r2.p)) System.out.println("Our robot can in fact reach its destination");
        r1.deplacer(r2.p);
    }
}
