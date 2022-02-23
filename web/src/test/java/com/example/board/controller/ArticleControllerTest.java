package com.example.board.controller;

<<<<<<< HEAD:src/test/java/com/example/board/controller/ArticleControllerTest.java
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

=======
>>>>>>> ceb7cb996074d18cf02d7c81d74315a733c8e33f:web/src/test/java/com/example/board/controller/ArticleControllerTest.java
import com.example.board.service.ArticleService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

<<<<<<< HEAD:src/test/java/com/example/board/controller/ArticleControllerTest.java
=======
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
>>>>>>> ceb7cb996074d18cf02d7c81d74315a733c8e33f:web/src/test/java/com/example/board/controller/ArticleControllerTest.java

@WebMvcTest(ArticleController.class)
class ArticleControllerTest {
    private final MockMvc mvc;
<<<<<<< HEAD:src/test/java/com/example/board/controller/ArticleControllerTest.java
    
    @MockBean
    ArticleService articleService;
    
=======
    @MockBean private ArticleService articleService;

>>>>>>> ceb7cb996074d18cf02d7c81d74315a733c8e33f:web/src/test/java/com/example/board/controller/ArticleControllerTest.java
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
            .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
<<<<<<< HEAD:src/test/java/com/example/board/controller/ArticleControllerTest.java
            .andExpect(view().name("articles/index"));
            //.andExpect(model().attributeExists("articles"));
=======
            .andExpect(view().name("articles/index"))
            .andExpect(model().attributeExists("articles"));
>>>>>>> ceb7cb996074d18cf02d7c81d74315a733c8e33f:web/src/test/java/com/example/board/controller/ArticleControllerTest.java
    }
}