package word.system.exam;

import org.springframework.data.repository.CrudRepository;
import word.system.user.User;


public interface TeoreticalExamToPkkRepository extends CrudRepository<TeoreticalExamToPkk, Long> {
    TeoreticalExamToPkkRepository getById(Long id);
    TeoreticalExamToPkkRepository getByUser(User user);
    TeoreticalExamToPkkRepository getByTeoreticalExam(TeoreticalExam teoreticalExam);
}
