package word.system.DrivingLicenseApplication;

import word.system.pwpw.DrivingLicenseStatus;

public interface ObserverDrivingLicenseApplication {
    //method to update the observer, used by subject
    public void update(DrivingLicenseStatus drivingLicenseStatus);
    public void printDrivingLicenseStatus();
}
