package Obstacles;

import Obstacles.SpriteDecor;
import javafx.scene.image.ImageView;
import model.Position;
import view.ImageResource;

public class SpriteRock extends SpriteDecor {
    public SpriteRock(Position pos){
        super(new ImageView(ImageResource.imageRock), pos);
    }
}
