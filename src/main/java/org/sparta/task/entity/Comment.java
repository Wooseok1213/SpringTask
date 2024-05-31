package org.sparta.task.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.sparta.task.dto.CommentRequestDto;


@Entity // JPA가 관리할 수 있는 Entity 클래스 지정
@Getter
@Setter
@Table(name = "comments") // 매핑할 테이블의 이름을 지정
@NoArgsConstructor

public class Comment extends Timestamped {
    @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY) =  Id 값을 자동으로 카운팅해줌
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String comment;
    private String user;
//    DB 컬럼으로 private Long schedule_Id 이 들어오는거임 실제 Entity 가 존재하지는않다.

    public Comment(CommentRequestDto requestDto) {
        this.id = requestDto.getId();
        this.comment = requestDto.getComment();
        this.user = requestDto.getUser();
    }

    @ManyToOne
    @JoinColumn(name = "schedule_Id")
    private Schedule schedule;

    private void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}




