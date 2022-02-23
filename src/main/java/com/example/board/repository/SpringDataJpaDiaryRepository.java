package com.example.board.repository;

import com.example.board.domain.diary.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaDiaryRepository extends JpaRepository<Diary, Long>, DiaryRepository {

}
