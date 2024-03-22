package fr.ubx.poo.td6.view;

import fr.ubx.poo.td6.graph.Graph;
import fr.ubx.poo.td6.graph.Node;
import fr.ubx.poo.td6.model.Grid;
import fr.ubx.poo.td6.model.Position;
import javafx.geometry.Pos;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class GridView extends BorderPane {
    private final Grid grid;
    private final PickerView pickerView;

    private final ColorAdjust effect = new ColorAdjust();

    private final Marker marker;

    private List<Circle> pathCircles = new ArrayList<>();


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
            MenuItem itemClear = new MenuItem("Clear markers");
            itemPath.setDisable(!marker.exists());
            // Put marker
            itemMark.setOnAction(event -> {
                marker.create(new Position(i, j));
                System.out.println(new Position(i, j));
            });
            // Path finding
            itemPath.setOnAction(event -> {
                marker.clear();
                System.out.println("Path finding " + marker.getPosition() + " -> " + new Position(i,j));
                // This needs to be updated!
                // Create the graph and run A* to find the shortest path
                ArrayList<Marker> markers = new ArrayList<>();
                Graph<Position> graph = grid.getGraph();
                Node<Position> startNode = graph.getNode(marker.getPosition());
                System.out.println("end node" + new Position(i, j));
                Node<Position> endNode = graph.getNode(new Position(i , j));
                Position[] shortest_path = graph.aStar(startNode, endNode);
                if (shortest_path != null) drawPath(shortest_path, startNode.getData(), endNode.getData());
            });

            itemClear.setOnAction(event -> {
                clearPathCircles();
            });


            contextMenu.getItems().addAll(itemMark, itemPath, itemClear);
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


    public void drawPath(Position[] path, Position start, Position end) {
        // Clear existing path circles
        clearPathCircles();

        Circle circleStart = new Circle(start.x() * ImageResource.size + ImageResource.size/2, start.y() * ImageResource.size + ImageResource.size/2, 5);
        circleStart.setFill(Color.CYAN);
        this.getChildren().add(circleStart);

        Circle circleEnd = new Circle(end.x() * ImageResource.size + ImageResource.size/2, end.y() * ImageResource.size + ImageResource.size/2, 5);
        circleEnd.setFill(Color.CYAN);
        this.getChildren().add(circleEnd);

        pathCircles.add(circleStart);
        pathCircles.add(circleEnd);
        // Iterate over the path and create a circle for each position
        for (Position pos : path) {
            if (pos != null) {
                Circle circle = new Circle(pos.x() * ImageResource.size + ImageResource.size / 2, pos.y() * ImageResource.size + ImageResource.size / 2, 5); // Adjust size as needed
                circle.setFill(Color.GREEN); // Or any color that signifies the path
                this.getChildren().add(circle);
                pathCircles.add(circle);
            }
        }
    }

    public void clearPathCircles() {
        for (Circle circle : pathCircles) {
            this.getChildren().remove(circle);
        }
        pathCircles.clear();
    }



}
