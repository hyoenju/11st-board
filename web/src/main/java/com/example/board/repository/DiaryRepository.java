package com.example.board.repository;

import com.example.board.domain.diary.Diary;
import java.util.List;
import java.util.Optional;

public interface DiaryRepository {
    Diary save(Diary diary);
    Optional<Diary> findById(Long id);
    Optional<Diary> findByTitle(String title);
    List<Diary> findAll();
}
