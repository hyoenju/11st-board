package com.example.board.service;

import com.example.board.domain.diary.Diary;
import com.example.board.repository.DiaryRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DiaryService {
    
    private final DiaryRepository diaryRepository;
    
    public List<Diary> getDiaries() {
        LocalDateTime startDatetime = LocalDateTime.of(
          LocalDate.now().minusMonths(0), LocalTime.of(0,0,0)); //어제 00:00:00
        LocalDateTime endDatetime = LocalDateTime.of(LocalDate.now(), LocalTime.of(23,59,59)); //오늘 23:59:59
        List<Diary> diaries = diaryRepository.findByLatestUpdateBetween(startDatetime, endDatetime);
        return diaries;
    }
    
    public void putDiary(Long diaryId, Diary newDiary) {
        diaryRepository.findById(diaryId)
          .map(diary -> {
              diary.setContent(newDiary.getContent());
              diary.setTitle(newDiary.getTitle());
              return diaryRepository.save(diary);
          }).orElseGet(()->{
              return diaryRepository.save(newDiary);
          });
    }
    
    public void deleteDiary(Long diaryId) {
        diaryRepository.deleteById(diaryId);
    }
    
    public Optional<Diary> getDiary(Long diaryId) {
        return diaryRepository.findById(diaryId);
    }
    
    public Diary postDiary(Long diaryId, Diary diary) {
        return diaryRepository.save(diary);
    }
}
