package fr.ubx.poo.td6.model;

import fr.ubx.poo.td6.graph.Graph;
import fr.ubx.poo.td6.graph.Node;

import java.util.Set;

public class Grid {

    private final int width;
    private final int height;
    private final Entity[][] grid;


    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new Entity[height][width];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


    public Entity get(int i, int j) {
        return grid[j][i];
    }

    public void set(int i, int j, Entity entity) {
        grid[j][i] = entity;
    }


    public Graph<Position> getGraph(){
        Graph<Position> res = new Graph<>(); // graphe de noeuds de position
        for(int i = 0 ; i < height; i++){
            for(int j = 0; j < width; j++){
                if (get(j,i).isAccessible()){
                    res.addNode(new Position(j, i));
                }
            }
        }
        Set<Node<Position>> set = res.getNodes();
        for(Node<Position> node: set){
            node.checkContourage(set, node);
        }
        return res;
    }

}
