package map;

public enum Cell {
    GRASS('G'),
    MUD('M'),
    CARROTS('C'),
    TREE('T'),
    FLOWERS('F');

    private char code;

    public char getCode(){
        return this.code;
    }


    Cell(char c){
        this.code = c;
    }


}
