package word.system.exam;

import java.util.Date;

public class Finished implements ExamStatus {
    @Override
    public void runExam(AbstractExam exam) {
        System.out.println(exam + " zakończono dn " + exam.examDate);
        System.out.println("Dostep zablokowany");
        System.out.println();
    }
}
