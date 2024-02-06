package fr.ubx.poo.td2;

import javafx.animation.PathTransition;
import javafx.scene.image.ImageView;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class Sprite {
    private Vehicule vehicule;
    protected ImageView img;

    protected boolean isMoving;

    public Sprite(Vehicule vehicle) {
        this.vehicule = vehicle;
    }

    protected void updateLocation(Position position) {
        img.setX(position.getX() * ImageResource.size);
        img.setY(position.getY() * ImageResource.size);
    }

    public ImageView getImg() {
        return img;
    }

    public void animateMove(Position target) {
        if (isMoving) return;
        this.isMoving = true;
        // Make the path movement
        Position[] positionPath = vehicule.getPathTo(target); /* the array of position from our robots position
        to the targets position */

        if (positionPath == null) {
            updateLocation(target); // we update the targets position
            vehicule.move(target);
            this.isMoving = false;
        } else {
            Path path = new Path();

            path.getElements().add(new MoveTo(vehicule.getPosition().getX() * ImageResource.size + ImageResource.size / 2,
                    vehicule.getPosition().getY() * ImageResource.size + ImageResource.size / 2));
            for (Position pos : positionPath) { // for( position i in positionPath)
                // in this loop, thanks to the getPathTo methode, we first create the line with the first path
                // which contains the horizontal distance our robot has to move, then the vertical one (in the case where we only do 2 positions in path).
                path.getElements().add(new LineTo(pos.getX() * ImageResource.size + ImageResource.size / 2, pos.getY() * ImageResource.size + ImageResource.size / 2));
            }

            PathTransition ptr = new PathTransition();
            ptr.setDuration(Duration.millis(100 * vehicule.distance(target)));
            ptr.setPath(path);
            ptr.setNode(getImg());

            ptr.setOnFinished(e -> {
                vehicule.move(target);
                this.isMoving = false;
            });
            ptr.play();

        }
    }
}
