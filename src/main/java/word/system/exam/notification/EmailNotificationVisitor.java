package word.system.exam.notification;

import word.system.exam.PracticExam;
import word.system.exam.TeoreticalExam;
import word.system.exam.examiners.PracticalExaminer;
import word.system.exam.examiners.TeoreticalExaminer;
import word.system.pkk.Pkk;

import java.util.Date;

public class EmailNotificationVisitor implements Visitor {

    Object emailManager;

    //tylko do testów
    public String emailContent;
    public String emailSubject;

    public EmailNotificationVisitor(Object emailManager) {
        this.emailManager = emailManager;
    }

    @Override
    public void visit(TeoreticalExam exam) {

        TeoreticalExaminer teoreticalExaminer = exam.getTeoreticalExaminer();
        exam.getPkkList();
        Date examDate = exam.getExamDate();

        emailSubject = "egzamin teoretyczny w dniu: "+examDate.toString();
        emailContent = "egzaminator: "+teoreticalExaminer.name+" "+teoreticalExaminer.surname;

        //emailManager.sendEMails(params)

    }

    @Override
    public void visit(PracticExam exam) {
        PracticalExaminer practicalExaminer = exam.getPracticalExaminer();
        Pkk pkk = exam.getPkk();
        Date examDate = exam.getExamDate();

        emailSubject = "egzamin praktyczny w dniu: "+examDate.toString();
        emailContent = "egzaminator: "+practicalExaminer.name+" "+practicalExaminer.surname+" zdający: "+pkk.name+" "+pkk.surname;

        //emailManager.sendEmails(params)
    }


}
