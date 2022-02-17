package com.example.board.service;

//import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import com.example.board.domain.Article;
import com.example.board.repository.ArticleRepository;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@SpringBootTest
class ArticleServiceTest {
    @Autowired private ArticleService sut;
    @MockBean private ArticleRepository articleRepository;

    @DisplayName("게시글 목록을 요청하시면, 게시글 목록을 반환한다.")
    @Test
    void givenNothing_whenGetting_thenReturnArticlesList() {
        // Given
        given(articleRepository.findMockArticles()).willReturn(
            List.of(
                Article.of("글1", "test", 0, 0, "#자바", "uno"),
                Article.of("글2", "test", 0, 0, "#자바", "uno"),
                Article.of("글3", "test", 0, 0, "#자바", "uno"),
                Article.of("글4", "test", 0, 0, "#자바", "uno"),
                Article.of("글5", "test", 0, 0, "#자바", "uno"),
                Article.of("글6", "test", 0, 0, "#자바", "uno")
            )
        );

        // When
        List<Article> actual = sut.getArticles();

        // Then
        assertThat(actual).hasSize(6);

        then(articleRepository).should().findMockArticles();
    }
}
