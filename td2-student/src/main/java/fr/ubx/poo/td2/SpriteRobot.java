package fr.ubx.poo.td2;

import javafx.animation.PathTransition;
import javafx.scene.image.ImageView;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class SpriteRobot {
    private Robot robot;
    private ImageView img;

    private boolean isMoving;

    public SpriteRobot(Robot robot) {
        this.robot = robot;
        img = new ImageView(ImageResource.imageRobot);
        updateLocation(robot.getPosition());
    }

    private void updateLocation(Position position) {
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
        Position[] positionPath = robot.getPathTo(target); /* the array of position from our robots position
        to the targets position */

        if (positionPath == null) {
            updateLocation(target); // we update the targets position
            robot.move(target);
        } else {
            Path path = new Path();

            path.getElements().add(new MoveTo(robot.getPosition().getX() * ImageResource.size + ImageResource.size / 2,
                    robot.getPosition().getY() * ImageResource.size + ImageResource.size / 2));
            for (Position pos : positionPath) { // for( position i in positionPath)
                // in this loop, thanks to the getPathTo methode, we first create the line with the first path
                // which contains the horizontal distance our robot has to move, then the vertical one.
                path.getElements().add(new LineTo(pos.getX() * ImageResource.size + ImageResource.size / 2, pos.getY() * ImageResource.size + ImageResource.size / 2));
            }

            PathTransition ptr = new PathTransition();
            ptr.setDuration(Duration.millis(300 * robot.distance(target)));
            ptr.setPath(path);
            ptr.setNode(getImg());

            ptr.setOnFinished(e -> {
                robot.move(target);
                this.isMoving = false;
            });
            ptr.play();

        }
    }
}
