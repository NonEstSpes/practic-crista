package org.example;

public class Antivirus {
    public void cure(Organism organism) {
        int[] originalCells = null;

        for (int algorithmIndex = 1; algorithmIndex <= 3; algorithmIndex++) {
            Virus virus = new Virus();
            Organism tempOrganism = new Organism(organism.getCells());

            reverseInfect(tempOrganism, algorithmIndex);

            if (tempOrganism.getControlValue() == organism.getControlValue()) {
                originalCells = tempOrganism.getCells();
                break;
            }
        }

        if (originalCells != null) {
            organism.setCells(originalCells);
        } else {
            System.out.println("Не удалось вылечить организм!");
        }
    }

    private void reverseInfect(Organism organism, int algorithmIndex) {
        int[] cells = organism.getCells();
        int[] restoredCells = new int[cells.length];

        switch (algorithmIndex) {
            case 1:
                for (int i = 0; i < cells.length; i++) {
                    restoredCells[i] = cells[cells.length - 1 - i];
                }
                break;
            case 2:
                for (int i = 0; i < cells.length; i++) {
                    restoredCells[i] = -cells[i];
                }
                break;
            case 3:
                for (int i = 0; i < cells.length; i++) {
                    restoredCells[i] = (cells[i] + 9) % 10;
                }
                break;
        }

        organism.setCells(restoredCells);
    }
}
