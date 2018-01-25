package word.system.pwpw;

import word.system.user.User;

public interface Pwpw {
    void setDrivingLicenseStatus(DrivingLicenseStatus drivingLicenseStatus);
    DrivingLicenseStatus getDrivingLicenseStatus(User pkk);
    boolean verifyApplicationData();
}
