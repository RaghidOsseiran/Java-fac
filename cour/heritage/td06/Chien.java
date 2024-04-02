public class Chien extends AMammifere {
    public Chien(String name){
        super(name);
    }



    @Override
    public void crier(){
        System.out.println("woof, woof");
    }

}
