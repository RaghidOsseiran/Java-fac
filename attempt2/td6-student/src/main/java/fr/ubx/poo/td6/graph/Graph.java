package fr.ubx.poo.td6.graph;

import fr.ubx.poo.td6.model.Position;

import java.util.*;

public class Graph<T> {
    private final Set<Node<T>> nodes;


    private Set<Node<T>> cloneNodes(Set<Node<T>> neigh){
        return new HashSet<>(neigh);
    }

    public Graph() {
        this.nodes = Collections.synchronizedSet(new HashSet<>());
    }
    public void addNode(T data) {
        nodes.add(new Node<>(data));
    }
    public Node<T> getNode(T data) {
        for(Node<T> cur_node: nodes){
            if (cur_node != null && cur_node.getData() == data){
                return cur_node;
            }
        }
        return null;
    }
    public Set<Node<T>> getNodes() {
        return cloneNodes(nodes);
    }



    private void dfs(Node<T> source, Hashtable<T, Boolean> visited){
        visited.put(source.getData(), true);
        for(Node<T> node : source.getNeighbours()){
            if(!visited.get(node.getData())){
                dfs(node, visited);
            }
        }
    }

    public boolean isConnected() {
        Hashtable<T, Boolean> visited = new Hashtable<>();
        nodes.forEach(node -> visited.put(node.getData(), false));
        if (nodes.stream().findFirst().isPresent()) {
            Node<T> source = nodes.stream().findFirst().get();
            dfs(source, visited);
        }
        return ! visited.containsValue(false);
    }


    private double heuristic (T src, T dest) throws RuntimeException{
        if (src instanceof Position psrc && dest instanceof Position pdest) {
            return Math.sqrt(Math.pow((pdest.x() - psrc.x()), 2)+Math.pow((pdest.y() - psrc.y()), 2));
        } else {
            throw new RuntimeException("not valid parameters to calculate heuristic");
        }
    }

    private Position[] construct_path(Node<T> dest){
        return null;
    }

    public Position[] aStar(Node<T> src,Node<T> dest){
        PriorityQueue<Node<T>> queue = new PriorityQueue<>(Comparator.comparingDouble(node -> node.f));
        queue.add(src);
        Hashtable<Node<T>, Boolean> visited = new Hashtable<>();
        src.g = 0;
        src.f = src.g + heuristic(src.getData(), dest.getData());
        while(!queue.isEmpty()){
            Node<T> currentNode = queue.poll();
            if (currentNode.equals(dest)) return construct_path(dest);
            visited.put(currentNode, true);

        }
        return null;
    }

}
