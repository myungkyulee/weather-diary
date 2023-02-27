package com.example.weatherstudy.controller;

import com.example.weatherstudy.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
public class DiaryController {
    private final DiaryService diaryService;

    // 날짜를 저장할 수 있는 방법은 많기 때문에 지정해 주어야 한다.
    // @DateTimeFormat은 날짜를 저장할 수 있는 포맷 중 하나를 설정해주는 애노테이션
    @PostMapping("/create/diary")
    public void createDiary(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
                            @RequestBody String text){
        diaryService.createDiary(date, text);
    }
}