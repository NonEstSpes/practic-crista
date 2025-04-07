package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Organism> organisms = new ArrayList<>();
        organisms.add(new Organism(new int[]{2, 1, 0, 1, 1, 9, 9, 9})); // 21.01.1999
        organisms.add(new Organism(new int[]{0, 1, 0, 2, 1, 9, 9, 9})); // 01.02.1999
        organisms.add(new Organism(new int[]{3, 0, 0, 3, 2, 0, 0, 0})); // 30.03.2000
        organisms.add(new Organism(new int[]{2, 5, 0, 4, 1, 9, 7, 0})); // 25.04.1970
        organisms.add(new Organism(new int[]{2, 5, 0, 5, 1, 9, 6, 9})); // 25.05.1969
        organisms.add(new Organism(new int[]{0, 6, 0, 6, 2, 0, 0, 6})); // 06.06.2006
        organisms.add(new Organism(new int[]{0, 7, 0, 7, 1, 9, 9, 2})); // 07.07.1992
        organisms.add(new Organism(new int[]{0, 4, 0, 8, 1, 9, 9, 8})); // 04.08.1998
        organisms.add(new Organism(new int[]{1, 6, 0, 9, 1, 9, 8, 8})); // 16.09.1988
        organisms.add(new Organism(new int[]{1, 0, 1, 0, 1, 9, 8, 1})); // 10.10.1981
        organisms.add(new Organism(new int[]{1, 0, 1, 1, 1, 9, 9, 1})); // 10.11.1991
        organisms.add(new Organism(new int[]{1, 3, 1, 2, 2, 0, 0, 1})); // 13.12.2001

        List<Organism> filtered = new ArrayList<>();
        for (Organism organism : organisms) {
            int month = organism.getCells()[2] * 10 + organism.getCells()[3];
            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                filtered.add(organism);
            }
        }

        filtered.sort(Comparator.comparingInt(o -> -(o.getCells()[4] * 1000 + o.getCells()[5] * 100 + o.getCells()[6] * 10 + o.getCells()[7])));

        List<Organism> infectedZone = filtered.subList(0, Math.min(3, filtered.size()));

        Virus virus = new Virus();
        for (int i = 0; i < infectedZone.size(); i++) {
            virus.infect(infectedZone.get(i), i + 1);
        }

        Antivirus antivirus = new Antivirus();
        for (Organism organism : infectedZone) {
            antivirus.cure(organism);
        }

        System.out.println("Результат лечения:");
        for (Organism organism : infectedZone) {
            System.out.println(Arrays.toString(organism.getCells()));
        }
    }
}