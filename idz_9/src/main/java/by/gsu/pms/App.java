package by.gsu.pms;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;

public class App {
    public static void main(String[] args) throws IOException {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=London,uk&mode=json%20&appid=d2cd789ff21e1066516485bcddbad3a0");
        InputStreamReader reader = new InputStreamReader(url.openStream());

        WeatherDto weatherDto = gson.fromJson(reader, WeatherDto.class);

        File htmlTemplateFile = new File("src/main/resources/template.html");
        String htmlString = FileUtils.readFileToString(htmlTemplateFile, StandardCharsets.UTF_8);
        htmlString = htmlString.replace("$cityName", weatherDto.getCityName());
        htmlString = htmlString.replace("$country", weatherDto.getCountry());
        htmlString = htmlString.replace("$image", weatherDto.getDescription().getIcon());
        htmlString = htmlString.replace("$name", weatherDto.getDescription().getName());
        htmlString = htmlString.replace("$description", weatherDto.getDescription().getText());
        htmlString = htmlString.replace("$temp", String.format("%.1f", weatherDto.getTemp()));
        htmlString = htmlString.replace("$pressure", String.format("%.1f", weatherDto.getPressure()));
        htmlString = htmlString.replace("$humidity", String.format("%.1f", weatherDto.getHumidity()));
        htmlString = htmlString.replace("$maxTemp", String.format("%.1f", weatherDto.getTempMax()));
        htmlString = htmlString.replace("$minTemp", String.format("%.1f", weatherDto.getTempMin()));
        htmlString = htmlString.replace("$speed", String.format("%.1f", weatherDto.getWind().getSpeed()));
        htmlString = htmlString.replace("$direction", weatherDto.getWind().getDirection());
        htmlString = htmlString.replace("$clouds", String.format("%.1f", weatherDto.getClouds().getAll()));
        File newHtmlFile = new File("weather.html");
        FileUtils.writeStringToFile(newHtmlFile, htmlString, StandardCharsets.UTF_8);
    }
}
