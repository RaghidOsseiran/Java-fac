package Vehicles;

import javafx.scene.image.ImageView;
import model.Vehicule;
import view.Sprite;

public class SpriteVehicule extends Sprite {
    public SpriteVehicule(Vehicule vehicule,ImageView img){
        super(img);
        this.vehicule = vehicule;
        updateLocation(this.vehicule.getPosition());
    }
}
