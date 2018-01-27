package word.system.exam.approach;

        import org.springframework.data.repository.CrudRepository;

public interface TeoreticalApproachRepository extends CrudRepository<TeoreticalApproach, Long> {
    TeoreticalApproach getById(Long id);
}
