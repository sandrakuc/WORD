package word.system.pkk;

import word.system.common.Address;
import word.system.common.DrivingLicense;
import word.system.exam.Exam;

import java.util.ArrayList;
import java.util.Date;

public class Pkk {
    public int id;
    public String name;
    public String surname;
    public String birthDate;
    public Exam exam;
    public ArrayList<DrivingLicense> driverLicenseCategoriesList;
    public String address;
    private boolean isBlocked;

    public Pkk(int id, String name, String surname, String birthDay, String address)
    {
        this.id=id;
        this.name=name;
        this.surname=surname;
        this.birthDate=birthDay;
        this.address=address;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }



    public void blockPkk(){
        setBlocked(Boolean.TRUE);
    }

    public void unlockPkk()
    {
        setBlocked(Boolean.FALSE);
    }


}
