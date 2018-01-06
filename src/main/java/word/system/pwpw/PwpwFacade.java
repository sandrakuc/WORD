package word.system.pwpw;

import word.system.common.DrivingLicense;
import word.system.common.DrivingLicenseStatus;
import word.system.pkk.Pkk;


public class PwpwFacade {
    private DrivingLicense drivingLicense;
    private Pkk pkk;

    public PwpwFacade()
    {
        drivingLicense = new DrivingLicense();
    }

    public Pkk getPkk() {
        return pkk;
    }

    public void setPkk(Pkk pkk) {
        this.pkk = pkk;
    }

    protected void setStatus(DrivingLicenseStatus drivingLicenseStatus)
    {
        drivingLicense.setStatus(drivingLicenseStatus);
    }

    public void checkStatus(){
        drivingLicense.checkStatus();
    }



}
