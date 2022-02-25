package com.example.board.controller;

import com.example.board.domain.Diary;
import com.example.board.dto.CalenderDay;
import com.example.board.dto.ScoreResponse;
import com.example.board.service.DiaryService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@RequestMapping("/diaries")
@Controller
public class DiaryController {

    private final DiaryService diaryService;
    private final RestTemplate restTemplate;

    @GetMapping
    public ModelAndView diaries(@RequestParam Optional<String> date) {
        String baseMonth = date.orElse(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM")));
        List<Integer> monthList = Arrays.stream(baseMonth.split("-")).mapToInt(Integer::parseInt).boxed().toList();
        LocalDateTime currentDateTime = LocalDateTime.of(monthList.get(0), monthList.get(1), 1, 0, 0);

        Map<String, Object> map = new HashMap<>();
        List<Diary> thisMonthDiaries = diaryService.getThisMonthDiary(currentDateTime);
        List<List<CalenderDay>> calenderDiaries = diaryService.getThisMonthCalender(currentDateTime, thisMonthDiaries);
        Map<String, Object> emotionScores = diaryService.getMonthEmotionScores(calenderDiaries);

        map.put("calendar", calenderDiaries);
        map.put("date", currentDateTime);
        map.put("scoreData", emotionScores.get("data"));
        map.put("scoreLabels", emotionScores.get("labels"));

        return new ModelAndView("diaries/index", map);
    }

    @GetMapping("/{diaryId}")
    public ModelAndView getDiary(@PathVariable Long diaryId) {
        Map<String, Object> map = new HashMap<>();
        map.put("diary", diaryService.getDiary(diaryId));
        return new ModelAndView("diaries/board_view", map);
    }
    
    @PostMapping
    public String postDiary(Diary diary) {
        String baseUrl = "http://localhost:8000/ml?content=" + diary.getContent();
        ResponseEntity<ScoreResponse> responseEntity = restTemplate.getForEntity(baseUrl,
          ScoreResponse.class);
        double emotionScore = responseEntity.getBody().getScore();
        diary.setEmotionScore(emotionScore);
        Long diaryId = diaryService.postDiary(diary).getId();
        return "redirect:/diaries/"+diaryId;
    }
    
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
    
    @PutMapping("/edit/{diaryId}")
    public String putDiary(@PathVariable Long diaryId, String content, @ModelAttribute Diary diary) {
        System.out.println("put method");
        System.out.println("content: "+content);
        System.out.println(diary);
        String baseUrl = "http://localhost:8000/ml?content=" + diary.getContent();
        ResponseEntity<ScoreResponse> responseEntity = restTemplate.getForEntity(baseUrl,
          ScoreResponse.class);
        double emotionScore = responseEntity.getBody().getScore();
        diary.setEmotionScore(emotionScore);
        diaryService.putDiary(diaryId, diary);
        return "redirect:/diaries/" + diaryId;
    }
    
    @DeleteMapping("/{diaryId}")
    public String deleteDiary(@PathVariable Long diaryId) {
        System.out.println("delete method");
        System.out.println(diaryId);
        diaryService.deleteDiary(diaryId);
        return "redirect:/diaries";
    }

}