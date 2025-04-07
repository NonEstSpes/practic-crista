package org.example;

public class Virus {
    public void infect(Organism organism, int algorithmIndex) {
        int[] cells = organism.getCells();
        int[] infectedCells = new int[cells.length];

        switch (algorithmIndex) {
            case 1:
                for (int i = 0; i < cells.length; i++) {
                    infectedCells[i] = cells[cells.length - 1 - i];
                }
                break;
            case 2:
                for (int i = 0; i < cells.length; i++) {
                    infectedCells[i] = -cells[i];
                }
                break;
            case 3:
                for (int i = 0; i < cells.length; i++) {
                    infectedCells[i] = (cells[i] + 1) % 10;
                }
                break;
            default:
                throw new IllegalArgumentException("Неизвестный алгоритм заражения");
        }

        organism.setCells(infectedCells);
    }
}