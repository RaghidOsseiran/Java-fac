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
            {GROUND, ROCK, GROUND, GROUND, GROUND, GROUND, GROUND, GROUND, GROUND}
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
        Grid res = new Grid(entities[0].length, entities.length);
        if(entities == null) return null;
        for(int i = 0 ; i < entities.length; i++){
            for(int j = 0 ; j < entities[0].length; j++){
                res.set(j, i, entities[i][j]);
            }
        }
        return res;
    }

    @Override
    public String export(Grid grid) {
        StringBuilder s = new StringBuilder();
        s.append("private final Entity[][] sample = {\n");
        for(int i = 0 ; i < grid.getHeight(); i++){
            s.append("\t{");
            for(int j = 0 ; j < grid.getWidth(); j++){
                s.append(grid.get(j, i)+",");
            }
            s.deleteCharAt(s.length()-1); // on remove le dernier ","
            s.append("},\n");
        }
        s.deleteCharAt(s.length()-2); // on remove le dernier ","
        s.append("};");
        return s.toString();
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
