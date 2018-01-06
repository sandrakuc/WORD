package word.system.pkk;

import word.system.DrivingLicenseApplication.DrivingLicenseApplication;
import word.system.exam.Exam;
import word.system.pwpw.DrivingLicense;


import java.util.ArrayList;

public class Pkk {
    public int id;
    public String name;
    public String surname;
    public String birthDate;
    public Exam exam;
    public ArrayList<DrivingLicense> driverLicenseCategoriesList;
    public String address;
    private PkkStatus pkkStatus;


    public DrivingLicenseApplication getDrivingLicenseApplication() {
        return drivingLicenseApplication;
    }

    private DrivingLicenseApplication drivingLicenseApplication;

    public Pkk(int id, String name, String surname, String birthDate, String address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.address = address;
    }

}
