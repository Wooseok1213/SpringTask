package org.sparta.task.Dto;

import lombok.Getter;

@Getter
public class ScheduleRequestDto {
    private String title;
    private String contents;
    private String manager;
    private int password;
    private int date;
}
