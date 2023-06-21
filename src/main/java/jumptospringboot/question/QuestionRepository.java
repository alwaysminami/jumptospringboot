package jumptospringboot.question;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    // Question 엔티티의 PK(Primary Key) 속성의 id 타입이 Integer이기에 JpaRepository의 제네릭스 타입으로 Question, Integer을 작성

    // test에서 findBySubject를 사용하기 위해 이 파일에 아래와 같은 내용 추가
    Question findBySubject(String subject);

    // test에서 findBySubjectAndContent를 사용하기 위해 이 파일에 아래와 같은 내용 추가
    Question findBySubjectAndContent(String subject, String content);

    // test에서 findBySubjectLike를 사용하기 위해 이 파일에 아래와 같은 내용 추가
    List<Question> findBySubjectLike(String subject);
}
