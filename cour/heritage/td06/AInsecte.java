public abstract class AInsecte extends AAnimal{
    private static final int nbPatesInsecte = 6;
    private static final int esperenceDeVieInsect = 5;

    public AInsecte(String name, int nbAiles){
        super(name, nbPatesInsecte, nbAiles, esperenceDeVieInsect);
    }
}
