package com.example.board.service;

import com.example.board.domain.Article;
import com.example.board.repository.ArticleRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public List<Article> getArticles() {
        return articleRepository.findMockArticles();
    }
}
