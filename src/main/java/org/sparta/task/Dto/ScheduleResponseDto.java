package org.sparta.task.Dto;

import lombok.Getter;

@Getter
public class ScheduleResponseDto {
    private Long id;
    private String title;
    private String contents;
    private String manager;
    private int password;
    private int date;
}
