package org.sparta.task.ScheduleController;

import org.sparta.task.Dto.ScheduleRequestDto;
import org.sparta.task.Dto.ScheduleResponseDto;
import org.sparta.task.entity.Schedule;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/task")

public class ScheduleController {
    //작성한 Schedule들을 편하게 하나의 객체로 관리하기 위한 Collection 그중에서도 Key로 값을 찾을수있는 Map을 사용한다.
    private final Map<Long, Schedule> scheduleList = new HashMap<>();

//    private void findId() {
//        scheduleList.
//    }
    // (1) Create 자료생성부분 구현파트
    @PostMapping("/schedule") //Post 형태로 body 부분에 schedule 의 필드값을 넣어준다.
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto requestDto) {

        Schedule schedule = new Schedule(requestDto);

        /* ScheduleResponseDto(클라이언트한테 보내줄 응답) = ScheduleRequestDto requestDto (클라이언트의 요구사항)
         (1).우선적으로 requestDto -> Entity 값으로 수정해준 후 Entity 값을 다시 Dto Class 로 전달한다.
             *그래서 위 Input 값에 Dto가 들어가고있는 모습이다.
         */

        Long maxId = scheduleList.size() > 0 ? Collections.max(scheduleList.keySet()) + 1 : 1;
        //scheduleList.size()는 기본적으로 0 보다같거나 크기때문에 값을 넣는 시점부터는 false 값이 나올수가 없다.
        //그렇기 때문에 maxId는 값을 입력할때마다 1씩 증가한다.

        schedule.setId(maxId);
        //schedule의 id값을 maxId로 지정시켜 입력을 할 때마다 maxId의 값이 1씩 올라갈때마다 schedule의 Id도 1씩 올라
        // Post 1개마다 각기다른 Id를 지정시킬수있다.

        scheduleList.put(schedule.getId(), schedule);
        //scheduleList Collection 에 지정된 schedule Id와, Schedule 의 필드값인 제목, 일정, 관리자, 날짜, 비밀번호를 하나의 객체로 집어넣는다.

        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(schedule);
        //Dto에 Entity를 넣어주는 과정이다. schedule 의 id 값으로 그 안에 저장된 필드값들을 모두 조회, 수정, 삭제할수있도록 하나의 객체를 관리할 수 있다.

        return scheduleResponseDto;
        /*맨처음 인풋으로 요구한 ScheduleRequestDto 에 대하여 scheduleResponseDto 값을 반환시켜준다.
        맨처음 Dto 에서 Entity 로 변경한 값들은 결국 컬렉션에 하나의 객체로 담아서
        효울적인 관리를 위해서 다시 Dto로 구조변경시켜 리턴해준다.
         */
    }

    @GetMapping("/schedule") //조회기능 구현위치
    public List<ScheduleResponseDto> getSchedules() {
        //Map에있는 자료들을 List로 반환시켜 볼수있게해준다.
        List<ScheduleResponseDto> responseList = scheduleList.values().stream()
                .map(ScheduleResponseDto::new).toList();
// stream = value 에 있는 값들을 하나씩 반복해가며 비교해준다 반복문이지만 for 문보다 코드가짧고 가독성이좋음
        return responseList;
    }

    @PutMapping("/schedule/{id}") //수정기능 구현위치
    public ScheduleResponseDto updateSchedule(@PathVariable Long id, @RequestBody ScheduleRequestDto requestDto) {
        //일정수정  = id 값을 키로 받아서 ScheduleRequestDto requestDto를 반환해준다.
        if (scheduleList.containsKey(id)) {
            //일정리스트에 ID가 포함되어있다면
            Schedule schedule = scheduleList.get(id);
            // id가 포함된 일정을 지정시킨다.

            schedule.update(requestDto);
            //ScheduleRequestDto requestDto를 새로운 일정으로 수정시킨다.
            return new ScheduleResponseDto(schedule);
        } else {
            throw new IllegalArgumentException("존재하지 않는 일정입니다.");
        }
    }
//find id 메서드 , 영속석개체를 만들어서
    @DeleteMapping("/schedule/{id}")
    public ScheduleResponseDto updateSchedule(@PathVariable Long id) {
        if (scheduleList.containsKey(id)) {
            //scheduleList 에 일치하는 id 가있으면
            scheduleList.remove(id);
            //그 id를 삭제해라
            return new ScheduleResponseDto(scheduleList.get(id));
            //그리고 결과를 반환해라.
        }else {
            throw new IllegalArgumentException("존재하지 않는 일정입니다");
        }
    }
}

