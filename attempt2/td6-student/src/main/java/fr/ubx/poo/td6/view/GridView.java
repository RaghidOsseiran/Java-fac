package fr.ubx.poo.td6.view;

import fr.ubx.poo.td6.model.Grid;
import fr.ubx.poo.td6.model.Position;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.layout.BorderPane;

public class GridView extends BorderPane {
    private final Grid grid;
    private final PickerView pickerView;

    private final ColorAdjust effect = new ColorAdjust();

    private final Marker marker;


    public Marker getMarker() {
        return marker;
    }

    public GridView(Grid grid, PickerView pickerView) {
        this.grid = grid;
        this.pickerView = pickerView;
        effect.setBrightness(0.2);
        setPrefSize(grid.getWidth() * ImageResource.size,
                grid.getHeight() * ImageResource.size);
        for (int i = 0; i < this.grid.getWidth(); i++) {
            for (int j = 0; j < this.grid.getHeight(); j++) {
                createTile(i, j);
            }
        }
        this.marker = new Marker(this);
    }

    private void createTile(int i, int j) {
        int layoutX = i * ImageResource.size;
        int layoutY = j * ImageResource.size;
        Tile tile = new Tile(ImageResource.get(this.grid.get(i, j)), layoutX, layoutY);
        getChildren().add(tile);
        tile.setOnMouseClicked(e -> update(tile, i, j));
        tile.setOnMouseEntered(e -> {
            pickerView.setTilePos(new Position(i, j));
            tile.setEffect(effect);
            if (e.isShiftDown()) {
                update(tile, i, j);
            }
        });
        tile.setOnMouseExited(e -> {
            pickerView.setTilePos(null);
            tile.setEffect(null);
        });

        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(-0.2);
        tile.setOnMouseEntered(e -> {
            if (e.isShiftDown()) {
                update(tile, i, j);
            }
            tile.setEffect(colorAdjust);
        });
        tile.setOnMouseExited(e -> {
            tile.setEffect(null);
        });


        tile.setOnContextMenuRequested(e -> {
            ContextMenu contextMenu = new ContextMenu();
            MenuItem itemMark = new MenuItem("Set mark");
            MenuItem itemPath = new MenuItem("Path finding");
            itemPath.setDisable(!marker.exists());
            // Put marker
            itemMark.setOnAction(event -> {
                marker.create(new Position(i, j));
            });
            // Path finding
            itemPath.setOnAction(event -> {
                System.out.println("Path finding " + marker.getPosition() + " -> " + new Position(i,j));
                // This needs to be updated!
                // Create the graph and run A* to find the shortest path
            });
            contextMenu.getItems().addAll(itemMark, itemPath);
            contextMenu.show(tile, e.getScreenX(), e.getScreenY());
        });



    }

    private void update(Tile tile, int i, int j) {
        if (pickerView.getSelected() != null && pickerView.getSelected() != grid.get(i, j)) {
            getChildren().remove(tile);
            grid.set(i, j, pickerView.getSelected());
            createTile(i, j);
        }
    }
}
