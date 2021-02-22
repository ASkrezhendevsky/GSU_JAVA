import by.gsu.pms.Butter;
import by.gsu.pms.ButterNameComparator;
import by.gsu.pms.ButterPriceComparator;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        Butter[] butters = {
                new Butter("name 1", 356, false),
                new Butter("name 2", 427, false),
                new Butter("name 3", 399, true),
                new Butter("name 4", 331, false),
                new Butter("name 5", 349, true),
                new Butter("name 6", 331, false),
                new Butter("name 7", 361, true),
                new Butter("name 8", 377, true),
                new Butter(),
                null
        };
        System.out.println("\nBefore sorting");
        printButters(butters);

        Arrays.sort(butters, new ButterPriceComparator());

        System.out.println("\nSorted by price array:");
        printButters(butters);

        int total = 0;
        int numberOfHasSupplements = 0;

        for (Butter butter : butters) {
            if (butter == null) {
                continue;
            }
            if (butter.isHasSupplements()) {
                numberOfHasSupplements++;
            }
            total += butter.getPrice();
        }

        System.out.println("Total = " + total);
        System.out.println("Number of butters that has supplements = " + numberOfHasSupplements);

        Arrays.sort(butters, new ButterNameComparator());

        System.out.println("\nSorted by name array:");
        printButters(butters);
    }

    private static void printButters(Butter[] butters) {
        for (Butter butter : butters) {
            System.out.println(butter);
        }
    }
}
