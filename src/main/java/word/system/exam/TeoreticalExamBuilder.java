package word.system.exam;

import word.system.exam.approach.TeoreticalApproach;
import word.system.exam.examiners.TeoreticalExaminer;
import word.system.pkk.Pkk;

import java.util.*;


public class TeoreticalExamBuilder extends ExamBuilder {


    public TeoreticalExamBuilder() {
    }

    public Set<TeoreticalApproach> TeoreticalExamResults;


    public void run() {
        // TODO implement here
    }

    /**
     * 
     */
    protected void openExam() {
        // TODO implement here
    }

    /**
     * 
     */
    public void closeExam() {
        // TODO implement here
    }

    @Override
    public void addPkkToExam() {
        //tu wiele pkk
        Pkk o1 = new Pkk(1,"Adam","Nowak", "01.02.1990", "Klonowa 21");
        Pkk o2 = new Pkk(2,"Marek", "Kowalski", "21.02.1980","Klonowa 16");

        ArrayList<Pkk> pkkList = new ArrayList<Pkk>();
        pkkList.add(o1);
        pkkList.add(o2);

        exam.setPkkList(pkkList);
    }

    @Override
    public void addExaminerToExam() {
        TeoreticalExaminer tEx1 = new TeoreticalExaminer(1,"Mateusz","Androlewski","21.12.1970", "Radomska 21");

        exam.setTeoreticalExaminer(tEx1);
    }

    @Override
    public void addMachineToExam() {

    }


}