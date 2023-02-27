package com.example.weatherstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class WeatherStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherStudyApplication.class, args);
	}

}
