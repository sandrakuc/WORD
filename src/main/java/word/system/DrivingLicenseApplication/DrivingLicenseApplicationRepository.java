package word.system.DrivingLicenseApplication;

import org.springframework.data.repository.CrudRepository;

public interface DrivingLicenseApplicationRepository extends CrudRepository<DrivingLicenseApplication, Long> {
    DrivingLicenseApplication getById(Long id);
    DrivingLicenseApplication getByPesel(String pesel);
}
