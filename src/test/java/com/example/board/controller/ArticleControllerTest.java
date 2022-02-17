package com.example.board.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ArticleController.class)
class ArticleControllerTest {
    private final MockMvc mvc;

    public ArticleControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @DisplayName("[GET] / articles - 검색어가 없으면, 페이징 목록을 조회한다")
    @Test
    void givenNoParameter_whenRendingArticles_thenReturnsArticlePages() throws Exception {
        mvc.perform(
            get("/articles")
        )
            .andExpect(status().isOk())
//            .andExpect(content().contentType(MediaType))
            .andExpect(view().name("articles/index"));
//            .andExpect(model().attributeExists("articles"));
    }



}