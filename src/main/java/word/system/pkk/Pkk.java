package word.system.pkk;

import word.system.common.Address;
import word.system.common.DrivingLicense;
import word.system.exam.Exam;

import java.util.ArrayList;
import java.util.Date;

public class Pkk {
    private int id;
    private String name;
    private String surname;
    private Date birthDate;
    private Exam exam;
    private ArrayList<DrivingLicense> driverLicenseCategoriesList;
    private Address address;

    Pkk(int id, String name, String surname, Date birthDay, Address address )
    {
        this.id=id;
        this.name=name;
        this.surname=surname;
        this.birthDate=birthDay;
        this.address=address;
    }

    void blockPkk(){

    }

    void unlockPkk()
    {

    }
}
