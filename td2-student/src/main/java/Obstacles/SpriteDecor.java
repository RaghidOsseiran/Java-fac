package Obstacles;

import javafx.scene.image.Image;
import model.Position;
import view.Sprite;

public class SpriteDecor extends Sprite {

    protected Position pos;
    public SpriteDecor(Image img, Position pos){
        super(img);
        this.pos = pos;
        updateLocation(this.pos);
    }
}
