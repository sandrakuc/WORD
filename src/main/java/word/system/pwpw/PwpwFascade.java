package word.system.pwpw;

import word.system.DrivingLicenseApplication.DrivingLicenseApplication;
import word.system.pkk.Pkk;

import java.util.Random;


public class PwpwFascade {
    private DrivingLicense drivingLicense;
    private Pkk pkk;

    public PwpwFascade()
    {
        drivingLicense = new DrivingLicense();
        simulate(drivingLicense);
    }

//Metody wykonywane przez PWPW nie udostepniane na zewnatrz. (PWPW oprocz bycia fasada samo tez wykonuje prace)
    //metoda symulujaca dzialanie PWPW
    private void simulate(DrivingLicense drivingLicense)
    {
        //ustawienie rand statusu wniosku
        DrivingLicenseStatus dls = DrivingLicenseStatus.getRandomDrivingLicenceStatus();
        setStatus(dls);
    }


    protected void markAsReceived(DrivingLicense drivingLicense)
    {

        drivingLicense.setDrivingLicenseStatus(DrivingLicenseStatus.Received);
    }

    protected void setStatus(DrivingLicenseStatus drivingLicenseStatus)
    {
        drivingLicense.setDrivingLicenseStatus(drivingLicenseStatus);
    }


    //Metody PWPW udostepniane na zewnatrz (PWPW jako fasada)
    public DrivingLicenseStatus getDrivingLicenseStatus(){
        return drivingLicense.getDrivingLicenseStatus();
    }

    public DrivingLicense getDrivingLicense() {
        return drivingLicense;
    }

    public void checkAvaliable(Pkk pkk)
    {
        if(drivingLicense.getDrivingLicenseStatus()==DrivingLicenseStatus.ReadyToGetFromPWPW)
           System.out.println("Prawo jazdy dostepne do odbioru");
        else
            System.out.println("Prawo jazdy niedostepne do odbioru");
    }


    //inne
    public Pkk getPkk() {
        return pkk;
    }

    public void setPkk(Pkk pkk) {
        this.pkk = pkk;
    }

}
