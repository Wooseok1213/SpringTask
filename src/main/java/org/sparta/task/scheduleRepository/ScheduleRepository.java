package org.sparta.task.scheduleRepository;

import org.sparta.task.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

}
