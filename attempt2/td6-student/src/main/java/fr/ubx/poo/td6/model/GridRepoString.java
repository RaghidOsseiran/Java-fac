package fr.ubx.poo.td6.model;

public class GridRepoString extends GridRepoStringMain implements GridRepo {
    @Override
    public Grid load(String string) throws GridException{
        return super.load(string);
    }

    @Override
    public String export(Grid grid) {
        return super.export(grid);
    }

    public Grid create(int width, int height){
        Grid res = new Grid(width, height);
        for(int i = 0; i < res.getHeight(); i++){
            for(int j = 0; j < res.getWidth(); j++){
                res.set(j, i, Entity.GROUND);
            }
        }
        return res;
    }


}
