package Vehicles;

import model.Drone;
import javafx.scene.image.ImageView;
import view.ImageResource;

public class SpriteDrone extends SpriteVehicule {

    public SpriteDrone(Drone drone) {
        super(drone, new ImageView(ImageResource.imageDrone));
    }

}
