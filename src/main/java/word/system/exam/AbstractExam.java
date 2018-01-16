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
abstract public class AbstractExam {
    private Date examDate;
    private ArrayList<Pkk> pkkList;

    public void setPkkList (ArrayList<Pkk> pkkList)
    {
        this.pkkList=pkkList;
    }
    public ArrayList<Pkk> getPkkList() {
        return pkkList;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
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
