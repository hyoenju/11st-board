package com.example.board.service;

import com.example.board.domain.Diary;
import com.example.board.dto.CalenderDay;
import com.example.board.repository.DiaryRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DiaryService {

    private final DiaryRepository diaryRepository;

    public List<Diary> getDiaries() {
        return diaryRepository.findAll();
    }

    public List<Diary> getThisMonthDiary(LocalDateTime currentDateTime) {
        LocalDateTime startDatetime = LocalDateTime.of(
            LocalDate.from(currentDateTime.withDayOfMonth(1)), LocalTime.of(0, 0, 0)); //이번달 00:00:00
        LocalDateTime endDatetime = LocalDateTime.of(
            LocalDate.from(currentDateTime.with(TemporalAdjusters.lastDayOfMonth())), LocalTime.of(23, 59, 59)); //다음달 00:00:00
        System.out.println("start:" + startDatetime);
        System.out.println("end:" + endDatetime);
        List<Diary> diaries = diaryRepository.findByCreatedAtIsBetween(startDatetime, endDatetime);
        return diaries;
    }

    public void putDiary(Long diaryId, Diary newDiary) {
        diaryRepository.findById(diaryId)
            .map(diary -> {
                diary.setTitle(newDiary.getTitle());
                diary.setContent(newDiary.getContent());
                diary.setHashtag(newDiary.getHashtag());
                diary.setEmotionScore(newDiary.getEmotionScore());
                return diaryRepository.save(diary);
            }).orElseGet(() -> {
                return diaryRepository.save(newDiary);
            });
    }

    public void deleteDiary(Long diaryId) {
        diaryRepository.deleteById(diaryId);
    }

    public Diary getDiary(Long diaryId) {
        return diaryRepository.findById(diaryId).get();
    }

    public Diary postDiary(Diary diary) {
        return diaryRepository.save(diary);
    }

    public List<List<CalenderDay>> getThisMonthCalender(
        LocalDateTime currentDateTime, List<Diary> thisMonthDiaries) {
        List<List<CalenderDay>> calender = new ArrayList<>();
//
//        LocalDateTime firstDateTime;
//        if (thisMonthDiaries.size() > 0) {
//            firstDateTime = thisMonthDiaries.get(0).getCreatedAt();
//        } else {
//            firstDateTime = currentDateTime;
//        }
        int dayOfTheWeek = currentDateTime.getDayOfWeek().getValue();
        int dayOfMonth = LocalDate.from(currentDateTime.with(TemporalAdjusters.lastDayOfMonth()))
            .getDayOfMonth();
        List<CalenderDay> week = new ArrayList<>();
        System.out.println("dayOfTheWeek:" + dayOfTheWeek);
        for (int i = 0; i < dayOfTheWeek; i++) {
            CalenderDay calenderDay = new CalenderDay(0L, false, false, 0,
                LocalDateTime.now().toLocalDate());
            week.add(calenderDay);
        }
        int day = 1;
        System.out.println("dayOfMonth:" + dayOfMonth);
        while (day <= dayOfMonth) {
            LocalDateTime startDatetime = LocalDateTime.of(
                LocalDate.from(currentDateTime.withDayOfMonth(1).plusDays(day - 1)),
                LocalTime.of(0, 0, 0));
            LocalDateTime endDatetime = LocalDateTime.of(
                LocalDate.from(currentDateTime.withDayOfMonth(1).plusDays(day - 1)),
                LocalTime.of(23, 59, 59));
//            System.out.println("start:" + startDatetime);
//            System.out.println("end:" + endDatetime);
            List<Diary> diaries = diaryRepository.findByCreatedAtIsBetween(startDatetime,
                endDatetime);
            //System.out.println("day:"+day+ "\ndiaries size:"+diaries.size());
            CalenderDay calenderDay = new CalenderDay(
                0L, true, false, 0,
                LocalDate.from(currentDateTime.withDayOfMonth(1).plusDays(day - 1)));
            if (diaries.size() != 0) {
//                System.out.println("day:"+day+ "size:"+diaries.size());
                calenderDay = new CalenderDay(diaries.get(0).getId(), true, true,
                    diaries.get(0).getEmotionScore(),
                    LocalDate.from(currentDateTime.withDayOfMonth(1).plusDays(day - 1)));
            }
            week.add(calenderDay);
            if (week.size() == 7) {
                calender.add(new ArrayList<>(week));
                week = new ArrayList<>();
            }

            day++;
        }
        if (week.size() < 7) {
            while (week.size() < 7) {
                week.add(new CalenderDay(0L, false, false, 0, LocalDateTime.now().toLocalDate()));
            }
            calender.add(week);
        }
        return calender;
    }

    public Map<String, Object> getMonthEmotionScores(List<List<CalenderDay>> monthDiaries) {
        Map<String, Object> map = new HashMap<>();
        List<Integer> labels = new ArrayList<>();
        List<Object> data = new ArrayList<>();

        for (List<CalenderDay> week : monthDiaries) {
            for (CalenderDay calenderDay : week) {
                if (calenderDay.isDateExist()) {
                    labels.add(calenderDay.getDate().getDayOfMonth());
                    if (calenderDay.isDiaryExist()) {
                        data.add(calenderDay.getEmotion_score());
                    } else {
                        data.add(null);
                    }
                }
            }
        }
        map.put("labels", labels);
        map.put("data", data);

        return map;
    }
}
