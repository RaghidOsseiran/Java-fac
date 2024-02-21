package Obstacles;

import Obstacles.SpriteDecor;
import javafx.scene.image.ImageView;
import model.Position;
import view.ImageResource;

public class SpriteDust extends SpriteDecor {
    public SpriteDust(Position pos){
        super(ImageResource.imageDust, pos);
    }
}
