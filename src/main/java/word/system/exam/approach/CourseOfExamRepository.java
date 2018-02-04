package word.system.exam.approach;

import org.springframework.data.repository.CrudRepository;
import word.system.exam.TeoreticalQuestions.AnswerBase;
import word.system.user.User;

public interface CourseOfExamRepository extends CrudRepository<CourseOfExam, Long> {
    //CourseOfExam getByUserAndAnswer(User pkk, AnswerBase answer);
}
