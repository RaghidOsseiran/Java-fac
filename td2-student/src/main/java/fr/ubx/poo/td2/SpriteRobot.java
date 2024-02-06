package fr.ubx.poo.td2;

import javafx.animation.PathTransition;
import javafx.scene.image.ImageView;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class SpriteRobot extends Sprite {


    public SpriteRobot(Robot robot) {
        super(robot);
        this.img = new ImageView(ImageResource.imageRobot);
        updateLocation(robot.getPosition());
    }


}
