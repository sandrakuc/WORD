package word.system.exam;

import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface PracticExamRepository extends CrudRepository<PracticExam, Long> {
    PracticExam getByDate(Date date);
    PracticExam getById(Long id);
}
