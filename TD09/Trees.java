import java.util.*;
import java.util.function.Predicate;

import fr.ubx.poo.td9.Point;
public class Trees {
    public static Random r = new Random();
    public static void main(String[] args) {
        Set<Point> set = new TreeSet<>((p1, p2) -> {
            if (p1.getX() < p2.getX()) return -1;
            else if (p1.getX() == p2.getX()) return Integer.compare(p1.getY(), p2.getY());
            else return 1;
        });

        //set.add(new Point(0, 0)); pour que cette modification soit possible on doit passer le comparateur de point pour que les points puisse etre ordonnes.
        addRandomPoints(10000, 0, 100, set);
        System.out.println(set.size()); // la taille apres les ajouts est environ de 6274
        // cela est expliquer par le fait que les set ne peux pas avoir des doublons.


        Set<Point> set2 = new TreeSet<>((p1, p2) -> {
            if (p1.getX() < p2.getX()) return -1;
            else if (p1.getX() == p2.getX()) return Integer.compare(p1.getY(), p2.getY());
            else return 1;
        });

//        selection(set, set2, (x -> x.getX() < 20));
        selection(set, set2, x -> insideDisk(x, new Point(0, 0), 50));
        printAllPoints(set2);

    }

    public static <T> void printAllPoints(Set<T> set){
        for (T t : set)
            if(t != null)
                System.out.println(t);
    }


    public static void addRandomPoints(int n, int origin, int end, Set<Point> set){
        for(int i = 0 ; i < n ; i++){
            set.add(new Point(r.nextInt(origin, end), r.nextInt(origin, end)));
        }
    }

    public static <T> void selection(Collection<T> collIn, Collection<T> collOut, Predicate<T> f){
        for(T e: collIn){
            if (f.test(e))
                collOut.add(e);
        }
    }

    public static boolean insideDisk(Point p, Point c, int r){
        double distBetween = Math.sqrt(Math.pow((p.getX() - c.getX()),  2)   +   Math.pow((p.getY() - c.getY()) , 2));
        return (distBetween <= r);
    }

}
