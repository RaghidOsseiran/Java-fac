package fr.ubx.poo.td6.model;
import java.lang.reflect.Field;

import static fr.ubx.poo.td6.model.Entity.*;
public class GridRepoVar implements GridRepo {

    private final Entity[][] sample1 = {
            {GROUND, GROUND, GROUND, GROUND, DUST, GROUND, GROUND, GROUND, GROUND},
            {GROUND, GROUND, GROUND, GROUND, GROUND, GROUND, DUST, GROUND, GROUND},
            {GROUND, GROUND, ROCK, CRACK, GROUND, GROUND, BIGROCK, GROUND, GROUND},
            {GROUND, ROCK, GROUND, ROCK, GROUND, GROUND, GROUND, GROUND, GROUND},
            {GROUND, GROUND, GROUND, GROUND, GROUND, GROUND, GROUND, GROUND, GROUND},
            {GROUND, GROUND, GROUND, GROUND, GROUND, GROUND, GROUND, CRACK, GROUND},
            {GROUND, DUST, GROUND, DUST, GROUND, GROUND, GROUND, GROUND, GROUND},
            {GROUND, GROUND, GROUND, CRACK, GROUND, DUST, BIGROCK, GROUND, GROUND},
            {GROUND, ROCK, GROUND, GROUND, GROUND, GROUND, GROUND, GROUND, GROUND},
    };

    private final Entity[][] sample2 = {
            {GROUND, ROCK, DUST, ROCK, GROUND},
            {GROUND, CRACK, BIGROCK, CRACK, DUST},
            {GROUND, CRACK, CRACK, GROUND, BIGROCK},
            {ROCK, DUST, DUST, GROUND, DUST}
    };


    @Override
    public Grid load(String name) {
        Entity[][] entities = getEntities(name);
        if (entities == null)
            return null;
        Grid res = new Grid(entities[0].length, entities.length);
        for(int i = 0 ; i < entities.length; i++){
            for(int j = 0; j < entities[0].length; j++){
                res.set(i, j, entities[i][j]);
            }
        }
        return res;
    }



    @Override
    public String export(Grid grid){
        StringBuilder res = new StringBuilder();
        res.append("private final Entity[][] sample1 = {\n");
        for(int i = 0 ; i < grid.getHeight(); i++){
            res.append("\t{");
            for(int j = 0; j < grid.getWidth(); j++){
                Entity val = grid.get(i, j);
                switch (val){
                    case GROUND: res.append("GROUND,"); break;
                    case ROCK: res.append("ROCK,"); break;
                    case DUST: res.append("DUST,"); break;
                    case BIGROCK: res.append("BIGROCK,"); break;
                    case ENERGY: res.append("ENERGY,"); break;
                    default: break;
                }
            }
            res.deleteCharAt(res.length() - 1);
            res.append("},\n");
        }
        res.append("};");
        System.out.println(res.toString());
        return res.toString();
    }


    private Entity[][] getEntities(String name) {
        try {
            Field field = this.getClass().getDeclaredField(name);
            return (Entity[][]) field.get(this);
        } catch (IllegalAccessException e) {
            return null;
        } catch (NoSuchFieldException e) {
            return null;
        }
    }


}
