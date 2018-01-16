package word.system.exam.examiners;

import word.system.exam.AbstractExam;
import word.system.pkk.Pkk;

public class TeoreticalExaminer {

    public int id;
    public String name;
    public String surname;
    public String birthDate;
    public String address;

    public TeoreticalExaminer(int id, String name, String surname, String birthDate, String address) {
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

    }

    void runExam(AbstractExam abstractExam)
    {

    }
}
