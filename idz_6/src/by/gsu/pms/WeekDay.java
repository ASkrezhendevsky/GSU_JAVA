package by.gsu.pms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public enum WeekDay {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;

    public static WeekDay parse(String weekDay){
        return WeekDay.valueOf(weekDay.toUpperCase());
    }

    public static WeekDay[] parseArray(Scanner scanner){
        List<WeekDay> weekDays = new ArrayList<>();

        for (String weekDay: scanner.nextLine().trim().split("\\s+")) {
            weekDays.add(parse(weekDay));
        }

        return weekDays.toArray(new WeekDay[0]);
    }
}