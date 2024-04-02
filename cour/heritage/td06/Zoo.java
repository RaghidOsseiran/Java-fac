import java.util.Random;

import javax.swing.event.AncestorEvent;

public class Zoo implements IZoo {
    private final int maxCage = 20;
    private final int minCage = 10;
    private final Random r = AAnimal.r;
    private AAnimal[] cages;

    public Zoo(){
        this.cages = new AAnimal[r.nextInt(minCage, maxCage)];
    }


    private boolean checkValidIndex(int indx){
        return (indx >= 0 && indx < cages.length);
    }

    public Zoo(int nbCages){
        if (nbCages < minCage || nbCages > maxCage) throw new ZooException("invalid amount of cages");
        this.cages = new AAnimal[nbCages];
    }

    public int getCageSize(){
        return cages.length;
    }

    @Override
    public void afficher(){
        System.out.println(this.toString());
    }

    @Override
    public void crier(){
        for(AAnimal a: cages){
            if (a != null){
                a.crier();
            } 
        } 
    }

    public void getAgeAnimaux(){
        for(AAnimal a: cages){
            if (a != null){
                System.out.println(a.getAge()+"\n");
            }
        }
    }

    public void ageAllAnimals(){
        for(int i = 0 ; i < cages.length; i++){
            if(cages[i] != null){
                cages[i].veillir();
                if(cages[i].getifDead()) cages[i] = null;
            }
        }
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        for(AAnimal a: cages){
            if (a != null) res.append(a.toString()).append("\n");
        };
        return res.toString();
    }



    public void addAnimal(AAnimal a, int indx) throws ZooException{
        if (checkValidIndex(indx)){
            cages[indx] = a;
        } else throw new ZooException("Invalid index for the number of the cage");
    }

    public void addAnimal(AAnimal a) throws ZooException{
        int i = 0;
        while(i < cages.length && cages[i] != null){
            i++;
        }
        if (i != cages.length) cages[i] = a;
        else throw new ZooException("could add new animal to the cage, since it is full!");
    }


    public AAnimal getAnimal(int indx) throws ZooException{
        if(checkValidIndex(indx)) return cages[indx];
        else throw new ZooException("Invalid read from cage");
    }

    public void removeAnimal(int indxRemove){
        if (checkValidIndex(indxRemove)){
            cages[indxRemove] = null;
        }
    }

    public void desastre(){
        int indxRand = r.nextInt(0, cages.length);
        if (cages[indxRand] != null){
            int arracheRand = r.nextInt(0, 1);
            if (arracheRand == 0) cages[indxRand].arracheAile();
            else cages[indxRand].arrachePate();
        }
    }

    public int getNbAilles(){
        int res = 0;
        for(AAnimal a: cages){
            if (a != null){
                res += a.getNbAiles();
            }
        }
        return res;
    }

    public int getNbPates(){
        int res = 0;
        for(AAnimal a: cages){
            if (a != null){
                res += a.getPates();
            }
        }
        return res;
    }

}
