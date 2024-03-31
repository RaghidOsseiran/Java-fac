package gridpanel.newproject;

import gridpanel.newproject.view.GridView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import map.Grid;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Grid grid = new Grid();
        GridView gridView = new GridView(grid);
        Scene scene = new Scene(gridView);
        stage.setTitle("Game");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}