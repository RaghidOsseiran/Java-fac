package fr.ubx.poo.td6.model;

public class TestGrid {
    public static void main(String[] args) {
        GridRepoVar test = new GridRepoVar();
        Grid res = test.load("...");
        test.export(res);
    }
}
