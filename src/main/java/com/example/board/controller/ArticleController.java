package com.example.board.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/articles")
@Controller
public class ArticleController {
//    private final ObjectMapper mapper;

    @GetMapping("")
    public ModelAndView articles() {
        Map<String, Object> map = new HashMap<>();
        map.put("articles", null);

        return new ModelAndView("articles/index");
    }
}
