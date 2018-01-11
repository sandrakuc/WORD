package word.system.pwpw;

import word.system.pkk.Pkk;

public interface Pwpw {
    void setDrivingLicenseStatus(DrivingLicenseStatus drivingLicenseStatus);
    DrivingLicenseStatus getDrivingLicenseStatus(Pkk pkk);
    boolean verifyApplicationData();
}
