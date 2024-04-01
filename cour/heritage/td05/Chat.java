public class Chat extends Mammifere {
    public Chat(String name){
        super(name);
    }

    @Override
    public void crier(){
        System.out.println("meow, meow");
    }


    @Override
    public String toString(){
        return getClass().getSimpleName()+" "+super.toString();
    }
}
