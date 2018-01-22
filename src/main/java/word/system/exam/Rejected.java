package word.system.exam;

import java.util.Date;

public class Rejected implements ExamStatus {
    @Override
    public void runExam(AbstractExam exam) {
        System.out.println(exam + " przeprowadzony dn " + exam.examDate + " zostal odrzucony");
        System.out.println();
    }
}
