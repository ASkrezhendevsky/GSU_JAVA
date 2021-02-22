import by.gsu.pms.Butter;

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

        Butter butterBuf;
        int minButterIndex = 0;
        int sortedPartHead = 0;
        for (int i = 0; i < butters.length; i++) {
            for (int j = sortedPartHead; j < butters.length; j++) {
                if (butters[j] == null) {
                    continue;
                }
                if (butters[j].compareTo(butters[minButterIndex]) < 0) {
                    minButterIndex = j;
                }
            }
            butterBuf = butters[minButterIndex];
            butters[minButterIndex] = butters[sortedPartHead];
            butters[sortedPartHead] = butterBuf;
            sortedPartHead++;
        }

        System.out.println("\nSorted array:");
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

        System.out.println("Total = "+total);
        System.out.println("Number of butters that has supplements = "+numberOfHasSupplements);

        System.out.println("\nResult array:");
        printButters(butters);
    }

    private static void printButters(Butter[] butters) {
        for (Butter butter : butters) {
            System.out.println(butter);
        }
    }
}
