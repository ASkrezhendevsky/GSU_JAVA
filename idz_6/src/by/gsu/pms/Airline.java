package by.gsu.pms;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Scanner;

public class Airline implements Comparable<Airline>{
    private String destination;
    private int flightNumber;
    private String aircraftType;
    private LocalTime departureTime;
    private WeekDay[] weekDays;

    public Airline(String destination, int flightNumber, String aircraftType, LocalTime departureTime, WeekDay[] weekDays) {
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.aircraftType = aircraftType;
        this.departureTime = departureTime;
        this.weekDays = weekDays;
    }

    public Airline(String destination, int flightNumber, String aircraftType, String departureTime, WeekDay[] weekDays){
        this(destination, flightNumber, aircraftType, LocalTime.parse(departureTime), weekDays);
    }

    public Airline(Scanner scanner){
        this(scanner.next(), scanner.nextInt(), scanner.next(), scanner.next(), WeekDay.parseArray(scanner));
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(String aircraftType) {
        this.aircraftType = aircraftType;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public WeekDay[] getWeekDays() {
        return weekDays;
    }

    public void setWeekDays(WeekDay[] weekDays) {
        this.weekDays = weekDays;
    }

    @Override
    public String toString() {
        return "Airline{" +
                "destination='" + destination + '\'' +
                ", flightNumber=" + flightNumber +
                ", aircraftType='" + aircraftType + '\'' +
                ", departureTime=" + departureTime +
                ", weekDays=" + Arrays.toString(weekDays) +
                '}';
    }

    @Override
    public int compareTo(Airline airline) {
        return destination.compareTo(airline.destination);
    }
}
