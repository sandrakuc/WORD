package word.system.pwpw;

import word.system.DrivingLicenseApplication.DrivingLicenseApplication;
import word.system.pkk.Pkk;

import java.util.Random;

import static word.system.pwpw.DrivingLicenseStatus.InProcecessOfMaking;

public class DrivingLicense implements Pwpw {
    private int id;
    private Pkk pkk;
    private String address;
    private DrivingLicenseStatus drivingLicenseStatus =  InProcecessOfMaking;

    public DrivingLicense(int id) {
        this.id = id;
    }

    public Pkk getPkk() {
        return pkk;
    }

    public String getAddress() {
        return address;
    }

    public void setPkk(Pkk pkk) {
        this.pkk = pkk;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void simulate() {
            //ustawienie rand statusu wniosku
            drivingLicenseStatus  = DrivingLicenseStatus.ReadyToGetFromPWPW;
    }

    @Override
    public void setDrivingLicenseStatus(DrivingLicenseStatus drivingLicenseStatus) {
        this.drivingLicenseStatus = drivingLicenseStatus;
    }

    @Override
    public DrivingLicenseStatus getDrivingLicenseStatus(Pkk pkk) {
        return drivingLicenseStatus;
    }

    @Override
    public boolean verifyApplicationData() {
        return Boolean.TRUE;
    }


}
