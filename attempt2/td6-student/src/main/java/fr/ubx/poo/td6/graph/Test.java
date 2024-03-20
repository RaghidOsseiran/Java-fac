package fr.ubx.poo.td6.graph;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node4 = new Node<>(1);
        node1.addEdge(node2);
        node1.addEdge(node3);
        node1.addEdge(node4);
        List<Node<Integer>> test = node1.getNeighbours();
        test.forEach(s -> {
            System.out.println(s.getData());
        });

        System.out.println(node1.equals(node4));
    }

}
