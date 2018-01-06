package word.system.DriverLicenseApplication;

import word.system.common.DrivingLicense;
import word.system.pwpw.PwpwFacade;

public class DrivingLicenseApplication {
    private int id;
    private ApplicationStatus applicationStatus;
    private PwpwFacade pwpwFacade;

    public DrivingLicenseApplication(int id, ApplicationStatus applicationStatus, PwpwFacade pwpwFacade) {
        this.id = id;
        this.applicationStatus = applicationStatus;
        this.pwpwFacade = pwpwFacade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

}
