package org.sparta.task.Dto;

import lombok.Getter;
import org.sparta.task.entity.Schedule;

@Getter
public class ScheduleResponseDto {
    private Long id;
    private String title;
    private String contents;
    private String manager;
    private String date;
    private int password;

    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.contents = schedule.getContents();
        this.manager = schedule.getManager();
        this.password = schedule.getPassword();
        this.date = schedule.getDate();
    }
}
