package word.system.exam;

public class ExamCaretaker {
    private AbstractExam abEx;
    private AbstractExam.Memento memento;

    public ExamCaretaker(AbstractExam abEx){
        this.abEx = abEx;
    }

    public void saveExamState(){
        memento = abEx.createMemento();
    }

    public void restoreState(){
        abEx.restoreState(memento);
    }
}
