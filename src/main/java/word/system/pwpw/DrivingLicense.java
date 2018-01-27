package word.system.pwpw;

import word.system.DrivingLicenseApplication.DrivingLicenseApplication;
import word.system.user.User;

import javax.persistence.*;
import java.util.Random;

import static word.system.pwpw.DrivingLicenseStatus.InProcecessOfMaking;


@Entity
@Table(name="WORD_DRIVING_LICENSE")
public class DrivingLicense implements Pwpw {
    @Id @GeneratedValue
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
    //@SequenceGenerator(sequenceName = "word_driving_license_seq", allocationSize = 1, name = "CUST_SEQ")
    Long id;

    private String address;
    private DrivingLicenseStatus drivingLicenseStatus =  InProcecessOfMaking;


    public String getAddress() {
        return address;
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
