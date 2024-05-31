package org.sparta.task.service;

import org.sparta.task.dto.CommentRequestDto;
import org.sparta.task.dto.CommentResponseDto;
import org.sparta.task.entity.Comment;
import org.sparta.task.entity.Schedule;
import org.sparta.task.repository.CommentRepository;
import org.sparta.task.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {this.commentRepository = commentRepository;}

//       Comment 생성
    public CommentResponseDto createComment (CommentRequestDto requestDto) {
//       RequestDto -> Entity
            Comment comment = new Comment(requestDto);
//        DB 저장
            commentRepository.save(comment);
//        Entity -> requestDto
            CommentResponseDto commentResponseDto = new CommentResponseDto(comment);
            return commentResponseDto;
    }
}


