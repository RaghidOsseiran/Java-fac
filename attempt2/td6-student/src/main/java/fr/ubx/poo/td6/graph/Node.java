package fr.ubx.poo.td6.graph;

import fr.ubx.poo.td6.model.Position;

import java.util.*;

public class Node<T> {
    private final T data;
    private final List<Node<T>> neighbours;

    public double g;
    public double f;

    public Node(T data) {
        neighbours = new ArrayList<>();
        this.data = data;
    }

    private List<Node<T>> cloneNeigh(List<Node<T>> neigh){
        return new ArrayList<>(neigh);
    }


    public boolean isNeighbour(Node<T> to){
        if (to == null) return false;
        for(Node<T> node: neighbours){
            if (node != null && node.equals(to)) return true;
        }
        return false;
    }

    public T getData() {
        return this.data;
    }
    public void addEdge(Node<T> to) {
        if (to == null) return;
        if (!this.isNeighbour(to)) neighbours.add(to);
    }
    public List<Node<T>> getNeighbours() {
        return cloneNeigh(neighbours);
    }


    public void checkContourage(Graph<Position> graph, Node<Position> node){
        Position[] adjancentNodes = {
                new Position(node.data.x()-1, node.data.y()-1),
                new Position(node.data.x(), node.data.y()-1),
                new Position(node.data.x()+1, node.data.y()-1),
                new Position(node.data.x()-1, node.data.y()),
                new Position(node.data.x()+1, node.data.y()),
                new Position(node.data.x()-1, node.data.y()+1),
                new Position(node.data.x(), node.data.y()+1),
                new Position(node.data.x()+1, node.data.y()+1),
        };
        Set<Node<Position>> set = graph.getNodes();
        for(Node<Position> cur_node : set){
            if (cur_node != null){
                for (Position adjancentNode : adjancentNodes) {
                    if (cur_node.data.equals(adjancentNode)) node.addEdge(cur_node);
                }
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return Objects.equals(data, node.data) && Objects.equals(neighbours, node.neighbours);
    }

}
