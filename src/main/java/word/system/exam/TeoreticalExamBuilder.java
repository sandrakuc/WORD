package word.system.exam;

import word.system.exam.approach.TeoreticalApproach;
import word.system.user.User;

import java.util.*;


public class TeoreticalExamBuilder extends ExamBuilder {


    public TeoreticalExamBuilder() {
    }

    public Set<TeoreticalApproach> TeoreticalExamResults;


    public void run() {
        // TODO implement here
        System.out.println("Dzialanie egzaminu teoretycznego, ktore jeszcze nie zostalo zaimplementowane");
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
        User o1 = new User();
        User o2 = new User();

        ArrayList<User> pkkList = new ArrayList<User>();
        pkkList.add(o1);
        pkkList.add(o2);

        abstractExam.setPkkList(pkkList);
    }


    @Override
    public void addMachineToExam() {

    }


}