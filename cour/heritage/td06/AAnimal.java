import java.util.Random;

public abstract class AAnimal implements IAnimal {
    private String name;
    private int nbPates;
    private int nbAiles;

    public static final Random r = new Random();

    private int age = 0;
    private int esperenceDeVie;

    private boolean isDead = false;

    public int getAge(){
        return this.age;
    }

    public int getEsperenceDeVie(){
        return this.esperenceDeVie;
    }

    public boolean getifDead(){
        return this.isDead;
    }

    public int getNbAiles(){
        return this.nbAiles;
    }

    public String getName(){
        return this.name;
    }

    public int getPates(){
        return this.nbPates;
    }

    public AAnimal(String name, int nbPates, int nbAiles, int esperenceDeVie){
        this.name = name;
        this.nbPates = nbPates;
        this.nbAiles = nbAiles;
    }

    @Override
    public abstract void crier();

    public void veillir(){
        if (age >= esperenceDeVie){
            int rand = r.nextInt(0, 1);
            if (rand == 0) this.isDead = true;
        }
        age++;
    }

    @Override
    public void afficher(){
        System.out.println(this.toString());
    }

    @Override
    public String toString(){
        return getClass().getSimpleName()+" "+name+", "+getClass().getSuperclass().getSimpleName().toLowerCase()+" a "+nbPates+" patte(s) et "+nbAiles+ " aile(s).";
    }

    @Override
    public void arrachePate(){
        if (this.nbPates > 0){
            this.nbPates--;
            this.crier();
            System.out.println();
        }
    }

    @Override
    public void arracheAile(){
        if (this.nbAiles > 0){
            this.nbAiles--;
            this.crier();
            System.out.println();
        }
    }


}
