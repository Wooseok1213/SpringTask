package org.sparta.task.dto;

import lombok.Getter;

@Getter
public class ScheduleRequestDto {
    private String title;
    private String contents;
    private String manager;
    private String date;
    private String password;
}
