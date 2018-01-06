package word.system.pwpw;

import word.system.pkk.Pkk;


public class PwpwFacade {
    private DrivingLicense drivingLicense;
    private Pkk pkk;

    public PwpwFacade()
    {
        drivingLicense = new DrivingLicense();
        simulate(drivingLicense);
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
        drivingLicense.setStatus(drivingLicenseStatus);
    }

    public void checkStatus(){
        drivingLicense.checkStatus();
    }

    public Pkk getPkk() {
        return pkk;
    }

    public void setPkk(Pkk pkk) {
        this.pkk = pkk;
    }

}
