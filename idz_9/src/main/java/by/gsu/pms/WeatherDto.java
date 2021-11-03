package by.gsu.pms;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class WeatherDto {
    public Wind getWind() {
        return wind;
    }

    private static class Sys {
        private String country;

        @Override
        public String toString() {
            return country;
        }
    }

    public static class Description {
        private String icon;
        @SerializedName("main")
        private String name;
        @SerializedName("description")
        private String text;

        public String getName() {
            return name;
        }

        public String getText() {
            return text;
        }

        @Override
        public String toString() {
            return name + ";" + text + ";" + icon;
        }

        public String getIcon() {
            return icon;
        }
    }

    private static class Main {
        private double temp;
        private double pressure;
        private double humidity;
        @SerializedName("temp_min")
        private double tempMin;
        @SerializedName("temp_max")
        private double tempMax;

        @Override
        public String toString() {
            return temp + ";" + pressure + ";" + humidity + ";" + tempMin + ";" + tempMax;
        }
    }

    public static class Clouds {
        private double all;

        public double getAll() {
            return all;
        }
    }

    public static class Wind {
        private double speed;
        private double deg;

        public double getSpeed() {
            return speed;
        }

        public double getDeg() {
            return deg;
        }

        public String getDirection(){
            String[] result = {"N", "NW", "W", "SW", "S", "SE", "E", "NE"};

            final int directionNum = 8;

            int dir = (int)Math.round((getDeg() + 360.0 / (directionNum*2)) / (360.0/directionNum));

            return result[dir];
        }

        @Override
        public String toString() {
            return speed + ";" + deg;
        }
    }

    @SerializedName("name")
    private String cityName;
    private Sys sys;
    @SerializedName("weather")
    private Description[] descriptions;
    private Main main;
    private Clouds clouds;
    private Wind wind;

    public Description getDescription() {
        return descriptions[0];
    }

    public String getCityName() {
        return cityName;
    }

    public String getCountry() {
        return sys.country;
    }

    public double getTemp() {
        return kelvinToCelsius(main.temp);
    }

    public double getPressure() {
        return main.pressure/1.333224;
    }

    public double getHumidity() {
        return main.humidity;
    }

    public double getTempMin() {
        return kelvinToCelsius(main.tempMin);
    }

    public double getTempMax() {
        return kelvinToCelsius(main.tempMax);
    }

    public Clouds getClouds() {
        return clouds;
    }

    @Override
    public String toString() {
        return cityName + ";" + sys + ";" + Arrays.toString(descriptions) + ";" + main + ";" + clouds + ";" + wind;
    }

    private static double kelvinToCelsius(double temp){
        return temp - 273.15;
    }
}
