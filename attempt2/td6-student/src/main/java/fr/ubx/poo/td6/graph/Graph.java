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
            if (cur_node != null && cur_node.getData().equals(data)){
                return cur_node;
            }
        }
        return null;
    }

    public Set<Node<T>> getNodes() {
        return cloneNodes(nodes);
    }



    public void printNodes(){
        nodes.stream().forEach(node -> {
            Position pos = (Position)node.getData();
            System.out.println("current node: "+ pos);
            node.printNeigh();
        });
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


    public void setNodesCost(Node<T> start, Node<T> dest){
        if (start.getData() instanceof Position pos_start && dest.getData() instanceof Position pos_dest){
            if (nodes != null && nodes.iterator().next().getData() instanceof Position){
                for(Node<T> node: nodes){
                    Position posNode = (Position)node.getData();
                    // G Cost is the distance from the start node
                    int xDist = Math.abs(posNode.x() - pos_start.x());
                    int yDist = Math.abs(posNode.y() - pos_start.y());
                    node.gCost = xDist+yDist;
                    // H Cost is the distance from the dest node
                    xDist = Math.abs(posNode.x() - pos_dest.x());
                    yDist = Math.abs(posNode.y() - pos_dest.y());
                    node.hCost = xDist + yDist;
                    node.fCost = node.gCost + node.hCost;
                }
            }
        }
    }

    public int biggestFCost(){
        int best = 0;
        for(Node<T> node: nodes){
            if (node != null && node.fCost > best) best = node.fCost;
        }
        return best;
    }

    private Position[] construct_path(Node<T> start , Node<T> dest){
        ArrayList<Position> res = new ArrayList<>();
        Node<T> currentNode = dest;
        while(!currentNode.equals(start)){
            currentNode = currentNode.parent;
            if(!currentNode.equals(start)){
                res.add((Position)currentNode.getData());
            }
        }
        Position[] pos_array = new Position[res.size()];
        return res.toArray(pos_array);
    }

    public Position[] aStar(Node<T> start,Node<T> dest){
        if (start.equals(dest)) return null;
        setNodesCost(start, dest);
        int maxBlockedStep = 0;
        ArrayList<Node<T>> openList = new ArrayList<>();
        Node<T> currentNode = start;
        while (!currentNode.equals(dest) && maxBlockedStep < 300){
            currentNode.setAsChecked();
            openList.remove(currentNode);
            currentNode.openNeighbours(openList);
            if (openList.isEmpty()) return null;
            int bestNodeIndex = 0;
            int bestNodefCost = biggestFCost();
            for(int i = 0; i < openList.size(); i++){
                if(openList.get(i).fCost < bestNodefCost){
                    bestNodeIndex = i;
                    bestNodefCost = openList.get(i).fCost;
                } else if (openList.get(i).fCost == bestNodefCost){
                    if(openList.get(i).gCost < openList.get(bestNodeIndex).gCost){
                        bestNodeIndex = i;
                    }
                }
            }
            currentNode = openList.get(bestNodeIndex);
            maxBlockedStep++;
        }
        if (maxBlockedStep == 300 || !currentNode.equals(dest)){
            return null;
        }
        return construct_path(start, dest);
    }

}
