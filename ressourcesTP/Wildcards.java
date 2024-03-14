import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Wildcards {
    public static void main(String[] args) {
        List<Integer> intList= new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        Iterator<Integer> iterator = intList.iterator();
        printList(intList, iterator);
    }

    private static void printList(List<?> myList, Iterator<?> iterator){
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
