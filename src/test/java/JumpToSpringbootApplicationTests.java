import jumptospringboot.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes= JumpToSpringbootApplication.class)
class JumpToSpringbootApplicationTests {
    @Autowired
    private QuestionRepository questionRepository;

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

    // 답변 데이터 생성 후 저장하기
    @Autowired
    // 답변 데이터 처리를 위해서는 답변 리포지터리가 필요하므로 AnswerRepository 객체를 주입
    private AnswerRepository answerRepository;

    @Test
    void testJpa(){
        Optional<Question> oq = this.questionRepository.findById(2);
        assertTrue(oq.isPresent());
        Question q = oq.get();

        Answer a = new Answer();
        a.setContent("네 자동으로 생성됩니다.");
        a.setQuestion(q); // 어떤 질문의 답변인지 알기 위해서 Question의 객체가 필요
        a.setCreateDate(LocalDateTime.now());
        this.answerRepository.save(a);
    }
}
