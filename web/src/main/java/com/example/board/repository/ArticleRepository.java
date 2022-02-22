package com.example.board.repository;

import com.example.board.domain.Article;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ArticleRepository extends JpaRepository<Article, Long> {

    default List<Article> findMockArticles() {
        return List.of(
            Article.of("글1", "test", 0, 0, "#자바", "uno"),
            Article.of("글2", "test", 0, 0, "#자바", "uno"),
            Article.of("글3", "test", 0, 0, "#자바", "uno"),
            Article.of("글4", "test", 0, 0, "#자바", "uno"),
            Article.of("글5", "test", 0, 0, "#자바", "uno"),
            Article.of("글6", "test", 0, 0, "#자바", "uno")
        );
    };
}
