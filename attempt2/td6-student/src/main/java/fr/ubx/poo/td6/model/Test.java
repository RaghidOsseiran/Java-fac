package fr.ubx.poo.td6.model;

public class Test {
    public static void main(String[] args) {
        GridRepoString test = new GridRepoString();
        Grid to = test.load("BBBExBGGGxGGEEx");
        GridRepoStringRLE testt = new GridRepoStringRLE();
        System.out.println(testt.export(to));
    }
}
