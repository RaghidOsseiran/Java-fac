package fr.ubx.poo.td2;

import Obstacles.DecorFactory;
import Obstacles.SpriteDecor;
import Obstacles.SpriteDust;
import Obstacles.SpriteRock;
import Vehicles.SpriteDrone;
import Vehicles.SpriteRobot;
import Vehicles.SpriteVehicule;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import model.Drone;
import model.Position;
import model.Robot;
import model.Vehicule;
import view.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main extends Application {
    private static final float pR = 1f; //proba robot
    private static final float pD = 0.5f; //proba dust

    @Override
    public void start(Stage stage)  {


        // Display the window
        View view = new View(20, 20);
        stage.setTitle("POO");
        stage.setScene(view.getPane().getScene());
        stage.show();


        World ourWorld = new World(view.getWidth(), view.getHeight(), pR, pD);
        ourWorld.InitWorld(); // on initialise des roches et des dust a des position random.
        int height = ourWorld.height;
        int width = ourWorld.width;

        int nb_pos = 3;
        Position[] PosTab = new Position[nb_pos];
        // Create the robot curiosity
        Position position = new Position(4,4); PosTab[0] = position;
        Position position1 = new Position(5, 5); PosTab[1] = position1;
        Position position2 = new Position(7, 7); PosTab[2] = position2;
        for(int i = 0; i < nb_pos; i++){
            if (ourWorld.isRock(PosTab[i])){
                PosTab[i] = Position.decal_pos(PosTab[i], height, width, ourWorld);
            }
        }

        Robot robot = new Robot("curiosity", PosTab[0], 200, 2, ourWorld);
        SpriteRobot spriterobot = new SpriteRobot(robot);

        Robot robot2 = new Robot("envy", PosTab[1], 200, 2, ourWorld);
        SpriteRobot spriterobot2 = new SpriteRobot(robot2);

        Drone drone = new Drone("disinterest", PosTab[2], 200, 2, ourWorld);
        SpriteDrone spritedrone = new SpriteDrone(drone);

        Vehicule[] vehicules = new Vehicule[3];
        SpriteVehicule[] sprites = new SpriteVehicule[3];

        // decalage des vehicle au cas ou ils tombe sur des roches.


        vehicules[0] = robot; vehicules[1] = robot2; vehicules[2] = drone;
        sprites[0] = spriterobot; sprites[1] = spriterobot2; sprites[2] = spritedrone;


        for(int i = 0; i < sprites.length; i++)  view.getPane().getChildren().addAll(sprites[i].getImg());


        // dessiner les sprites sur la grille
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                Position currentPos = new Position(i, j);
                int cellValue = ourWorld.get(currentPos);
                if (cellValue != World.EMPTY){
                    SpriteDecor obstacle = DecorFactory.create(currentPos, cellValue);
                    if (obstacle != null){
                        view.getPane().getChildren().addAll(obstacle.getImg());
                    }
                }
            }
        }

        view.getPane().setOnMouseClicked(e -> {
            Position target = view.getPosition(e);
                for(int i = 0; i < vehicules.length; i++){
                    if (vehicules[i].canMove(target) && !vehicules[i].getPosition().equals(target)){ // the late binding will do its job calling the right methods in case of redefinition
                        sprites[i].animateMove(target);
                    }
            }
        });



    }

    public static void main(String[] args) { launch(); }
}