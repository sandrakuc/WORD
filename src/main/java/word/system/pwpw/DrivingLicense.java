package word.system.pwpw;

import word.system.DrivingLicenseApplication.DrivingLicenseApplication;
import word.system.pkk.Pkk;

import java.util.Random;

import static word.system.pwpw.DrivingLicenseStatus.InProcecessOfMaking;

public class DrivingLicense {
    private Pkk pkk;
    private String address;
    private String issuingOffice;
    private DrivingLicenseStatus drivingLicenseStatus =  InProcecessOfMaking;

    public DrivingLicense() {
    }

    public Pkk getPkk() {
        return pkk;
    }

    public String getAddress() {
        return address;
    }

    public String getIssuingOffice() {
        return issuingOffice;
    }




    public DrivingLicenseStatus getDrivingLicenseStatus() {
        return drivingLicenseStatus;
    }

    public void setDrivingLicenseStatus(DrivingLicenseStatus drivingLicenseStatus) {
        this.drivingLicenseStatus = drivingLicenseStatus;
    }

}
