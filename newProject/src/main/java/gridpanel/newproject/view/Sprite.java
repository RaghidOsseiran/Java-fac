package gridpanel.newproject.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import map.Position;

public abstract class Sprite {
    protected ImageView img;

    public Sprite(Image img){
        this.img = new ImageView(img);
        updateImage();
    }


    private void updateImage(){
        img.setFitWidth(ImageResource.tileSize);
        img.setFitHeight(ImageResource.tileSize);
    }

    protected void updateLocation(Position position){
        img.setX(position.x() * ImageResource.tileSize);
        img.setY(position.y() * ImageResource.tileSize);
    }

    public ImageView getImg(){return img;}
}
