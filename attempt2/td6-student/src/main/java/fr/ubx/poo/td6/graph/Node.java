package fr.ubx.poo.td6.graph;

import fr.ubx.poo.td6.model.Position;
import fr.ubx.poo.td6.model.*;

import java.util.*;

public class Node<T> {
    private final T data;
    private final List<Node<T>> neighbours;


    //////////////////////////////////////////

    Node<T> parent;
    private boolean opened;
    private boolean checked;
    public int gCost;
    public int hCost;
    public int fCost;



    public void setAsChecked(){
        this.checked = true;
    }

    public void setAsOpened(){
        this.opened = true;
    }



    private void openNode(Node<T> currentNode){
        if (!this.opened && !this.checked){
            this.setAsOpened();
            this.parent = currentNode;
        }
    }


    public void openNeighbours(ArrayList<Node<T>> openList){
        for(Node<T> node: neighbours){
            if (node != null && !node.checked){
                node.openNode(this);
                openList.add(node);
            }
        }
    }


    ///////////////////////////////////////////

    public Node(T data) {
        neighbours = new ArrayList<>();
        this.data = data;
        this.opened = false;
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




    public <T extends Position> void checkContourage(Set<Node<T>> set, Node<T> node){
        Position[] adjacentNodes = {
                new Position(node.data.x(), node.data.y()-1),
                new Position(node.data.x()-1, node.data.y()),
                new Position(node.data.x()+1, node.data.y()),
                new Position(node.data.x(), node.data.y()+1),
        };
        for(Node<T> cur_n: set){
            for (Position adjacentNode : adjacentNodes) {
                if (!node.equals(cur_n) && cur_n.data.equals(adjacentNode)) node.addEdge(cur_n);
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
