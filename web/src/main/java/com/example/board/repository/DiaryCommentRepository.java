package com.example.board.repository;

import com.example.board.domain.Diary;
import com.example.board.domain.DiaryComment;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryCommentRepository extends JpaRepository<Diary, Long> {
    
    DiaryComment save(DiaryComment diaryComment);
    
    Optional<Diary> findById(Long id);
    
    void deleteById(Long id);
    
}
