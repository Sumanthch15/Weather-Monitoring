package com.weather.weather_monitoring.service;


import com.weather.weather_monitoring.entity.WeatherData;
import com.weather.weather_monitoring.repository.WeatherDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class WeatherService {


    @Autowired
    private WeatherDataRepository weatherDataRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WeatherConfig config;

    public void fetchWeatherData(String city) {
        String apiUrl = config.getApiUrl().replace("{city}", city).replace("{apiKey}", config.getApiKey());
        Map<String, Object> response = restTemplate.getForObject(apiUrl, Map.class);

        double tempKelvin = (double) ((Map<String, Object>) response.get("main")).get("temp");
        double feelsLikeKelvin = (double) ((Map<String, Object>) response.get("main")).get("feels_like");
        String mainCondition = (String) ((Map<String, Object>) response.get("weather")).get("main");

        // Convert Kelvin to Celsius
        double tempCelsius = tempKelvin - 273.15;
        double feelsLikeCelsius = feelsLikeKelvin - 273.15;

        WeatherData data = new WeatherData(null, city, tempCelsius, feelsLikeCelsius, mainCondition, LocalDateTime.now());
        weatherDataRepository.save(data);
    }

    public List<WeatherData> getAllWeatherData() {
        return weatherDataRepository.findAll();
    }
}