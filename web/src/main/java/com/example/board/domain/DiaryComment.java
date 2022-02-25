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
public class DiaryComment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Setter private Long diaryId;
    @Setter private String content;
    
    private LocalDateTime createdAt;
    @Setter private String createdBy;
    
    public DiaryComment(Long diaryId, String content, String createdBy) {
        this.diaryId = diaryId;
        this.content = content;
        this.createdBy = createdBy;
    }
}
