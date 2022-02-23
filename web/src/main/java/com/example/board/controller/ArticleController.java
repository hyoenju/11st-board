package com.example.board.controller;

import com.example.board.domain.Article;
import com.example.board.service.ArticleService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@RequestMapping("/articles")
@Controller
public class ArticleController {
//    private final ObjectMapper mapper;
    private final ArticleService articleService;

    @GetMapping("")
    public ModelAndView articles() {
        Map<String, Object> map = new HashMap<>();
        map.put("articles", articleService.getArticles());
        return new ModelAndView("articles/index");
    }
    
//    @PutMapping("/{articleId}")
//    public ModelAndView putArticle(@PathVariable Long articleId, Article article){
//        ArticleService.postArticle(articleId, article);
//        return new ModelAndView("articles/index");
//    }
}
