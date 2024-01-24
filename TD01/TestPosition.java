public class TestPosition {
    public static void main(String[] args) {
        Position p1 = new Position(2, 4);
        p1.afficher();
        p1.deplacement(2, 2);
        p1.afficher();
        p1.deplacement(4);
        p1.afficher();
    }
}
