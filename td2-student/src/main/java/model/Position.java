package model;

import java.util.Random;

public record Position(int x, int y) { // record takes in arguments which are private attributes i suppose and instantly generates getters which are methods that have the exact same name of the arguments
    // and does everything that an immutable object can do.
    public static Position random(int width, int height){ // retourne une position random
        Random random = new Random();
        int x = random.nextInt(width);
        int y=  random.nextInt(height);
        return new Position(x, y);
    }
}
