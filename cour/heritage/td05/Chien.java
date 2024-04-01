public class Chien extends Mammifere {
    public Chien(String name){
        super(name);
    }



    @Override
    public void crier(){
        System.out.println("woof, woof");
    }



    @Override
    public String toString(){
        return getClass().getSimpleName()+" "+super.toString();
    }
}
