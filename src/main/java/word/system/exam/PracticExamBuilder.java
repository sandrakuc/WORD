package word.system.exam;

import word.system.exam.examiners.PracticalExaminer;
import word.system.pkk.Pkk;
import word.system.user.Admin;

import java.util.ArrayList;

public class PracticExamBuilder extends ExamBuilder {

    @Override
    public void addPkkToExam() {
        // tu jedno pkk
        Pkk o1 = new Pkk(1,"Adam","Nowak", "01.02.1990", "Klonowa 21");

        ArrayList<Pkk> pkkList = new ArrayList<Pkk>();
        pkkList.add(o1);

        abstractExam.setPkkList(pkkList);
    }

    @Override
    public void addExaminerToExam() {
        PracticalExaminer pEx1 = new PracticalExaminer(1,"Mateusz","Androlewski","21.12.1970", "Radomska 21");

        //abstractExam.setPracticalExaminer(pEx1); //TOMEK - abstract exam nie może mieć instancji

    }

    @Override
    public void addMachineToExam() {
        Admin admin = new Admin();
        admin.createMachine();

        //abstractExam.setMachine(admin.getMachine()); //TOMEK - abstract exam nie może mieć instancji

    }

}