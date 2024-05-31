package org.sparta.task.dto;

import lombok.Getter;

@Getter
public class CommentRequestDto {
    private Long id;
    private Long scheduleId;
    private String comment;
    private String user;
}
