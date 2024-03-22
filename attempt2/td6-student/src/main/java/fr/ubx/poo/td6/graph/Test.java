package fr.ubx.poo.td6.graph;

import fr.ubx.poo.td6.model.Grid;
import fr.ubx.poo.td6.model.GridRepoString;
import fr.ubx.poo.td6.model.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        GridRepoString testGrid = new GridRepoString();
        Grid grid = testGrid.load("GRDRGxGCBCDxGCCGBxRDDGDx");
        Graph<Position> graph = grid.getGraph();
        Node<Position> start = graph.getNode(new Position(0,0));
        Node<Position> dest = graph.getNode(new Position(2,0));
        Position[] best_path = graph.aStar(start, dest);
        if (best_path == null){
            System.out.println("no shortest path");
            return;
        }
//        for(Node<Position> node: set){
//            graph.setNodesCost(start, dest);
//            if (!node.equals(start) && !node.equals(dest)){
//                System.out.println(
//                        "f cost:"+node.fCost + " g cost:"+ node.gCost+ " "+ node.getData() + "."
//                );
//            }
//        }
    }

}
