package org.example;

public class Organism {
    private int[] cells;
    private final int controlValue;

    public Organism(int[] cells) {
        this.cells = cells;
        this.controlValue = hashFunction(cells);
    }

    private int hashFunction(int[] array) {
        int hash = 0;
        for (int num : array) {
            hash = hash * 31 + num;
        }
        return hash;
    }

    public int getControlValue() {
        return controlValue;
    }

    public int[] getCells() {
        return cells;
    }

    public void setCells(int[] newCells) {
        this.cells = newCells;
    }
}