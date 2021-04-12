import by.gsu.pms.Butter;
import by.gsu.pms.ButterDeserialization;
import by.gsu.pms.ButterSerialization;

import java.io.*;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        final int MAX_BUTTERS = 10;
        Butter[] butters = new Butter[MAX_BUTTERS];
        final String CSV_FILE = "src/butter.scv";

        try (Scanner scanner = new Scanner(new FileReader(CSV_FILE))) {
            for (int i = 0; i < MAX_BUTTERS; i++) {
                butters[i] = new Butter(scanner);
            }
            final String DAT_FILE = "src/butter.dat";
            final String EXTERNALIZE_FILE = "src/butterExternalize.dat";

            ButterSerialization.serialize(butters, DAT_FILE);
            butters = ButterDeserialization.deserialize(DAT_FILE);

            int total = 0;
            int numberOfHasSupplements = 0;

            for (Butter butter : butters) {
                System.out.println(butter);

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
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        }
    }
}
