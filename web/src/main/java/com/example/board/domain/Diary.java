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
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Setter private String title;
    @Setter private String content;
    
    private LocalDateTime createdAt;
    @Setter private String createdBy;
    private LocalDateTime modifiedAt;
    @Setter private String modifiedBy;
    
    public Diary(String title, String content, String createdBy) {
        this.title = title;
        this.content = content;
        this.createdBy = createdBy;
        this.modifiedBy = createdBy;
    }
    
    public static Diary of(String title, String content, String createdBy) {
        Diary diary = new Diary(title, content, createdBy);
        diary.createdAt = LocalDateTime.now();
        diary.modifiedAt = diary.createdAt;
        return diary;
    }
}