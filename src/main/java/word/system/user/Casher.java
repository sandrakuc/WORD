package word.system.user;

import word.system.exam.AbstractExam;
import word.system.exam.ExamBuilder;
import word.system.exam.PracticExamBuilder;
import word.system.exam.TeoreticalExamBuilder;

/* Director in Builder Pattern */
public class Casher {
    public int id;
    public String name;
    public String surname;
    public String birthDate;
    public String address;

    public Casher(int id, String name, String surname, String birthDate, String address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.address = address;
    }

    private ExamBuilder examBuilder;

    public void setExamBuilder( ExamBuilder abe)
    {
        examBuilder = abe;
    }

    public AbstractExam getExam()
    {
        return examBuilder.getAbstractExam();
    }

    public void constructExam()
    {
        examBuilder.createNewExam();
        examBuilder.addPkkToExam();
        examBuilder.addExaminerToExam();
        examBuilder.addMachineToExam();
    }

    public static void main(String[] args)
    {
        Casher casher1 = new Casher(1,"Danuta","Nowakowska","21.12.1953","Kielecka 21");
        ExamBuilder practical = new PracticExamBuilder();
        ExamBuilder teoretical =  new TeoreticalExamBuilder();

        //stworzenie teoretycznego
        casher1.setExamBuilder(teoretical);
        casher1.constructExam();
        AbstractExam abstractExam_teor = casher1.getExam();
        abstractExam_teor.print_status();

        //stworzenie praktycznego
        System.out.printf("\n\n Tworzenie egzaminu praktycznego. Na tym etapie prac nad projektem trzeba stworzyc pojazd recznie \n");
        casher1.setExamBuilder(practical);
        casher1.constructExam();
        AbstractExam abstractExam_pract = casher1.getExam();
        abstractExam_pract.print_status();


    }

};



