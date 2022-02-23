package com.example.board.service;

import com.example.board.domain.Article;
import com.example.board.domain.diary.Diary;
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
    
    public List<Article> postArticle(Long articleId, Article article){
        List<Article> articles = getArticles();
        // int idx = getArticle();
        //articles.set(idx,article);
        //레포 추가하는 작업도 필요.
        return articles;
    }
}
