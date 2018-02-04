package word.system.exam;

import org.springframework.data.repository.CrudRepository;
import word.system.user.User;


public interface TeoreticalExamToPkkRepository extends CrudRepository<TeoreticalExamToPkk, Long> {
    TeoreticalExamToPkk getById(Long id);
    TeoreticalExamToPkk getByUser(User user);
    TeoreticalExamToPkk getByTeoreticalExam(TeoreticalExam teoreticalExam);
    TeoreticalExamToPkk getByTeoreticalExamAndUser(TeoreticalExam teoreticalExam, User user);
}
