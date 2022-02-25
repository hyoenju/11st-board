package com.example.board.controller;

import com.example.board.domain.Diary;
import com.example.board.dto.ScoreResponse;
import com.example.board.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@RequestMapping("/diaries")
@Controller
public class ApiController {

    private final DiaryService diaryService;
    private final RestTemplate restTemplate;

    @ResponseBody
    @GetMapping("/test_api")
    public String postDiary(Diary diary) {
        String baseUrl = "http://localhost:8000/ml?content=" + diary.getContent();
        ResponseEntity<ScoreResponse> responseEntity = restTemplate.getForEntity(baseUrl,
            ScoreResponse.class);
        Double emotionScore = responseEntity.getBody().getScore();
        return emotionScore.toString();
    }

}