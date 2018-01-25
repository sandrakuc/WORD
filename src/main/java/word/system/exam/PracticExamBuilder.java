package word.system.exam;

import word.system.user.User;

import java.util.ArrayList;

public class PracticExamBuilder extends ExamBuilder {

    @Override
    public void addPkkToExam() {
        // tu jedno pkk
        User o1 = new User();

        ArrayList<User> pkkList = new ArrayList<User>();
        pkkList.add(o1);

        abstractExam.setPkkList(pkkList);
    }



    @Override
    public void addMachineToExam() {


        //abstractExam.setMachine(admin.getMachine()); //TOMEK - abstract exam nie może mieć instancji

    }

}