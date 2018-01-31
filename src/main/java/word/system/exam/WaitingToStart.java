package word.system.exam;

public class WaitingToStart implements PracticalExamStatus {
    @Override
    public void runExam(AbstractExam exam){
        System.out.println(exam + " czeka na rozpoczecie dn " + exam.examDate);
        System.out.println("Dostep zablokowany");
        System.out.println();
    }
}
