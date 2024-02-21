package fr.ubx.poo.td2;

import Obstacles.DecorFactory;
import Obstacles.SpriteDecor;
import Obstacles.SpriteDust;
import Obstacles.SpriteRock;
import Vehicles.SpriteDrone;
import Vehicles.SpriteRobot;
import Vehicles.SpriteVehicule;
import javafx.application.Application;
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

    private static final Random random = new Random();
    private static final float pR = 0.5f; //proba robot
    private static final float pD = 0.5f; //proba dust

    @Override
    public void start(Stage stage)  {


        // Display the window
        View view = new View(20, 20);
        stage.setTitle("POO");
        stage.setScene(view.getPane().getScene());
        stage.show();

        float pR = 0.5f;
        float pD = 0.5f;

        World ourWorld = new World(view.getWidth(), view.getHeight(), pR, pD);


        // Create the robot curiosity
        Position position = new Position(4,4);
        Robot robot = new Robot("curiosity", position, 200, 2, ourWorld);
        SpriteRobot spriterobot = new SpriteRobot(robot);

        Position position1 = new Position(5, 5);
        Robot robot2 = new Robot("envy", position1, 200, 2, ourWorld);
        SpriteRobot spriterobot2 = new SpriteRobot(robot2);

        // Create the drone disinterest
        Position position2 = new Position(7, 7);
        Drone drone = new Drone("disinterest", position2, 200, 2, ourWorld);
        SpriteDrone spritedrone = new SpriteDrone(drone);

        Vehicule[] vehicules = new Vehicule[3];
        SpriteVehicule[] sprites = new SpriteVehicule[3];

        vehicules[0] = robot; vehicules[1] = robot2; vehicules[2] = drone;
        sprites[0] = spriterobot; sprites[1] = spriterobot2; sprites[2] = spritedrone;




        view.getPane().setOnMouseClicked(e -> {
            Position target = view.getPosition(e);
                for(int i = 0; i < vehicules.length; i++){
                    if (vehicules[i].canMove(target) && !vehicules[i].getPosition().equals(target)){ // the late binding will do its job calling the right methods in case of redefinition
                        sprites[i].animateMove(target);
                    }
            }
        });

        for(int i = 0; i < sprites.length; i++)  view.getPane().getChildren().addAll(sprites[i].getImg());



        int height = ourWorld.height;
        int width = ourWorld.width;

        // on set cree des position dans des places random avec une certain proba d'etre un roche ou un dust.
        for(int i = 0; i < height; i++){
            Position randPos = Position.random(width, height);
            double prob = random.nextDouble(1);
            int choice = random.nextInt(2); // random choice, 0 pour poussiere, 1 pour roche
            if (choice == 1){
                if (prob < ourWorld.getPercentageRock()){
                    ourWorld.set(randPos, 1);
                }
            } else {
                if (prob < ourWorld.getPercentageDust()){
                    ourWorld.set(randPos, 2);
                }
            }
        }


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

    }

    public static void main(String[] args) { launch(); }
}