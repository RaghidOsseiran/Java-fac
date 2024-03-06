package fr.ubx.poo.td6.model;

public interface GridRepo {
    Grid load(String string) throws GridException;
    String export(Grid grid);
}
