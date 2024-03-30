package Map;

public enum Tile {
    GRASS('G'),
    MUD('M'),
    CARROTS('C'),
    TREE('T'),
    FLOWERS('F');

    private char code;

    public char getCode(){
        return this.code;
    }


    Tile(char c){
        this.code = c;
    }


}
