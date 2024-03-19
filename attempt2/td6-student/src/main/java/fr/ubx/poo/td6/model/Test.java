package fr.ubx.poo.td6.model;

public class Test {
    public static void main(String[] args) {
        GridRepoString test = new GridRepoString();
        Grid to = test.load("BBBxEEBxGGBxGBBx");
        GridRepoStringRLE testt = new GridRepoStringRLE();
        System.out.println(testt.export(to));
    }
}
