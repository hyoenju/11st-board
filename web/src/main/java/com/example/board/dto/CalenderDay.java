package com.example.board.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@Getter
public class CalenderDay {
    
    private Long id;
    private boolean exist;
    private double emotion_score;
    private LocalDate date;
    
    public CalenderDay(Long id, boolean exist, double emotion_score, LocalDate date) {
        this.id = id;
        this.exist = exist;
        this.emotion_score = emotion_score;
        this.date = date;
    }
}

