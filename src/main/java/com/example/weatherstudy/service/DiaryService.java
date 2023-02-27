package com.example.weatherstudy.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;

@Service
public class DiaryService {
    // 왜 @Value를 사용해서 key를 가져오는 것인가???
    // test나 실제에 따라 여러가지가 변경될 수 있기 때문에
    // 변경과 무관하게 사용하기 위해 사용한다.
    // 예를 들면 DB변경
    @Value("${openweathermap.key}")
    private String apiKey;


    public void createDiary(LocalDate date, String text) {
        // open weather map에서 데이터 받아오기
        String weatherData = getWeatherString();
    }

    private String getWeatherString() {
        String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=seoul&appid=" + apiKey;

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            BufferedReader br;
            if (responseCode == 200) {
                br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } else {
                br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            }

            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            return response.toString();
        } catch (Exception e) {
            return "failed to get response";
        }
    }
}
