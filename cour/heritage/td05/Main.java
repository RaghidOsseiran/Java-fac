public class Main {
    public static void main(String[] args) {
        Animal a1 = new Animal("abdul", 9);
        a1.afficher();
        a1.crier();

        System.out.println();

        Animal a2 = new Mammifere("Ibrahim");
        a2.afficher();
        a2.crier();

        System.out.println();

        Mammifere m1 = new Mammifere("Baker");
        m1.afficher();
        m1.crier();

        System.out.println();

        Mammifere m2 = new Chat("chantaf");
        m2.afficher();
        m2.crier();

        System.out.println();

        Mammifere m3 = new Chien("rayan");
        m3.afficher();
        m3.crier();

        System.out.println();

        Animal m4 = new Chat("fatayerji");
        m4.afficher();
        m4.crier();


        Zoo z1 = new Zoo(20);
        z1.addAnimal(m1);
        z1.addAnimal(m2);

        System.out.println("Zoo animals: ");
        z1.afficher();
        z1.crier();
    }
}
