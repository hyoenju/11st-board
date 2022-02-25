package com.example.board.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
public class DiaryRequestDto {
    @Setter
    private String title;
    @Setter
    private String content;
    @Setter
    private String hashtag;
    @Setter
    private double emotionScore;
    @Setter
    private String createdAt;
}
