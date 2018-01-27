package word.system.carfactory;

import org.springframework.data.repository.CrudRepository;

public interface MachineRepository extends CrudRepository<Machine,Long> {
    Machine getByPlate(String plate);
}
