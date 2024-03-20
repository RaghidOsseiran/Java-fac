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

}
