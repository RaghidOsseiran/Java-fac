package Vehicles;

import model.Robot;
import javafx.scene.image.ImageView;
import view.ImageResource;

public class SpriteRobot extends SpriteVehicule {


    public SpriteRobot(Robot robot) {
        super(robot, new ImageView(ImageResource.imageRobot));
    }


}
