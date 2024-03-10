package fr.ubx.poo.td6.model;

public class GridRepoStringRLE implements GridRepo {

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


    public String compress(String string){
        int i = 0;
        int j = 0;
        char nb = '0';
        StringBuilder buffer = new StringBuilder();
        StringBuilder res = new StringBuilder();
        while(i < string.length()){
            char c = string.charAt(i);
            if (!buffer.isEmpty()){
                if (c != buffer.charAt(j-1) && c == EOL){
                    res.append(buffer.charAt(j-1)); res.append(nb);
                    buffer.delete(0, buffer.length());
                } else {
                    buffer.append(c); nb = '0'; j = 0;
                }
//                else if (nb == '8'){
//                    res.append(buffer.charAt(j-1)); res.append(nb);
//                    buffer.delete(0, buffer.length());
//                }
            }
            if(c != EOL){ buffer.append(c); j++;}
            i++;
        }
        System.out.println(buffer);
        return res.toString();
    }


}
