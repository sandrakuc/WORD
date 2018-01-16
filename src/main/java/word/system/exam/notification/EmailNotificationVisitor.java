package word.system.exam.notification;

import word.system.exam.PracticAbstractExam;
import word.system.exam.TeoreticalAbstractExam;

public class EmailNotificationVisitor implements Visitor {

    Object emailManager;

    public EmailNotificationVisitor(Object emailManager) {
        this.emailManager = emailManager;
    }

    @Override
    public void visit(TeoreticalAbstractExam exam) {

        exam.getTeoreticalExaminer();
        exam.getPkkList();
        exam.getExamDate();

        //emailManager.sendEMails(params)

    }

    @Override
    public void visit(PracticAbstractExam exam) {
        exam.getPracticalExaminer();
        exam.getPkk();
        exam.getExamDate();

        //emailManager.sendEmails(params)
    }


}
