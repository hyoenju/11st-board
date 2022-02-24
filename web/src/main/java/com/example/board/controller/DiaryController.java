package com.example.board.controller;

import com.example.board.domain.Diary;
import com.example.board.dto.ScoreResponse;
import com.example.board.service.DiaryService;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@RequestMapping("/diaries")
@Controller
public class DiaryController {
    
    private final DiaryService diaryService;
    //private final RestTemplate restTemplate;

    @GetMapping
    public ModelAndView diaries() {
        Map<String, Object> map = new HashMap<>();
        map.put("diaries", diaryService.getDiaries());
        return new ModelAndView("diaries/index", map);
    }
    
    @GetMapping("/{diaryId}")
    public ModelAndView getDiary(@PathVariable Long diaryId) {
        Map<String, Object> map = new HashMap<>();
        map.put("diary", diaryService.getDiary(diaryId));
        return new ModelAndView("diaries/board_view", map);
    }
    
//    public String postDiary(Diary diary) {
//        String baseUrl = "http://localhost:8000/ml?content=" + diary.getContent();
//        ResponseEntity<ScoreResponse> responseEntity = restTemplate.getForEntity(baseUrl,
//          ScoreResponse.class);
//        double emotionScore = responseEntity.getBody().getScore();
//        diary.setEmotionScore(emotionScore);
//        Long diaryId = diaryService.postDiary(diary).getId();
//        return "redirect:/diaries/"+diaryId;
//    }
    
    @GetMapping("/write")
    public String writeDiary() {
        return "diaries/board_write";
    }
    
    @GetMapping("/edit/{diaryId}")
    public ModelAndView editDiary(@PathVariable Long diaryId) {
        Map<String, Object> map = new HashMap<>();
        map.put("diary", diaryService.getDiary(diaryId));
        return new ModelAndView("diaries/board_edit", map);
    }
    
    @PutMapping("/{diaryId}")
    public String putDiary(@PathVariable Long diaryId, Diary diary) {
        diaryService.putDiary(diaryId, diary);
        return "redirect:/diaries/" + diaryId;
    }
    
    @DeleteMapping("/{diaryId}")
    public String deleteDiary(@PathVariable Long diaryId){
        diaryService.deleteDiary(diaryId);
        return "redirect:/diaries";
    }
    
}
