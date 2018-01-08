package word.system.pwpw;

import word.system.DrivingLicenseApplication.DrivingLicenseApplication;
import word.system.pkk.Pkk;

import java.util.Random;


public class PwpwFascade {
    private DrivingLicense drivingLicense;
    private Pkk pkk;

    public PwpwFascade()
    {
        drivingLicense = new DrivingLicense(1);
        simulate(drivingLicense);
    }

//Metody wykonywane przez PWPW nie udostepniane na zewnatrz. (PWPW oprocz bycia fasada samo tez wykonuje prace)


    public Pkk getPkk() {
        return pkk;
    }

    public void setPkk(Pkk pkk) {
        this.pkk = pkk;
    }

    //metoda symulujaca dzialanie PWPW
    private void simulate(DrivingLicense drivingLicense)
    {
        //ustawienie rand statusu wniosku
        DrivingLicenseStatus dls = DrivingLicenseStatus.getRandomDrivingLicenceStatus();
        setStatus(dls);
    }

    protected void setStatus(DrivingLicenseStatus drivingLicenseStatus)
    {
        drivingLicense.setDrivingLicenseStatus(drivingLicenseStatus);
    }


    //Metody PWPW udostepniane na zewnatrz (PWPW jako fasada)
    public DrivingLicense getDrivingLicense() {
        return drivingLicense;
    }

    public DrivingLicenseStatus checkAvaliable(Pkk pkk)
    {
        return getDrivingLicense().getDrivingLicenseStatus();
    }

    public boolean verifyApplicationData(Pkk pkk)
    {
        return Boolean.TRUE;
    }
}
