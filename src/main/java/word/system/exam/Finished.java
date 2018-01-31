package word.system.exam;

public class Finished implements PracticalExamStatus {
    @Override
    public void runExam(AbstractExam exam) {
        System.out.println(exam + " zakończono dn " + exam.examDate);
        System.out.println("Dostep zablokowany");
        System.out.println();
    }
}
