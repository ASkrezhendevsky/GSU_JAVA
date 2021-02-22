import by.gsu.pms.Butter;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        Butter[] butters = {
                new Butter("name 1", 356, false),
                new Butter("name 2", 427, false),
                new Butter("name 3", 399, true),
                new Butter("name 4", 331, false),
                new Butter("name 5", 349, true),
                new Butter("name 6", 321, false),
                new Butter("name 7", 361, true),
                new Butter("name 8", 377, true),
                new Butter(),
                null
        };
        printButters(butters);

        printButters(butters);

        int total = 0;
        int numberOfHasSupplements = 0;

        for (Butter butter: butters) {
            if(butter.isHasSupplements()){
                numberOfHasSupplements++;
            }
            total += butter.getPrice();
        }

        printButters(butters);
    }

    private static void printButters(Butter[] butters){
        for (Butter butter: butters) {
            System.out.println(butter);
        }
    }
}
