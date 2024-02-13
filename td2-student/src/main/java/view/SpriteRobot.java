package view;

import model.Robot;
import javafx.scene.image.ImageView;

public class SpriteRobot extends Sprite {


    public SpriteRobot(Robot robot) {
        super(robot, new ImageView(ImageResource.imageRobot));
    }


}
