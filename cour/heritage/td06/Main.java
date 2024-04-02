public class Main {
    public static void main(String[] args) {
        AAnimal a1 = new Pigeon("3osfour");
        AAnimal a2 = new Chien("Serberus");
        AAnimal a3 = new Chat("Abdoul");
        AAnimal a4 = new Abeille("BzzzikTare", 5);


        try{
            Zoo zoo = new Zoo(10);
            System.out.println(zoo.getCageSize());
            zoo.addAnimal(a1, 0);
            zoo.addAnimal(a2, 1);
            zoo.addAnimal(a3, 2);
            zoo.addAnimal(a4, 3);

        } catch (ZooException e){
            System.out.println(e.getMessage());
        }

        System.out.println("End of program!");
    }
}
