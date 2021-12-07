package by.gsu.pms.idz_12.formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Locale;

public class LocalDateFormatter implements Formatter<LocalDateTime> {
    public LocalDateFormatter() {
        super();
    }

    public LocalDateTime parse(final String text, final Locale locale) throws ParseException {
        System.out.println("text " + text);
        return LocalDateTime.parse(text);
    }

    public String print(final LocalDateTime object, final Locale locale) {
        System.out.println("print "+object);
        return object.toString();
    }
}