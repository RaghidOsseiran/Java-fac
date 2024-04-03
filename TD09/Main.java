import fr.ubx.poo.td9.Point;

import java.lang.Math;
import java.nio.channels.Pipe;
import java.util.*;

import static java.util.Collections.sort;

public class Main {
    public static Random r = new Random();
    
    public static void main(String[] args) {
        List<Point> arrayL = createRandomArray(1000000, 0, 100);
        List<Point> linkedL = createRandomLinked(1000000, 0, 100);

//        Point p1 = new Point(2, 3);
//        testArrayL.add(p1);
//        testArrayL.add(p1);
//        testArrayL.add(p1);
//        testArrayL.add(p1);
//
//        Point p2 = new Point(4, 3);
//        testLinkedL.add(p2);
//        testLinkedL.add(p2);
//        testLinkedL.add(p2);
//        testLinkedL.add(p2);
//
//        printAllPoints(testArrayL);
//        printAllPoints(testLinkedL);

//        translateFor(arrayL);
//        System.out.println("Time for arrayL :");      modifyMiddle(arrayL);
//        System.out.println("Time for linkedL :");     modifyMiddle(linkedL);
//        System.out.println("Removed in arrayL :");    removeInsideDisk(arrayL, new Point(0, 0), 50);
//        System.out.println("Removed in linkedL :");   removeInsideDisk(linkedL, new Point(0, 0), 50);


//        List<Point> lkL = createRandomLinked(1000000, -50, 50);
//        List<Point> arL = createRandomArray(1000000, -50, 50);
//
//        System.out.println("Time for arrayL for circle :");  removeInsideDisk(arL, new Point(0, 0), 50);
//        System.out.println("Time for linkedL for circle :");  removeInsideDisk(lkL, new Point(0, 0), 50);


        List<Point> l1 = new ArrayList<>();
        l1.add(new Point(1, 4));
        l1.add(new Point(10,2));
        l1.add(new Point(0, 9));
        l1.add(new Point(1, 3));
        l1.add(new Point(9, 10));


//        List<Point> l2 = new ArrayList<>();
//        l2.add(new Point(3,2));
//        l2.add(new Point(7,8));
//
//        printAllPoints(entrelacementIndice(l1, l2));


        // SYNTAX CLASSE ANONYME
//        sort(l1, new Comparator<Point>() {
//            @Override
//            public int compare(Point o1, Point o2) {
//                if (o1.getX() < o2.getX()){
//                    return -1;
//                } else if (o1.getX() == o2.getX()){
//                    return Integer.compare(o1.getY(), o2.getY());
//                } else return 1;
//            }
//        });


        // SYNTAX FONCTION LAMBDA


        sort(l1, (p1, p2) -> {
            if (p1.getX() < p2.getX()) return -1;
            else if (p1.getX() == p2.getX()) return Integer.compare(p1.getY(), p2.getY());
            else return 1;
        });



        printAllPoints(l1);
    }

    public static void printAllPoints(List<Point> testLinkedL) {
        Iterator<Point> iterator = testLinkedL.iterator();
        while(iterator.hasNext()) System.out.println(iterator.next());
    }

    public static List<Point> createRandomArray(int n, int origin, int end){
        ArrayList<Point> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            res.add(new Point(r.nextInt(origin, end) , r.nextInt(origin, end)));
        }
        return res;
    }

    public static List<Point> createRandomLinked(int n, int origin, int end){
        LinkedList<Point> res = new LinkedList<>();
        for(int i = 0; i < n; i++){
            res.add(new Point(r.nextInt(origin, end) , r.nextInt(origin, end)));
        }
        return res;
    }

    public static void translateFor(List<Point> lp){
        for(int i = 0 ; i < lp.size(); i++){
            if(lp.get(i) != null) lp.get(i).translate(-50, 50);
        }
    }

    public static void translateIterator(List<Point> lp){
        Iterator<Point> iterator = lp.iterator();
        while(iterator.hasNext()) iterator.next().translate(-50, 50);
    }

    public static void translateEnhancedFor(List<Point> lp) {
        for (Point point : lp) {
            if(point != null) point.translate(-50, 50);
        }
    }

    public static void modifyMiddle(List<Point> lp){
        long start = System.nanoTime();
        for(int i = 0; i < 100000; i++){
            lp.get(lp.size()/2).translate(-50, 50);
        }
        long stop = System.nanoTime();
        System.out.println("Elapsed time : " + (stop - start)/1000);
    }

    public static int removeInsideDisk(List<Point> l, Point c, int r){
        long start = System.nanoTime();
        int nbRemoved = 0;
        for(int i = 0 ; i < l.size(); i++){
            if (l.get(i) != null){
                double distBetween = Math.sqrt(Math.pow((l.get(i).getX() - c.getX()),  2)   +   Math.pow((l.get(i).getY() - c.getY()) , 2));
                if (distBetween > r) l.remove(l.get(i)); nbRemoved++;
            }
        }
        long stop = System.nanoTime();
        System.out.println("Elapsed time: " + (stop - start)/1000);
        return nbRemoved;
    }

    public static List<Point> entrelacementIndice(List<Point> l1, List<Point> l2){
        ArrayList<Point> res = new ArrayList<>();
        int i1 = 0;
        int i2 = 0;
        while (i1 < l1.size() && i2 < l2.size()){
            if (l1.get(i1).compareTo(l2.get(i2)) < 0){
                res.add(l1.get(i1));
                i1++;
            } else {
                res.add(l2.get(i2));
                i2++;
            }
        }
        while (i1 < l1.size()){
            res.add(l1.get(i1));
            i1++;
        }
        while (i2 < l2.size()){
            res.add(l2.get(i2));
            i2++;
        }
        return res;
    }



}
