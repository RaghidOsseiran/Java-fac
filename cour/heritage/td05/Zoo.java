import java.util.Random;

import javax.swing.event.AncestorEvent;

public class Zoo implements IZoo {
    private final int maxCage = 20;
    private final int minCage = 10;
    private final Random r = new Random();
    private int currentIndx = 0;
    private Animal[] cages;

    public Zoo(){
        this.cages = new Animal[r.nextInt(maxCage - minCage)+minCage];
    }


    public Zoo(int nbCages){
        if (nbCages < minCage || nbCages > maxCage) throw new ZooException("invalid amount of cages");
        this.cages = new Animal[nbCages];
    }

    @Override
    public void afficher(){
        System.out.println(this.toString());
    }

    @Override
    public void crier(){
        for(Animal a: cages){
            if (a != null){
                a.crier();
            } 
        } 
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        for(Animal a: cages){
            if (a != null) res.append(a.toString()).append("\n");
        };
        return res.toString();
    }


    public void addAnimal(Animal a){
        if (currentIndx < cages.length){
            cages[currentIndx] = a;
            currentIndx++;
        }
    }

    public void removeAnimal(int indxRemove){
        if (indxRemove > 0 && indxRemove < cages.length){
            cages[indxRemove] = null;
        }
    }

}
