package com.weather.weather_monitoring.repository;

import com.weather.weather_monitoring.entity.WeatherData;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface WeatherDataRepository extends JpaRepository<WeatherData, Long> {
    List<WeatherData> findByCity(String city);
}
