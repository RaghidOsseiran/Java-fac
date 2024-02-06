package fr.ubx.poo.td2;

import javafx.animation.PathTransition;
import javafx.scene.image.ImageView;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class SpriteDrone extends Sprite {

    public SpriteDrone(Drone drone) {
        super(drone);
        this.img = new ImageView(ImageResource.imageDrone);
        super.updateLocation(drone.getPosition());
    }

}
