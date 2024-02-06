package fr.ubx.poo.td2;

public class TestPosition {
    public static void main(String[] args) {
        Position p1 = new Position(2, 2);
        Position p2 = new Position(3, 3);
        Position p3 = new Position(4, 5);
        Position p4 = new Position(5, 4);
        Position p5 = new Position (p1);
        boolean ok = true;

        if (p1.equals(p2) || p3.equals(p4) || !p1.equals(p5)){
            ok = false;
        }

        if (ok){
            System.out.println("Tests passed !");
        } else {
            System.out.println("Tests failed !");
        }
    }
}
