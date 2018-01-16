package word.system.exam;


/* Abstract Builder */
public abstract class ExamBuilder {

    protected AbstractExam abstractExam;

    public AbstractExam getAbstractExam() {
        return abstractExam;
    }

    public void createNewExam()
    {
        //abstractExam = new AbstractExam(); //tomek - zakomentowałem bo błąd, AbstractExam musi być klasą abstrackyjną
    }

    public abstract void addPkkToExam();
    public abstract void addExaminerToExam();
    public abstract void addMachineToExam();

}