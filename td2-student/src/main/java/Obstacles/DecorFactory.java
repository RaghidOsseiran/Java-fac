package Obstacles;

import fr.ubx.poo.td2.World;
import model.Position;

public class DecorFactory {
    public static SpriteDecor create(Position position, int kind){
        switch(kind){
            case World.DUST:
                return new SpriteDust(position);
            case World.ROCK:
                return new SpriteRock(position);
            default:
                return null;
        }
    }
}
