import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Printer<Integer> printer = new Printer<>(23);
        printer.print();

        Printer<String> printer1 = new Printer<>("Hello world");
        printer1.print();
    }
}
