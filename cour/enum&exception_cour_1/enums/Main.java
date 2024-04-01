public class Main {
    public static void main(String[] args) {
        TypeFruit tp = new TypeFruit("bomboclat", Color.red);
        tp.popFruit(Color.red);
        System.out.println(tp.popFruit(Color.red, "abdu"));
    }
}
