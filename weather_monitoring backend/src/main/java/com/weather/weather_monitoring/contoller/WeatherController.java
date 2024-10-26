package com.weather.weather_monitoring.contoller;

import com.weather.weather_monitoring.entity.WeatherData;
import com.weather.weather_monitoring.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/api/weather")
    public List<WeatherData> getWeatherData() {
        return weatherService.getAllWeatherData();
    }
}