package fr.ubx.poo.td6.model;

public class GridRepoString implements GridRepo{
    final char EOL = 'x';

    @Override
    public Grid load(String string) throws GridException{
        String[] gridTab = string.split(""+EOL);
        int height = gridTab.length; int width = gridTab[0].length();
        string = string.replace("x", "");
        Grid res = new Grid(width, height);
        for(int i = 0 ; i < height; i++){
            for(int j = 0 ; j < width; j++){
                res.set(j, i, Entity.fromCode(string.charAt(i * width + j)));
            }
        }
        return res;
    }

    @Override
    public String export(Grid grid) {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < grid.getHeight(); i++){
            for(int j = 0 ; j < grid.getWidth(); j++){
                Entity entity = grid.get(j, i);
                res.append(entity.getCode());
            }
            res.append("x");
        }
        return res.toString();
    }


}
