package fr.ubx.poo.td6.model;

public class Test {
    public static void main(String[] args) {
//        GridRepo test = new GridRepoVar();
//        Grid res = test.load("...");
//        System.out.println(test.export(res));
        GridRepo test = new GridRepoString();
        Grid res = test.load("BGGGxGEEGxGGBBx");
        System.out.println(test.export(res));
    }
}
