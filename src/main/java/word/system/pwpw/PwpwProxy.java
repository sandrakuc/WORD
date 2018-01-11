package word.system.pwpw;

import word.system.DrivingLicenseApplication.DrivingLicenseApplication;
import word.system.pkk.Pkk;

import java.util.Random;


public class PwpwProxy implements Pwpw {
    private DrivingLicense drivingLicense;
    private Pkk pkk;

    public PwpwProxy()
    {
        drivingLicense = new DrivingLicense(1);
        drivingLicense.simulate();
    }

//Metody wykonywane przez PWPW nie udostepniane na zewnatrz. (PWPW oprocz bycia fasada samo tez wykonuje prace)


    public Pkk getPkk() {
        return pkk;
    }

    public void setPkk(Pkk pkk) {
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
    public DrivingLicenseStatus getDrivingLicenseStatus(Pkk pkk) {
       return drivingLicense.getDrivingLicenseStatus(getPkk());
    }



}
