import jakarta.transaction.Transactional;
import jumptospringboot.*;
import jumptospringboot.answer.Answer;
import jumptospringboot.answer.AnswerRepository;
import jumptospringboot.question.Question;
import jumptospringboot.question.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes= JumpToSpringbootApplication.class)
class JumpToSpringbootApplicationTests {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

//    @Test 테스트 데이터베이스에 값을 만들어 넣음
//    void testJpa() {
//        Question q1 = new Question();
//        q1.setSubject("sbb가 무엇인가요?");
//        q1.setContent("sbb에 대해 알고 싶습니다.");
//        q1.setCreateDate(LocalDateTime.now());
//        this.questionRepository.save(q1); // 첫 번째 질문 저장
//
//        Question q2 = new Question();
//        q2.setSubject("스프링부트 모델 질문입니다.");
//        q2.setContent("id는 자동으로 생성되나요?");
//        q2.setCreateDate(LocalDateTime.now());
//        this.questionRepository.save(q2); // 두 번째 질문 저장
//    }

//    @Test findAll 테스트 DB에 있는 값을 조회
//    void testJpa() {
//        // findAll은 데이터를 조회할 때 사용하는 메서드
//        List<Question> all = this.questionRepository.findAll();
//        assertEquals(2, all.size());
//
//        Question q = all.get(0);
//        assertEquals("sbb가 무엇인가요?", q.getSubject());
//    }

//    @Test findById 테스트 DB에 있는 값을 Question 엔티티의 id값으로 조회
//    void testJpa(){
//        id값으로 데이터를 조회하기 위해서는 리포지터리의 findById 메서드를 사용해야 함
//        findById의 리턴 타입은 Question이 아닌 Optional임에 주의할 것
//        Optional<Question> oq = this.questionRepository.findById(1);
//        if(oq.isPresent()) {
//            Question q = oq.get();
//            assertEquals("sbb가 무엇인가요?", q.getSubject());
//        }
//    }

//    @Test // findBySubject QuestionRepository의 내용을 변경하여 아래와 같은 메서드를 사용하였음
//    // 제목으로 테이블 데이터를 조회
//    void testJpa(){
//        Question q = this.questionRepository.findBySubject("sbb가 무엇인가요?");
//        assertEquals(1, q.getId());
//    }

//    @Test // findBySubjectAndContent QuestionRepository의 내용을 변경하여 아래와 같은 메서드를 사용하였음
//    // 제목 및 내용으로 테이블 데이터를 조회
//    void testJpa() {
//        Question q = this.questionRepository.findBySubjectAndContent("sbb가 무엇인가요?", "sbb에 대해 알고 싶습니다.");
//        assertEquals(1, q.getId());
//    }

//    @Test // findBySubjectLike QuestionRepository의 내용을 변경하여 아래와 같은 메서드를 사용하였음
//    // 제목에 특정 문자열이 포함되어 있는 데이터를 조회
//    void testJpa(){
//        List<Question> qList = this.questionRepository.findBySubjectLike("sbb%");
//        Question q = qList.get(0);
//        assertEquals("sbb가 무엇인가요?", q.getSubject());
//    }

//    @Test // 질문 데이터를 수정하는 테스트 코드
//    // 질문 데이터를 조회한 다음 subject를 "수정된 제목"이라는 값으로 수정하고 저장
//    void testJpa(){
//        Optional<Question> oq = this.questionRepository.findById(1);
//        assertTrue(oq.isPresent());
//        Question q = oq.get();
//        q.setSubject("수정된 제목");
//        this.questionRepository.save(q);
//    }

//    @Test // 데이터를 삭제하는 테스트 코드
//    void testJpa(){
//        // 리포지터리의 count() 메서드는 해당 리포지터리의 총 데이터 건수를 리턴. 즉 아랫줄은 데이터 갯수가 2개가 맞는건지 확인하는 용도        assertEquals(2, this.questionRepository.count());
//        Optional<Question> oq = this.questionRepository.findById(1);
//        assertTrue(oq.isPresent());
//        Question q = oq.get();
//        this.questionRepository.delete(q);
//        assertEquals(1, this.questionRepository.count());
//    }

//    @Test
//    void testJpa(){
//        Optional<Question> oq = this.questionRepository.findById(2);
//        assertTrue(oq.isPresent());
//        Question q = oq.get();
//
//        Answer a = new Answer();
//        a.setContent("네 자동으로 생성됩니다.");
//        a.setQuestion(q); // 어떤 질문의 답변인지 알기 위해서 Question의 객체가 필요
//        a.setCreateDate(LocalDateTime.now());
//        this.answerRepository.save(a);
//    }

//    @Test
//    void testJpa() { // 데이터의 삭제
//        assertEquals(2, this.questionRepository.count());
//        Optional<Question> oq = this.questionRepository.findById(1);
//        assertTrue(oq.isPresent());
//        Question q = oq.get();
//        this.questionRepository.delete(q);
//        assertEquals(1, this.questionRepository.count());
//    }

//    @Test
//    void testJpa() { // 답변(Answer) 데이터를 생성하고 저장
//        Optional<Question> oq = this.questionRepository.findById(2);
//        assertTrue(oq.isPresent());
//        Question q = oq.get();
//
//        Answer a = new Answer();
//        a.setContent("네 자동으로 생성됩니다.");
//        a.setQuestion(q); // 어떤 질문의 답변인지 알기 위해서 Question 객체가 필요하다
//        a.setCreateDate(LocalDateTime.now());
//        this.answerRepository.save(a);
//    }

//    @Test
//    void testJpa() { // Answer 엔티티의 question 속성을 이용하여 답변 조회하기. 즉, 답변에 연결된 질문 찾기
//        // id 값이 1인 답변을 조회하고, 해당 답변의 질문 id가 2인지 확인
//        Optional<Answer> oa = this.answerRepository.findById(1);
//        assertTrue(oa.isPresent());
//        Answer a = oa.get();
//        assertEquals(2, a.getQuestion().getId());
//    }

    @Transactional
    @Test
    // 테스트모드에서 실행하면 오류가 발생하는데, 이유는 다음과 같다
    // Question 리포지터리에서 findById를 호출하여 Question 객체를 조회하고 나면 DB 세션이 끊어지기 때문
    // 때문에 그 이후 실행되는 q.getAnswerList() 메서드는 세션이 종료되어 오류가 발생
    // 이 문제는 테스트 코드에서만 발생하며, 실제 서버에서는 DB 세션이 종료되지 않기 때문에 문제 없이 코드가 처리된다.
    // 테스트에서 상기한 문제는 @Transactional 어노테이션을 추가하는 것으로 해결이 가능
    void testJpa() { // 질문에서 답변 찾기
        // id가 2인 질문을 취득
        Optional<Question> oq = this.questionRepository.findById(2);
        assertTrue(oq.isPresent());
        Question q = oq.get();

        List<Answer> answerList = q.getAnswerList();

        assertEquals(1, answerList.size());
        assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());
    }
}
