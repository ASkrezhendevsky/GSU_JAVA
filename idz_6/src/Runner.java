import by.gsu.pms.Airline;
import by.gsu.pms.WeekDay;

import java.time.LocalTime;

public class Runner {
    public static void main(String[] args) {
        Airline airline = new Airline("Minsk",
                84721165,
                "Big",
                LocalTime.parse("12:00"),
                new WeekDay[] {
                    WeekDay.FRIDAY
                }
        );

        System.out.println(airline);
    }
}

