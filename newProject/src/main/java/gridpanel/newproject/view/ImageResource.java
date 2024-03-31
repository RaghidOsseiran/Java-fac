package gridpanel.newproject.view;

import javafx.scene.image.Image;
import map.Cell;

public enum ImageResource {
    // TILES
    //////////////////////////////////////////////
    TREE("tree.png"),
    GRASS("grass.png"),
    MUD("mud.png"),
    CARROTS("carrots.png"),
    FLOWERS("tree.png"),
    /////////////////////////////////////////////////
    // ENTITIES

    PLAYER("tree.png"),
    PRINCESS("tree.png"),
    BEE("tree.png"),
    APPLE("tree.png"),
    POISONEDAPPLE("tree.png"),
    HEART("tree.png"),
    KEY("tree.png");


    public static final int tileSize = 40;

    private final Image image;

    ImageResource(String file){
        this.image = new Image(ImageResource.class.getResourceAsStream("/images/"+file));
    }

    public static Image get(Cell kind){
        if (kind != null) return ImageResource.valueOf(kind.toString()).image;
        return null;
    }

}
