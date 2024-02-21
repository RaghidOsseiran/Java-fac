package view;

import javafx.scene.image.Image;
import model.Position;
import model.Vehicule;
import javafx.animation.PathTransition;
import javafx.scene.image.ImageView;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public abstract class Sprite {

    protected ImageView img;
    public Sprite(Image img) {
        this.img = new ImageView(img);
    }

    protected void updateLocation(Position position) {
        img.setX(position.x() * ImageResource.size);
        img.setY(position.y() * ImageResource.size);
    }
    public ImageView getImg() {
        return img;
    }


}
