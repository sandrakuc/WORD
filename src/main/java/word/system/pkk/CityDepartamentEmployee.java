package word.system.pkk;

import word.system.DrivingLicenseApplication.DrivingLicenseApplication;
import word.system.common.Address;

import java.util.Date;

public class CityDepartamentEmployee {
    private int id;
    private String name;
    private String surname;
    private Date birthDate;
    private Address address;
    private DrivingLicenseApplication drivingLicenseApplication;


    public CityDepartamentEmployee(int id, String name, String surname, Date birthDate, Address address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.address = address;
    }


}


