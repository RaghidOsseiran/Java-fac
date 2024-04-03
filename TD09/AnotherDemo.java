import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AnotherDemo {
    public static void main(String[] args) throws InterruptedException {
        AnotherBo bo = new AnotherBo("toto", "somewhere in the space", "12/12/1942");
        Map myHashMap = new HashMap<AnotherBo, String>();
        Map myTreeMap = new TreeMap<AnotherBo, String>();
        myHashMap.put(bo, "kiki etait coco...");
        myTreeMap.put(bo, "kiki etait coco...");
        System.out.println("B.O is in the HashMap : " + myHashMap.containsKey(bo));
        System.out.println("B.O is in the TreeMap : " + myTreeMap.containsKey(bo));
        System.out.print("Waiting few seconds ");

        for (int i = 1; i < 10; i++) {
            System.out.print(".");
            Thread.sleep(300);
        }
        System.out.println();
        System.out.println("Ok now!");

        System.out.println("B.O is in the HashMap : " + myHashMap.containsKey(bo));
        System.out.println("B.O is in the TreeMap : " + myTreeMap.containsKey(bo));

        System.out.println("The end!");
    }
}
