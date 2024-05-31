package org.sparta.task.service;

import org.sparta.task.dto.ScheduleRequestDto;
import org.sparta.task.dto.ScheduleResponseDto;
import org.sparta.task.entity.Schedule;
import org.sparta.task.repository.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    //    Schedule 생성
    public ScheduleResponseDto createSchedule(ScheduleRequestDto requestDto) {
//      RequestDto -> Entity
        Schedule schedule = new Schedule(requestDto);

//        DB 저장
        scheduleRepository.save(schedule);

//        Entity -> requestDto
        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(schedule);

        return scheduleResponseDto;
    }

    //조회
    public List<ScheduleResponseDto> getSchedule() {
//        해당 schedule 이 DB에 존재하는지 확인
        return scheduleRepository.findAll().stream().map(ScheduleResponseDto::new).toList();
//        ResponseDto 중에 생성자중에 schedule 을 파라미터로 가진 호출자를 불러서 리스트타입으로 바꿔줌
    }

    //수정
    @Transactional
    public Long updateSchedule(Long id, ScheduleRequestDto requestDto) {
//        해당 schedule 이 Db에 있는지 확인
        Schedule schedule = findSchdule(id);
//        Schedule 내용수정 ( 패스워드값이 검증이되면 수정해라)
        if (schedule != null && schedule.getPassword().equals(requestDto.getPassword())) {
            schedule.update(requestDto);
        } else {
            throw new IllegalArgumentException("입력하신 비밀번호가 틀렸습니다");
        }
        return id;
    }

    //삭제
    @Transactional

//        DB에 Schedule 이  존재하는지 확인
    public Long deleteSchedule(Long id, ScheduleRequestDto requestDto) {

//        Schedule 내용 삭제
        Schedule schedule = findSchdule(id);
        if (schedule != null && schedule.getPassword().equals(requestDto.getPassword()))  {
            scheduleRepository.delete(schedule);
            return id;
        } else {
            throw new IllegalArgumentException("입력하신 비밀번호가 틀렸습니다");
        }
    }

    //id 찾는 메소드
    public Schedule findSchdule(Long id) {
        return scheduleRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("해당 스케쥴은 존재하지 않습니다."));
    }
}























