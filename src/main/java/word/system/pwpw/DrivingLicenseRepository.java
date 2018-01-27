package word.system.pwpw;

import org.springframework.data.repository.CrudRepository;
import word.system.user.User;

public interface DrivingLicenseRepository extends CrudRepository<DrivingLicense, Long> {
    //DrivingLicense getByPkk(User pkk);
}
