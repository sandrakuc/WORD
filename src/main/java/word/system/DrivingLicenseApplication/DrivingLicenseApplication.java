package word.system.DrivingLicenseApplication;

import word.system.pkk.Pkk;
import word.system.pwpw.PwpwFascade;

public class DrivingLicenseApplication {
    private int id;
    private ApplicationStatus applicationStatus;
    private Pkk pkk;

    public DrivingLicenseApplication(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pkk getPkk() {
        return pkk;
    }

    public ApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public static void main(String[] args) {
        DrivingLicenseApplication dlc = new DrivingLicenseApplication(1);
        PwpwFascade pwpwFascade = new PwpwFascade();


       System.out.println("Status prawa jazdy: "+ pwpwFascade.getDrivingLicenseStatus());

       pwpwFascade.checkAvaliable(dlc.getPkk());
    }
}
