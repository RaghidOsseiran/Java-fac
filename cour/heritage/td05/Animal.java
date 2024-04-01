public class Animal implements IAnimal {
    private String name;
    private int nbPates;



    public String getName(){
        return this.name;
    }

    public int getPates(){
        return this.nbPates;
    }

    public Animal(String name, int nbPates){
        this.name = name;
        this.nbPates = nbPates;
    }

    @Override
    public void crier(){
        System.out.println("hmm, hmm");
    }

    @Override
    public void afficher(){
        System.out.println(this.toString());
    }


    @Override
    public String toString(){
        return name+", animal a, "+nbPates+" pattes.";
    }
}
