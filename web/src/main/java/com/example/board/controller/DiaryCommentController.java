package com.example.board.controller;

import com.example.board.service.DiaryCommentService;
import com.example.board.service.DiaryService;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@RequestMapping("/diaries")
@Controller
public class DiaryCommentController {
    private final DiaryCommentService diaryCommentService;
    
    @GetMapping("/{diaryId}/comments")
    public ModelAndView comments(@PathVariable Long diaryId) {
        Map<String, Object> map = new HashMap<>();
        map.put("comments", diaryCommentService.getComments(diaryId));
        return new ModelAndView("diaries/index", map);
    }
    
    @DeleteMapping("/{diariId}/{commentId}")
    public String deleteComment(@PathVariable Long diaryId, @PathVariable Long commentId){
        diaryCommentService.deleteComment(diaryId,commentId);
        return "redirect:/diaries";
    }

}
