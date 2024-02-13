package model;

public record Position(int x, int y) { // record takes in arguments which are private attributes i suppose and instantly generates getters which are methods that have the exact same name of the arguments
//    private final int x;
//    private final int y;


//    public Position (Position p){
//        this.x = p.x;
//        this.y = p.y;
//    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj instanceof Position){
            Position i = (Position)obj;
            return this.x == i.x && this.y == i.y;
        }
        return false;
    }

}
