package word.system.pkk;

import word.system.DrivingLicenseApplication.DrivingLicenseApplication;
import word.system.DrivingLicenseApplication.ObserverDrivingLicenseApplication;
import word.system.common.Address;
import word.system.pwpw.DrivingLicenseStatus;

import java.util.Date;

public class CityDepartamentEmployee implements ObserverDrivingLicenseApplication {
    private int id;
    private String name;
    private String surname;
    private String birthDate;
    private String address;
    private DrivingLicenseApplication drivingLicenseApplication;
    private DrivingLicenseStatus drivingLicenseStatus;


    public CityDepartamentEmployee(int id, String name, String surname, String birthDate, String address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.address = address;
    }


    @Override
    public void update(DrivingLicenseStatus drivingLicenseStatus) {
        System.out.println("Aktualizacja obiektu");
        this.drivingLicenseStatus = drivingLicenseStatus;
        printDrivingLicenseStatus();
    }

    @Override
    public void printDrivingLicenseStatus()
    {
        System.out.println("Status prawa jazdy u urzednika: "+ drivingLicenseStatus);
    }
}


