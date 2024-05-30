package org.sparta.task.scheduleController;

import org.sparta.task.Dto.ScheduleRequestDto;
import org.sparta.task.Dto.ScheduleResponseDto;
import org.sparta.task.scheduleRepository.ScheduleRepository;
import org.sparta.task.scheduleService.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")

public class ScheduleController {

    private final ScheduleService scheduleService;
    private final ScheduleRepository scheduleRepository;

    public ScheduleController(ScheduleService scheduleService, ScheduleRepository scheduleRepository) {
        this.scheduleService = scheduleService;
        this.scheduleRepository = scheduleRepository;
    }


    // (1) Create 자료생성부분 구현파트
    @PostMapping("/schedule") //Post 형태로 body 부분에 schedule 의 필드값을 넣어준다.
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto requestDto) {
        return scheduleService.createSchedule(requestDto);
    }

    @GetMapping("/schedule") //조회기능 구현위치
    public List<ScheduleResponseDto> getSchedules() {
        return scheduleService.getSchedule();
    }

    @PutMapping("/schedule/{id}") //수정기능 구현위치
    public Long updateSchedule(@PathVariable Long id, @RequestBody ScheduleRequestDto requestDto) {
        return scheduleService.updateSchedule(id, requestDto);
    }

    @DeleteMapping("/schedule/{id}")
    public Long deleteSchedule(@PathVariable Long id, @RequestBody ScheduleRequestDto requestDto) {
        return scheduleService.deleteSchedule(id, requestDto);
    }
}
