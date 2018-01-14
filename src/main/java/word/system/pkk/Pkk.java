package word.system.pkk;

import word.system.DrivingLicenseApplication.DrivingLicenseApplication;
import word.system.DrivingLicenseApplication.ObserverDrivingLicenseApplication;
import word.system.exam.Exam;
import word.system.pwpw.DrivingLicense;
import word.system.pwpw.DrivingLicenseStatus;


import java.util.ArrayList;

public class Pkk implements ObserverDrivingLicenseApplication {
    public int id;
    public String name;
    public String surname;
    public String birthDate;
    public Exam exam;
    public ArrayList<DrivingLicense> driverLicenseCategoriesList;
    public String address;
    private PkkStatus pkkStatus;
    private DrivingLicenseApplication drivingLicenseApplication;
    private DrivingLicenseStatus drivingLicenseStatus;


    public Pkk(int id, String name, String surname, String birthDate, String address) {
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
        System.out.println("Status prawa jazdy w PKK: "+ drivingLicenseStatus);
    }



}
