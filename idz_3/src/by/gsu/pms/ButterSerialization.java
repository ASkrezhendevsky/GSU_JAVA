package by.gsu.pms;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ButterSerialization {
    private ButterSerialization(){}

    public static void serialize(Butter[] butters, String file) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            outputStream.writeObject(butters);
        } catch (Exception e) {
        }
    }
}
