package org.sparta.task.dto;

import lombok.Getter;
import org.sparta.task.entity.Schedule;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponseDto {
    private Long id;
    private String title;
    private String contents;
    private String manager;
    private String password;
    private LocalDateTime createdAt;

    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.contents = schedule.getContents();
        this.manager = schedule.getManager();
        this.password = schedule.getPassword();
        this.createdAt = schedule.getCreatedAt();
    }
}
