public abstract class AMammifere extends AAnimal{
    private static final int nbPatesMammifere = 4;
    private static final int nbAilesMammifere = 0;
    private static final int esperenceDeVieMami = 10;

    public AMammifere(String name){
        super(name, nbPatesMammifere, nbAilesMammifere, esperenceDeVieMami);
    }

    @Override
    public abstract void crier();
}
