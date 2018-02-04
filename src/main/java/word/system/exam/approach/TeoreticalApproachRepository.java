package word.system.exam.approach;

        import org.springframework.data.repository.CrudRepository;
        import word.system.exam.TeoreticalExam;

public interface TeoreticalApproachRepository extends CrudRepository<TeoreticalApproach, Long> {
    TeoreticalApproach getById(Long id);
    TeoreticalApproach getByTeoreticalExam(TeoreticalExam teoreticalExam);
}
