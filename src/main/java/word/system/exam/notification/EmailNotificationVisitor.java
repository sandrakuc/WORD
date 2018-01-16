package word.system.exam.notification;

import word.system.exam.PracticExam;
import word.system.exam.TeoreticalExam;

public class EmailNotificationVisitor implements Visitor {

    Object emailManager;

    public EmailNotificationVisitor(Object emailManager) {
        this.emailManager = emailManager;
    }

    @Override
    public void visit(TeoreticalExam exam) {

        exam.getTeoreticalExaminer();
        exam.getPkkList();
        exam.getExamDate();

        //emailManager.sendEMails(params)

    }

    @Override
    public void visit(PracticExam exam) {
        exam.getPracticalExaminer();
        exam.getPkk();
        exam.getExamDate();

        //emailManager.sendEmails(params)
    }


}
