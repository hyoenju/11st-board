package com.example.board.controller;

<<<<<<< HEAD
import com.example.board.domain.Article;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
=======
import com.example.board.service.ArticleService;
>>>>>>> 4e02202b1398525f5db5abee4867d5586d433a75
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
=======
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@RequiredArgsConstructor
@RequestMapping("/articles")
@Controller
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping
    public ModelAndView articles() {
        Map<String, Object> map = new HashMap<>();
        map.put("articles", articleService.getArticles());
        return new ModelAndView("articles/index", map);
    }

    @PostMapping("")
    public ModelAndView postArticle(@RequestBody Map<String, String> param) {
        Map<String, Object> article = new HashMap<>();
        article.put("likeCount", param.getOrDefault("likeCount", null));
//        "title", "content", "viewCount", "likeCount", "hashtag";

        return new ModelAndView("articles/index");
    }
    
    @PutMapping("/{articleId}")
    public ModelAndView putArticle(@PathVariable Long articleId, Article dto){
        //boardService.update(articleId,dto);
        return new ModelAndView("articles/index");
    }
}
