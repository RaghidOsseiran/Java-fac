package view;

import model.Position;
import model.Vehicule;
import javafx.animation.PathTransition;
import javafx.scene.image.ImageView;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public abstract class Sprite {
    protected Vehicule vehicule;
    protected ImageView img;
    protected boolean isMoving;

    public Sprite(ImageView img) {
        this.img = img;
    }

    protected void updateLocation(Position position) {
        img.setX(position.x() * ImageResource.size);
        img.setY(position.y() * ImageResource.size);
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
            updateLocation(target);
            vehicule.move(target);
            this.isMoving = false;
        } else {
            Position lastValidPosition = vehicule.getPosition();
            for(Position pos: positionPath){
                lastValidPosition = pos;
            }

            Path path = new Path();

            path.getElements().add(new MoveTo(vehicule.getPosition().x() * ImageResource.size + ImageResource.size / 2,
                    vehicule.getPosition().y() * ImageResource.size + ImageResource.size / 2));
            for (Position pos : positionPath) { // for( position i in positionPath)
                // in this loop, thanks to the getPathTo methode, we first create the line with the first path
                // which contains the horizontal distance our robot has to move, then the vertical one (in the case where we only do 2 positions in path).
                path.getElements().add(new LineTo(pos.x() * ImageResource.size + ImageResource.size / 2, pos.y() * ImageResource.size + ImageResource.size / 2));
            }

            PathTransition ptr = new PathTransition();
            ptr.setDuration(Duration.millis(165 * vehicule.distance(target)));
            ptr.setPath(path);
            ptr.setNode(getImg());


            Position finalLastValidPosition = lastValidPosition;
            ptr.setOnFinished(e -> {
                vehicule.move(finalLastValidPosition);
                this.isMoving = false;
            });
            ptr.play();

        }
    }
}
