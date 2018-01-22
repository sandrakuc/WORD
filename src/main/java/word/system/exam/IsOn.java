package word.system.exam;

import java.util.Date;

public class IsOn implements ExamStatus {
    @Override
    public void runExam(AbstractExam exam) {
        System.out.println(exam + " dn " + exam.examDate);
        exam.run();
        System.out.println();
    }
}
