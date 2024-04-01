public class TypeFruit {
    private String name;
    private Color color;

    public TypeFruit(String name, Color color){
        this.name = name;
        this.color = color;
    }    

    @Override
    public String toString(){
        return name+" "+color;
    }


    public void popFruit(Color color){
        if (this.color.equals(color)) System.out.println("POP, you have the same colors");
        else System.out.println(":(, No pop different colors.");
    }

    public String popFruit(Color color, String name){
        if (this.color.equals(color)) return this.name + " and, "+name+" have the same colors";
        else return this.name+ "and, "+name+"don't have the same colors";
    }
    
}
