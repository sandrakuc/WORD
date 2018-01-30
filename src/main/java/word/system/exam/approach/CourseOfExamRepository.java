package word.system.exam.approach;

import org.springframework.data.repository.CrudRepository;
import word.system.user.User;

public interface CourseOfExamRepository extends CrudRepository<CourseOfExam, Long> {
    CourseOfExam getByUser(User pkk);
}
