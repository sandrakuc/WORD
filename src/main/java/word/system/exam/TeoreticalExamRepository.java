package word.system.exam;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Date;

public interface TeoreticalExamRepository extends CrudRepository<TeoreticalExam, Long> {
    ArrayList<TeoreticalExam> getByDate(Date date);
    TeoreticalExam  getById(Long id);


}
