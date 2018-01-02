package word.system.exam;

import word.system.carfactory.Car;
import word.system.carfactory.Machine;
import word.system.exam.examiners.PracticalExaminer;
import word.system.pkk.Pkk;
import word.system.user.Admin;

import java.util.ArrayList;

public class PracticExamBuilder extends AbstractBuilderExam {

    @Override
    public void addPkkToExam() {
        // poki co na sztywno kilka pkk
        Pkk o1 = new Pkk(1,"Adam","Nowak", "01.02.1990", "Klonowa 21");
        Pkk o2 = new Pkk(2,"Marek", "Kowalski", "21.02.1980","Klonowa 16");

        ArrayList<Pkk> pkkList = new ArrayList<Pkk>();
        pkkList.add(o1);
        pkkList.add(o2);

        exam.setPkkList(pkkList);
    }

    @Override
    public void addExaminerToExam() {
        PracticalExaminer pEx1 = new PracticalExaminer(1,"Mateusz","Androlewski","21.12.1970", "Radomska 21");

        exam.setPracticalExaminer(pEx1);

    }

    @Override
    public void addMachineToExam() {
        Admin admin = new Admin();
        admin.createMachine();

        exam.setMachine(admin.getMachine());
    }
}