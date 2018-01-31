package word.system.exam;

public class Rejected implements PracticalExamStatus {
    @Override
    public void runExam(AbstractExam exam) {
        System.out.println(exam + " przeprowadzony dn " + exam.examDate + " zostal odrzucony");
        System.out.println();
    }
}
