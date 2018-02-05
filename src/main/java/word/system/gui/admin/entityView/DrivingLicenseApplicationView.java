package word.system.gui.admin.entityView;

import com.vaadin.navigator.Navigator;
import word.system.Application;
import word.system.DrivingLicenseApplication.DrivingLicenseApplication;
import word.system.DrivingLicenseApplication.DrivingLicenseApplicationRepository;

public class DrivingLicenseApplicationView extends EntityView<DrivingLicenseApplication, DrivingLicenseApplicationRepository> {

    public DrivingLicenseApplicationView(Navigator navigator, DrivingLicenseApplicationRepository repository, Class<DrivingLicenseApplication> drivingLicenseApplicationClass) {
        super(navigator, repository, drivingLicenseApplicationClass);
    }
}
