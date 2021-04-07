package by.gsu.pms;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ButterDeserialization {
    private ButterDeserialization(){}

    public static Butter[] deserialize(String file) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
            return (Butter[]) inputStream.readObject();
        } catch (Exception e) {
            return new Butter[0];
        }
    }
}
