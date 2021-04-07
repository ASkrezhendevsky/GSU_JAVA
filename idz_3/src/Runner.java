import by.gsu.pms.Butter;
import by.gsu.pms.ButterDeserialization;
import by.gsu.pms.ButterSerialization;

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

        final String serializationFile = "butter.dat";

        ButterSerialization.serialize(butters, serializationFile);
        butters = ButterDeserialization.deserialize(serializationFile);

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
    }
}
