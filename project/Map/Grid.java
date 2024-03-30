package Map;

import entity.Entity;

import static Map.Tile.*;

public final class Grid {
    private final int rows = 5;
    private final int columns = 5;
    private Tile[][] map = {
            {GRASS, GRASS, TREE, CARROTS, CARROTS},
            {GRASS, GRASS, TREE, GRASS, FLOWERS},
            {GRASS, GRASS, TREE, GRASS, TREE},
            {GRASS, GRASS, MUD, MUD, TREE},
            {FLOWERS, FLOWERS, TREE, FLOWERS, FLOWERS}
    };


    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public void set(int row, int column, Tile tile){
        if (row >= 0 && row < rows && column >= 0 && column < columns){
            map[row][column] = tile;
        }
    }


    public Tile get(int row, int column) throws GridException{
        if (row >= 0 && row < rows && column >= 0 && column < columns){
            return map[row][column];
        }
        throw new GridException("Invalid access to grid");
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < rows; i++){
            for(int j = 0 ; j < columns; j++){
                res.append(get(i, j).getCode()).append(" ");
            }
            res.append("\n");
        }
        return res.toString();
    }

}
