package Obstacles;

import javafx.scene.image.ImageView;
import model.Position;
import view.Sprite;

public class SpriteDecor extends Sprite {

    protected Position pos;
    public SpriteDecor(ImageView img, Position pos){
        super(img);
        this.pos = pos;
        updateLocation(this.pos);
    }
}
