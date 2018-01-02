package word.system.exam.examiners;

import word.system.common.Address;
import word.system.exam.Exam;
import word.system.pkk.Pkk;

import java.util.ArrayList;
import java.util.Date;

public class PracticalExaminer {

    public int id;
    public String name;
    public String surname;
    public String birthDate;
    public String address;

    public PracticalExaminer(int id, String name, String surname, String birthDate, String address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.address = address;
    }


    void getExamsToday()
    {

    }

    void blockPkk (Pkk pkk)
    {
       pkk.blockPkk();
    }

}
