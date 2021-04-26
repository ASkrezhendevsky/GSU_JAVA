package by.gsu.pms;

import java.util.Arrays;
import java.util.Date;

public class Airline implements Comparable<Airline>{
    private String destination;
    private int flightNumber;
    private String aircraftType;
    private Date departureTime;
    private WeekDay[] weekDays;

    public Airline(String destination, int flightNumber, String aircraftType, Date departureTime, WeekDay[] weekDays) {
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.aircraftType = aircraftType;
        this.departureTime = departureTime;
        this.weekDays = weekDays;
        Time time = new Time();
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

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
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
                ", aricraftType='" + aircraftType + '\'' +
                ", departureTime=" + departureTime +
                ", weekDays=" + Arrays.toString(weekDays) +
                '}';
    }

    @Override
    public int compareTo(Airline airline) {
        return destination.compareTo(airline.destination);
    }
}
