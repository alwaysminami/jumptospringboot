package jumptospringboot;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity // 엔티티로 만들기 위함
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // strategy 옵션을 생략할 경우에 @GeneratedValue 어노테이션이 지정된 칼럼들이 모두 동일한 시퀀스로 번호를 생성,
    // 때문에 일정한 순서의 고유번호를 가질 수 없게 되므로, 보통 GenerationType.IDENTITY를 많이 사용
    private Integer id;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    // columnDefinition은 컬럼의 속성을 정의할 때 사용
    // columnDefinition = "TEXT" 는 "내용" 처럼 글자 수를 제한할 수 없는 경우에 사용
    private String content;

    // 엔티티는 @Column를 명시적으로 표현하지 않아도 컬럼으로 취급함. 때문에 아래의 createDate도 컬럼으로 취급됨
    // 컬럼으로 취급하고 싶지 않다면, @Transient 어노테이션을 사용하면 테이블 컬럼으로 인식하지 않음
    // 또한, createDate와 같이 대문자가 들어간 경우, create_date가 실제 컬럼의 컬럼명으로 작성됨
    private LocalDateTime createDate;

    // Answer이 Many이기에 Question을 One으로 설정하였고,
    // Qusetion 하나에 Answer이 여러개이므로 Question 엔티티에 추가할 답변의 속성은 List 형태로 구성해야 한다
    // cascade = CascadeType.REMOVE는, 질문이 삭제되면 답변도 다 삭제되도록 하는 것
    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;
}
