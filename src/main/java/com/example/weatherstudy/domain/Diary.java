package com.example.weatherstudy.domain;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Diary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String weather;
    private String icon;
    private double temperature;
    private LocalDate date;
    private String text;
    public void setDateWeather(DateWeather dateWeather) {
        date = dateWeather.getDate();
        temperature = dateWeather.getTemperature();
        icon = dateWeather.getIcon();
    }
}
