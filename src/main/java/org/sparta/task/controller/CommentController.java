package org.sparta.task.controller;

import org.sparta.task.dto.*;
import org.sparta.task.repository.CommentRepository;
import org.sparta.task.service.CommentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CommentController {

    private final CommentService commentService;
    private final CommentRepository commentRepository;

    public CommentController(CommentService commentService, CommentRepository commentRepository) {
        this.commentService = commentService;
        this.commentRepository = commentRepository;
    }

    // (1) Create 댓글생성부분 구현
    @PostMapping("/{id}/comment") //Post 형태로 body 에 값을 넣어준다.
    public CommentResponseDto createComment(@RequestBody CommentRequestDto requestDto) {
        return commentService.createComment(requestDto);
    }
}
