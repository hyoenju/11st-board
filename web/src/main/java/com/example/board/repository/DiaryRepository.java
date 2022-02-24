package com.example.board.repository;

import com.example.board.domain.Diary;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryRepository extends JpaRepository<Diary, Long> {
    
    Diary save(Diary diary);
    
    Optional<Diary> findById(Long id);
    
    void deleteById(Long id);
    
    List<Diary> findAll();
    List<Diary> findByCreatedAtIsBetween(LocalDateTime start, LocalDateTime end);
}
