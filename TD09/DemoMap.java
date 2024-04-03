import java.util.HashMap;
import java.util.Map;

/**
 * shows how to use  large number of objects in maps
 * at least how we should expect to use...
 * But something is broken
 */
public class DemoMap {

    public static void main(String[] args) {
        System.out.println("Please wait, this might take a little while.");

        Map<StupidBo, String> stupids_map = new HashMap<>(50000, 0.9f);
        Map<String, String> simple_map = new HashMap(100000);

        for (long l = 0; l < 10000; l++) {
            StupidBo bo = new StupidBo();
            bo.setCounter((int) Math.ceil(l / 1000));
            bo.setMessage("Bo = " + l);
            stupids_map.put(bo, "counter = " + l);
            simple_map.put("Key" + l, "counter=" + l);
        }

        StupidBo another = new StupidBo();
        another.setCounter(42);
        another.setMessage("can you find me");
        stupids_map.put(another, "found");


        simple_map.put("key007", "counter007");
        long start = System.nanoTime();
        stupids_map.containsKey(another);
        long stop = System.nanoTime();

        System.out.println("Elapsed time for stupid containsKey = " + (stop - start) / 1000);

        start = System.nanoTime();
        simple_map.containsKey("key007");
        stop = System.nanoTime();
        System.out.println("Elapsed time for simple_map containsKey = " + (stop - start) / 1000);

        System.out.println("The end!");
    }
}
