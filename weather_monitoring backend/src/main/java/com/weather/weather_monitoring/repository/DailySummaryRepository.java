package com.weather.weather_monitoring.repository;

import com.weather.weather_monitoring.entity.DailySummary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailySummaryRepository extends JpaRepository<DailySummary, Long> {
}