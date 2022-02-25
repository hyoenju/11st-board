package com.example.board.service;

import com.example.board.domain.DiaryComment;
import com.example.board.repository.DiaryCommentRepository;
import com.example.board.repository.DiaryRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DiaryCommentService {
    
    private final DiaryCommentRepository diaryCommentRepository;
    
    public List<DiaryComment> getComments(Long diaryId) {
        return null;
    }
    
    public void deleteComment(Long diaryId, Long commentId) {
    
    }
}
