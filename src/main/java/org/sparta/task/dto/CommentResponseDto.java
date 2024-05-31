package org.sparta.task.dto;

import org.sparta.task.entity.Comment;

import java.time.LocalDateTime;

public class CommentResponseDto {
    private Long id;
    private String comment;
    private String user;
    private LocalDateTime createdAt;

    public CommentResponseDto (Comment comment) {
        this.id = comment.getId();
        this.comment = comment.getComment();
        this.user = comment.getUser();
        this.createdAt = comment.getCreatedAt();
    }
}
