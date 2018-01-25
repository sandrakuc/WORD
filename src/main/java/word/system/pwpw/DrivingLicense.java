package word.system.pwpw;

import word.system.DrivingLicenseApplication.DrivingLicenseApplication;
import word.system.user.User;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Random;

import static word.system.pwpw.DrivingLicenseStatus.InProcecessOfMaking;

//@TODO
//@Entity
//@Table(name="WORD_DRIVING_LICENSE")
public class DrivingLicense implements Pwpw {
    private long id;
    private User pkk;
    private String address;
    private DrivingLicenseStatus drivingLicenseStatus =  InProcecessOfMaking;

    public DrivingLicense(int id) {
        this.id = id;
    }

    public User getPkk() {
        return pkk;
    }

    public String getAddress() {
        return address;
    }

    public void setPkk(User pkk) {
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
    public DrivingLicenseStatus getDrivingLicenseStatus(User pkk) {
        return drivingLicenseStatus;
    }

    @Override
    public boolean verifyApplicationData() {
        return Boolean.TRUE;
    }


}
