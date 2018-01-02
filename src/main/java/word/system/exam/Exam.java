package word.system.exam;

import word.system.carfactory.Car;
import word.system.carfactory.Machine;
import word.system.exam.examiners.PracticalExaminer;
import word.system.exam.examiners.TeoreticalExaminer;
import word.system.pkk.Pkk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/* Product */
public class Exam {
    private Date examDate;
    private PracticalExaminer practicalExaminer;
    private TeoreticalExaminer teoreticalExaminer;
    private ArrayList<Pkk> pkkList;
    private Machine machine;

    public void setDate(Date examDate) {
        this.examDate=examDate;
    }

    public void setPracticalExaminer (PracticalExaminer practicalExaminer)
    {
        this.practicalExaminer=practicalExaminer;
    }

    public void setTeoreticalExaminer (TeoreticalExaminer teoreticalExaminer)
    {
        this.teoreticalExaminer=teoreticalExaminer;
    }

    public void setPkkList (ArrayList<Pkk> pkkList)
    {
        this.pkkList=pkkList;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }


    public ArrayList<Pkk> getPkkList() {
        return pkkList;
    }



    public void print_status()
    {
        System.out.printf("Egzamin utworzony.\n ");
        System.out.printf("Lista pkk.\n");
        for (int i = 0; i < getPkkList().size(); i++) {
            System.out.println(getPkkList().get(i));
        }
    }
}
