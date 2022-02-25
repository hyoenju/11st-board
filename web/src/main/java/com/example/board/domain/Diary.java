package com.example.board.domain;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString
@Entity
public class
Diary {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Setter
    private String title;
    @Setter
    private String content;
    @Setter
    private String hashtag;
    @Setter
    private double emotionScore;
    @Setter
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    
    
    public Diary(String title, String content, String hashtag, double emotionScore, LocalDateTime createdAt) {
        this.title = title;
        this.content = content;
        this.hashtag = hashtag;
        this.emotionScore=emotionScore;
        this.createdAt = createdAt;
        this.modifiedAt = createdAt;
    }
}
