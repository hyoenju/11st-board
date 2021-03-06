package com.example.board.service;

import com.example.board.domain.Diary;
import com.example.board.dto.CalenderDay;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DiaryServiceTest {

    @Autowired
    DiaryService diaryService;

    @Test
    public void getThisMonthDiaryTest() {
        LocalDateTime localDateTime = LocalDateTime.of(2022, 2, 1, 0, 0,0);
        List<Diary> thisMonthDiaries = diaryService.getThisMonthDiary(localDateTime);
        System.out.println("month size:" + thisMonthDiaries.size());
        List<Diary> diaries = diaryService.getDiaries();
        System.out.println("entire size:" + diaries.size());
    }

    @Test
    public void getCalenderTest() {
        LocalDateTime localDateTime = LocalDateTime.of(2022, 2, 1, 0, 0,0);
        List<Diary> thisMonthDiaries = diaryService.getThisMonthDiary(localDateTime);
        List<List<CalenderDay>> calender = diaryService.getThisMonthCalender(localDateTime);
        for (int i = 0; i < calender.size(); i++) {
            for (int j = 0; j < calender.get(0).size(); j++) {
                System.out.println("day:"+(i*7+j));
                System.out.println(calender.get(i).get(j));
            }
            System.out.println();
        }
    }

}
