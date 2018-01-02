package word.system.exam;


import java.util.*;

/* Abstract Builder */
public abstract class ExamBuilder {

    protected Exam exam;

    public Exam getExam() {
        return exam;
    }

    public void createNewExam()
    {
        exam = new Exam();
    }

    public abstract void addPkkToExam();
    public abstract void addExaminerToExam();
    public abstract void addMachineToExam();

}