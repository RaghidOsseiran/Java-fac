package fr.ubx.poo.td6.model;
import static fr.ubx.poo.td6.model.Entity.*;

public class GridRepoString implements GridRepo {

    final char EOL = 'x';

    @Override
    public Grid load(String string) throws GridException {
        boolean isX = false;
        int index = 0;
        int height = 0;
        int width = 0;
        while(index < string.length()){
            if(string.charAt(index) == EOL){ height++; isX = true;}
            if(!isX) width++;
            index++;
        }
        System.out.println("height: "+height+", width: "+width+"");
        Grid res = new Grid(width, height);
        index = 0;
        int i = 0;
        int j = 0;
        for(int k = 0; k < string.length(); k++){
            if(string.charAt(k) == EOL){i++; j = 0; continue;};
            char c = string.charAt(k);
            res.set(i, j, Entity.fromCode(c));
            j++;
        }
        return res;
    }

    @Override
    public String export(Grid grid) {
        StringBuilder res = new StringBuilder();
        for(int j = 0 ; j < grid.getWidth(); j++){
            for(int i = 0; i < grid.getHeight(); i++){
                Entity val = grid.get(i, j);
                System.out.println(val+",");
                switch (val){
                    case GROUND: res.append("G"); break;
                    case ROCK: res.append("R"); break;
                    case DUST: res.append("D"); break;
                    case BIGROCK: res.append("B"); break;
                    case ENERGY: res.append("E"); break;
                }
            }
            res.append("x");
        }
        System.out.println("res: "+res.toString());
        return res.toString();
    }
}
