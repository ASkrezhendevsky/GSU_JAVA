import by.gsu.pms.Airline;
import by.gsu.pms.WeekDay;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalTime;
import java.util.*;

public class Runner {
    public static void main(String[] args) {

        final String file = "src/in.csv";

        final String targetDestination = "Minsk";
        final WeekDay targetWeekDay = WeekDay.FRIDAY;
        final LocalTime targetLocalTime = LocalTime.parse("14:00");

        try (Scanner scanner = new Scanner(new FileReader(file))) {
            List<Airline> airlines = new ArrayList<>();

            while (scanner.hasNext()){
                airlines.add(new Airline(scanner));
            }

            Collections.sort(airlines);

            List<Airline> targetDestinationLines = new ArrayList<>();
            List<Airline> targetWeekDayLines = new ArrayList<>();
            List<Airline> targetLocalTimeLines = new ArrayList<>();

            for (Airline airline:
                    airlines) {
                if (targetDestination.equals(airline.getDestination())){
                    targetDestinationLines.add(airline);
                }

                for (WeekDay weekDay :
                        airline.getWeekDays()) {
                    if (targetWeekDay.equals(weekDay)){
                        targetWeekDayLines.add(airline);
                        break;
                    }
                }
                if (targetLocalTime.compareTo(airline.getDepartureTime()) > 0){
                    targetLocalTimeLines.add(airline);
                }
            }

            airlines.forEach(System.out::println);

            System.out.println("\ntargetDestinationLines:");
            targetDestinationLines.forEach(System.out::println);

            System.out.println("\ntargetWeekDayLines:");
            targetWeekDayLines.forEach(System.out::println);

            System.out.println("\ntargetLocalTimeLines:");
            targetLocalTimeLines.forEach(System.out::println);
        }
        catch (FileNotFoundException e){
            System.err.println("file not found");
        }
    }
}

