package com.weather.weather_monitoring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class WeatherScheduler {

    @Autowired
    private WeatherService weatherService;

    private final String[] cities = {"Delhi", "Mumbai", "Chennai", "Bangalore", "Kolkata", "Hyderabad"};

    @Scheduled(fixedRateString = "${weather.update.interval}")
    public void updateWeatherData() {
        for (String city : cities) {
            weatherService.fetchWeatherData(city);
        }
    }
}