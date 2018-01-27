package word.system.pwpw;

import word.system.DrivingLicenseApplication.DrivingLicenseApplication;
import word.system.user.User;

import java.util.Random;


public class PwpwProxy implements Pwpw {
    private DrivingLicense drivingLicense;
    private User pkk;

    public PwpwProxy()
    {
        drivingLicense = new DrivingLicense();
        drivingLicense.simulate();
    }

//Metody wykonywane przez PWPW nie udostepniane na zewnatrz. (PWPW oprocz bycia fasada samo tez wykonuje prace)


    public User getPkk() {
        return pkk;
    }

    public void setPkk(User pkk) {
        this.pkk = pkk;
    }

    //Metody PWPW udostepniane na zewnatrz (PWPW jako fasada)
    @Override
    public boolean verifyApplicationData()
    {
       return drivingLicense.verifyApplicationData();
    }

    @Override
    public void setDrivingLicenseStatus(DrivingLicenseStatus drivingLicenseStatus) {
        drivingLicense.setDrivingLicenseStatus(drivingLicenseStatus);
    }

    @Override
    public DrivingLicenseStatus getDrivingLicenseStatus(User pkk) {
       return drivingLicense.getDrivingLicenseStatus(getPkk());
    }



}
