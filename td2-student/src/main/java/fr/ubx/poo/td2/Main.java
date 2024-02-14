package fr.ubx.poo.td2;

import Obstacles.DecorFactory;
import Obstacles.SpriteDecor;
import Obstacles.SpriteDust;
import Obstacles.SpriteRock;
import Vehicles.SpriteDrone;
import Vehicles.SpriteRobot;
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
    private static float pR = 0.5f; //proba robot
    private static float pD = 0.5f; //proba dust

    @Override
    public void start(Stage stage)  {

        // Create the robot curiosity
        Position position = new Position(4,4);
        Robot robot = new Robot("curiosity", position, 200, 2);
        SpriteRobot spriterobot = new SpriteRobot(robot);

        Position position1 = new Position(5, 5);
        Robot robot2 = new Robot("curiosity", position1, 200, 2);
        SpriteRobot spriterobot2 = new SpriteRobot(robot2);

        // Create the drone disinterest
        Position position2 = new Position(7, 7);
        Drone drone = new Drone("disinterest", position2, 200, 2);
        SpriteDrone spritedrone = new SpriteDrone(drone);

        // Display the window
        View view = new View(20, 20);
        stage.setTitle("POO");
        stage.setScene(view.getPane().getScene());
        stage.show();

        HashMap<Vehicule, Sprite> map = new HashMap<>();
        map.put(robot, spriterobot);
        map.put(robot2, spriterobot2);
        map.put(drone, spritedrone);


        // this can be a pain in the ass if we have a bunch of vehicles
        view.getPane().setOnMouseClicked(e -> {
            Position target = view.getPosition(e);
            for(Map.Entry<Vehicule, Sprite> entry: map.entrySet()){ // we loop over all the elements in the hashmap
                Sprite sprite = entry.getValue(); // we get the vehicle / sprite pair
                Vehicule vehicle = entry.getKey();
                if (vehicle.canMove(target) && !vehicle.getPosition().equals(target)){ // the late binding will do its job calling the right methods in case of redefinition
                   sprite.animateMove(target);
                }
            }
        });

        for(Map.Entry<Vehicule, Sprite> entry: map.entrySet()) {
            Sprite sprite = entry.getValue();
            Vehicule vehicle = entry.getKey();
            view.getPane().getChildren().addAll(sprite.getImg());
        }

        float pR = 0.5f;
        float pD = 0.5f;

        World ourWorld = new World(view.getWidth(), view.getHeight(), pR, pD);


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