package com.example.weatherstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
//스케줄링 기능을 사용할 수 있게 활성화시켜줌 - @Scheduled사용가능
@EnableScheduling
public class WeatherStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherStudyApplication.class, args);
	}

}
