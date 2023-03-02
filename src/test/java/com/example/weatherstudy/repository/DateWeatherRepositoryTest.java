package com.example.weatherstudy.repository;

import com.example.weatherstudy.domain.DateWeather;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class DateWeatherRepositoryTest {

    @Autowired
    public DateWeatherRepository dateWeatherRepository;

    @Test
    public void test(){
        DateWeather weather = dateWeatherRepository.findByDate(LocalDate.now())
                .orElse(new DateWeather());
        System.out.println("weather = " + weather.getWeather());
        System.out.println("date = " + weather.getDate());
        System.out.println("icon = " + weather.getIcon());
        System.out.println("temp = " + weather.getTemperature());
        Assertions.assertThat(weather.getDate()).isEqualTo(LocalDate.now());
    }
}
