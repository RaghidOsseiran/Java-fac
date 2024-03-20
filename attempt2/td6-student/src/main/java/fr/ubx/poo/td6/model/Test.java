package fr.ubx.poo.td6.model;

import fr.ubx.poo.td6.graph.Graph;
import fr.ubx.poo.td6.graph.Node;

import java.io.*;
import java.util.List;
import java.util.Set;

public class Test {
    public static void main(String[] args) throws IOException {
//        GridRepoString test = new GridRepoString();
//        Grid to = test.load("BBBxEEBxGGBxGBBx");
//        GridRepoStringRLE testt = new GridRepoStringRLE();
//       System.out.println(testt.export(to));
//
//        Writer out = null;
//        try(Reader in = new FileReader("/home/raghid/Desktop/S4L2/Poo/Java-fac/attempt2/td6-student/src/main/java/fr/ubx/poo/td6/model/game.txt")){ // try with resources
//            // no need  to close since Reader is auto closable
//            Grid to2 = testt.load(in);
//            print_grid(to2);
//            to2.set(2, 0, Entity.CRACK);
//            out = new FileWriter("/home/raghid/Desktop/S4L2/Poo/Java-fac/attempt2/td6-student/src/main/java/fr/ubx/poo/td6/model/game.txt");
//            testt.export(to2, out);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } finally {
//            if (out != null) out.close();
//        }
//    }

//    public static void print_grid(Grid g){
//        for(int i = 0 ; i < g.getHeight(); i++){
//            for(int j = 0 ; j < g.getWidth(); j++){
//                System.out.print(g.get(j, i)+ " ");
//            }
//            System.out.println();
//        }
//        Entity t = Entity.ENERGY;
//        System.out.println(t.isAccessible());


        GridRepo test = new GridRepoString();
        Grid gridGraph = test.load("BBBBxBBBBxBBCCx");
        Graph<Position> graph = gridGraph.getGraph();
        Set<Node<Position>> set = graph.getNodes();
        for(Node<Position> node: set){
            System.out.println("Graph nodes: "+node.getData().toString());
            List<Node<Position>> list = node.getNeighbours();
            for(Node<Position> adjNodes: list){
                System.out.println("Adjacent node: "+ adjNodes.getData().toString());
            }
        }
    }

}
