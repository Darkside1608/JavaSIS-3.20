package com.example.Weather.shell;

import com.example.Weather.data.ForeDataService;
import com.example.Weather.web.ForecastService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.stream.Collectors;

@ShellComponent
public class ShellCommands {

    private final ForecastService forecastService;
    private final ForeDataService foreDataService;
    private String city;
    private String temp;

    public ShellCommands(ForecastService forecastService, ForecastService forecastService1, ForeDataService foreDataService) {
        this.forecastService = forecastService1;
        this.foreDataService = foreDataService;
    }

    @ShellMethod("Get temp ")
    public String temp(
            @ShellOption(defaultValue = "Error")
                    String city){
        this.city = city;
        temp = forecastService.getForecast(city);
        return temp;
    }

    @ShellMethod("Save Weather")
    public String save(){
        if (temp == null){
            return "Enter your city";
        } else {
            foreDataService.save(city, temp);
            return "Weather save";
        }
    }

    @ShellMethod("Метод получения всех записей")
    public String showWeather(){
        return foreDataService.selectAll().stream()
                .collect(Collectors.joining(System.lineSeparator()));
    }

}