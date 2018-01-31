package word.system.exam;

public class Accepted implements PracticalExamStatus {

    @Override
    public void runExam(AbstractExam exam) {
        System.out.println(exam + " przeprowadzony dn " + exam.examDate + " zostal zaakceptowany");
        System.out.println();
    }
}
