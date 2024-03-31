package gridpanel.newproject.view;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import map.Grid;
import map.Cell;
import map.GridException;
import resource.GameResource;



public class GridView extends BorderPane {
    private final Grid grid;
    private final GridPane gridPane;

    public GridView(Grid grid) {
        this.grid = grid;
        this.gridPane = new GridPane();
        gridPane.setPrefSize(GameResource.GRID_HEIGHT, GameResource.GRID_HEIGHT);


        for(int i = 0 ; i < grid.getRows(); i++){
            for(int j = 0; j < grid.getColumns(); j++){
                createTile(i, j);
            }
        }
        gridPane.setMinSize(0, 0);
//        gridPane.setMaxSize();
//        gridPane.setGridLinesVisible(true); // DEBUG LINES
        bindTileSizeToPaneSize();
        this.setCenter(gridPane);

    }


    private void createTile(int row, int column){
        Cell cellType = this.grid.get(row, column);
        ImageView tile = new ImageView(ImageResource.get(cellType));
        tile.setFitWidth((double)(gridPane.getWidth()/grid.getColumns()));
        tile.setFitHeight((double)(gridPane.getHeight()/grid.getRows()));
        gridPane.add(tile, column, row);
    }


    private void bindTileSizeToPaneSize() {
        // Assuming the number of columns and rows are constant and known
        int numColumns = grid.getColumns();
        int numRows = grid.getRows();

        gridPane.widthProperty().addListener((obs, oldVal, newVal) -> {
            double newWidth = (double)(gridPane.getWidth()/grid.getColumns());
            System.out.println("new width: "+newWidth);
            for (Node child : gridPane.getChildren()) {
                if (child instanceof ImageView) {
                    ((ImageView) child).setFitWidth(newWidth);
                }
            }
        });




        gridPane.heightProperty().addListener((obs, oldVal, newVal) -> {
            double newHeight = (double)(gridPane.getHeight()/grid.getRows());
//            System.out.println("new height : "+ newHeight);
            for (Node child : gridPane.getChildren()) {
                if (child instanceof ImageView) {
                    ((ImageView) child).setFitHeight(newHeight);
                }
            }
        });
    }

}
