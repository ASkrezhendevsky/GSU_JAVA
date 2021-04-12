import by.gsu.pms.BusinessTrip;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Runner {
    public static void main(String[] args) {
        final String INPUT_FILE = "src/in.txt";

        final String DAILY_RATE_KEY = "daily-rate";
        final String INDICES_KEY = "indices";
        final String ACCOUNT_KEY = "account%02d";
        final String TRANSPORT_KEY = "transport%02d";
        final String DAYS_KEY = "days%02d";

        try (FileInputStream fileInputStream = new FileInputStream(INPUT_FILE)) {
            ResourceBundle resourceBundle = new PropertyResourceBundle(fileInputStream);

            String[] indices = resourceBundle.getString(INDICES_KEY).split("\\s*;\\s*");
            System.out.println(indices);
            BusinessTrip[] businessTrips = new BusinessTrip[indices.length];

            String daylyRate = resourceBundle.getString(DAILY_RATE_KEY);
            System.out.println(daylyRate);

            Enumeration<String> keys = resourceBundle.getKeys();

            for (int i = 0; i < businessTrips.length; i++) {
                int index = Integer.parseInt(indices[i]);
                businessTrips[i] = new BusinessTrip(resourceBundle.getString(String.format(ACCOUNT_KEY, index)),
                        Integer.parseInt(resourceBundle.getString(String.format(TRANSPORT_KEY, index))),
                        Integer.parseInt(resourceBundle.getString(String.format(DAYS_KEY, index))));
                System.out.println(businessTrips[i]);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
