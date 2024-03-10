package fr.ubx.poo.td6.model;

public class Test {
    public static void main(String[] args) {
//        GridRepo test = new GridRepoVar();
//        Grid res = test.load("...");
//        System.out.println(test.export(res));
        GridRepoStringRLE test = new GridRepoStringRLE();
//        Grid res = test.load("BBBxBBBx");
//        System.out.println(test.export(res));

        System.out.println(test.compress("BGx"));
    }
}
