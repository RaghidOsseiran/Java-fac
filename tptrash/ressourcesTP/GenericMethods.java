public class GenericMethods {
    public static void main(String[] args) {
        shout(23.2);
    }

    private static <T> void shout(T thingToShout){
        System.out.println(thingToShout + "!!!!!");
    }
}
