import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Runner {
    public static void main(String[] args) {
        final String INPUT_FILE = "src/in.txt";
        final String DAILY_RATE_KEY = "daily-rate\\s*=\\s*([1-9]\\d*)";
        final String INDICES_KEY = "indices\\s*=\\s*(.*)";
        final String INDICES_VALUES_DELIMITER = "\\s*;\\s*";
        final String TRANSPORT_KEY = "transport";
        final String DAYS_KEY = "days";
        final String ACCOUNT_KEY = "account";
        try (Scanner scanner = new Scanner(new FileReader(INPUT_FILE))) {
            scanner.useLocale(Locale.ENGLISH);

            Matcher keyMatcher = Pattern.compile(DAILY_RATE_KEY).matcher(scanner.nextLine());
            keyMatcher.matches();
            int dailyRate = Integer.parseInt(keyMatcher.group(1));
            System.out.println(dailyRate);

            Matcher indicesMatcher = Pattern.compile(INDICES_KEY).matcher(scanner.nextLine());
            indicesMatcher.matches();
            String[] indices = indicesMatcher.group(1).split(INDICES_VALUES_DELIMITER);
            System.out.println(indices);

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        }
    }
}
