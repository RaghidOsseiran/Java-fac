public abstract class AOiseau extends AAnimal{
    private static final int nbPatesOiseau = 2;
    private static final int nbAilesOiseau = 2;
    private static final int esperenceDeVieOiseau = 12;

    public AOiseau(String name){
        super(name, nbPatesOiseau, nbAilesOiseau, esperenceDeVieOiseau);
    }
}
