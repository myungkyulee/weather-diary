package com.example.weatherstudy.repository;

import com.example.weatherstudy.domain.DateWeather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface DateWeatherRepository extends JpaRepository<DateWeather, LocalDate> {
    Optional<DateWeather> findByDate(LocalDate date);
}
