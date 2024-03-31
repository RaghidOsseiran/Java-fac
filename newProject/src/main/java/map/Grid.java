package map;

import static map.Cell.*;

public final class Grid {
    public final static int rows = 5;
    public final static  int columns = 5;
    private Cell[][] map = {
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

    public void set(int row, int column, Cell cell){
        if (row >= 0 && row < rows && column >= 0 && column < columns){
            map[row][column] = cell;
        }
    }


    public Cell get(int row, int column) throws GridException{
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
