package word.system.pkk;

import word.system.DriverLicenseApplication.DrivingLicenseApplication;
import word.system.exam.Exam;


import java.util.ArrayList;

public class Pkk {
    public int id;
    public String name;
    public String surname;
    public String birthDate;
    public Exam exam;
    public ArrayList<word.system.common.DrivingLicense> driverLicenseCategoriesList;
    public String address;
    private PkkStatus pkkStatus;
    private DrivingLicenseApplication drivingLicenseApplication;

    public Pkk(int id, String name, String surname, String birthDate, String address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.address = address;
    }
}
