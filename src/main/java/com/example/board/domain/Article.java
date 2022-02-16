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
public class Article {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter private String title;
    @Setter private String content;
    @Setter private Integer viewCount; // null 가능
    @Setter private Integer likeCount;
    @Setter private String hashtag;

    private LocalDateTime createdAt;
    @Setter private String createdBy;
    private LocalDateTime modifiedAt;
    @Setter private String modifiedBy;

    public Article(String title, String content, Integer viewCount, Integer likeCount,
        String hashtag, String createdBy) {
        this.title = title;
        this.content = content;
        this.viewCount = viewCount;
        this.likeCount = likeCount;
        this.hashtag = hashtag;
        this.createdBy = createdBy;
        this.modifiedBy = createdBy;
    }
}
