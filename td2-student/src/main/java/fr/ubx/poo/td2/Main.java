package fr.ubx.poo.td2;

import javafx.application.Application;
import javafx.stage.Stage;
import java.util.HashMap;
import java.util.Map;

public class Main extends Application {

    @Override
    public void start(Stage stage)  {

        // Create the robot curiosity
        Position position = new Position(4,4);
        Robot robot = new Robot("curiosity", position, 200, 2);
        SpriteRobot spriterobot = new SpriteRobot(robot);

        position.translate(2);
        Robot robot2 = new Robot("curiosity", position, 200, 2);
        SpriteRobot spriterobot2 = new SpriteRobot(robot2);

        // Create the drone disinterest
        position.translate(1);
        Drone drone = new Drone("disinterest", position, 200, 2);
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
            Sprite sprite = entry.getValue(); // we get the vehicle / sprite pair
            Vehicule vehicle = entry.getKey();
            view.getPane().getChildren().addAll(sprite.getImg());
        }
    }

    public static void main(String[] args) { launch(); }
}