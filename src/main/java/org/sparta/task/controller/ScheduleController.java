package org.sparta.task.controller;

import org.sparta.task.dto.ScheduleRequestDto;
import org.sparta.task.dto.ScheduleResponseDto;
import org.sparta.task.repository.ScheduleRepository;
import org.sparta.task.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task/schedule")

public class ScheduleController {

    private final ScheduleService scheduleService;
    private final ScheduleRepository scheduleRepository;

    public ScheduleController(ScheduleService scheduleService, ScheduleRepository scheduleRepository) {
        this.scheduleService = scheduleService;
        this.scheduleRepository = scheduleRepository;
    }


    // (1) Create 자료생성부분 구현파트
    @PostMapping //Post 형태로 body 부분에 schedule 의 필드값을 넣어준다.
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto requestDto) {
        return scheduleService.createSchedule(requestDto);
    }

    @GetMapping //조회기능 구현위치
    public List<ScheduleResponseDto> getSchedules() {
        return scheduleService.getSchedule();
    }

    @PutMapping("/{id}") //수정기능 구현위치
    public Long updateSchedule(@PathVariable Long id, @RequestBody ScheduleRequestDto requestDto) {
        return scheduleService.updateSchedule(id, requestDto);
    }

    @DeleteMapping("/{id}")
    public Long deleteSchedule(@PathVariable Long id, @RequestBody ScheduleRequestDto requestDto) {
        return scheduleService.deleteSchedule(id, requestDto);
    }
}
