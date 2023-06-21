package jumptospringboot.answer;

import jakarta.persistence.*;
import jumptospringboot.question.Question;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    @ManyToOne // Answer(답변)이 Many, Question(질문)이 One
    // @ManyToOne은 부모자식 관계를 갖는 구조에서 사용하며, 여기서 부모는 Question, 자식은 Answer이 된다
    private Question question;
}
