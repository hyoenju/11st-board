package com.example.board.controller;

import com.example.board.domain.Diary;
import com.example.board.service.DiaryService;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@RequestMapping("/diaries")
@Controller
public class DiaryController {
    
    private final DiaryService diaryService;
    
    @GetMapping
    public ModelAndView diaries() {
        Map<String, Object> map = new HashMap<>();
        map.put("diaries", diaryService.getDiaries());
        return new ModelAndView("diaries/index");
    }
    
    @GetMapping("/{diaryId}")
    public ModelAndView getDiary(@PathVariable Long diaryId){
        Map<String, Object> map = new HashMap<>();
        map.put("diary", diaryService.getDiary(diaryId));
        return new ModelAndView("diaries/board_view",map);
    }
    
    @GetMapping("/write")
    public ModelAndView writeDiary(){
        return new ModelAndView("diaries/board_write");
    }
    
    @GetMapping("/edit/{diaryId}")
    public ModelAndView editDiary(@PathVariable Long diaryId){
        Map<String, Object> map = new HashMap<>();
        map.put("diary", diaryService.getDiary(diaryId));
        return new ModelAndView("diaries/board_edit",map);
    }
    
    @PostMapping
    public ModelAndView postDiary(Diary diary){
        Map<String, Object> map = new HashMap<>();
        map.put("diary",diaryService.postDiary(diary));
        return new ModelAndView("articles/index",map);
    }
    
    @PutMapping("/{diaryId}")
    public ModelAndView putDiary(@PathVariable Long diaryId, Diary diary){
        diaryService.putDiary(diaryId, diary);
        return new ModelAndView("articles/index");
    }
    
    @DeleteMapping("/{diaryId}")
    public ModelAndView deleteDiary(@PathVariable Long diaryId){
        diaryService.deleteDiary(diaryId);
        return new ModelAndView("articles/index");
    }
    
}
