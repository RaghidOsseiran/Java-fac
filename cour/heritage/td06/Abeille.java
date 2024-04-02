public class Abeille extends AInsecte{
    

    public Abeille(String name, int nbAiles){
        super(name, nbAiles);
    }

    @Override
    public void crier(){
        System.out.println("bzzz bzzz");
    }
}
