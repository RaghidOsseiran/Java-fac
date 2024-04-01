public class Mammifere extends Animal{
    private static final int nbPates = 4;

    public Mammifere(String name){
        super(name, nbPates);
    }

    @Override
    public String toString(){
        return this.getName()+", mammifere a "+this.getPates()+ " patte(s)";
    }
}
