package word.system.exam;

import java.util.Date;

public class WaitingToStart implements ExamStatus{
    @Override
    public void runExam(AbstractExam exam){
        System.out.println(exam + " czeka na rozpoczecie dn " + exam.examDate);
        System.out.println("Dostep zablokowany");
        System.out.println();
    }
}
