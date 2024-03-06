package fr.ubx.poo.td6.model;

public class TestGrid {
    public static void main(String[] args) {
        GridRepo test = new GridRepoVar();
        Grid res = test.load("sample2");
        test.export(res);
    }
}
