package word.system.exam.approach;

import org.springframework.data.repository.CrudRepository;

public interface PracticApproachRepository extends CrudRepository<PracticApproach, Long> {
    PracticApproach getById(Long id);
}