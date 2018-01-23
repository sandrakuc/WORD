package word.system.exam;

import org.junit.Assert;
import org.junit.Test;
import word.system.carfactory.Car;
import word.system.exam.examiners.PracticalExaminer;
import word.system.exam.examiners.TeoreticalExaminer;
import word.system.exam.notification.EmailNotificationVisitor;
import word.system.pkk.Pkk;

import java.util.Date;

public class NotificationVisitorTest {


    @Test
    public void visitTeoreticalExamTest() throws Exception {
        //arrange
        TeoreticalExaminer teoreticalExaminer = new TeoreticalExaminer();
        teoreticalExaminer.name = "Andrzej";
        teoreticalExaminer.surname = "Nowak";

        TeoreticalExam teoreticalExam = new TeoreticalExam();
        teoreticalExam.setSala("2.22DH");
        teoreticalExam.setTeoreticalExaminer(teoreticalExaminer);
        teoreticalExam.setExamDate(new Date(0)); //0 to Thu Jan 01 01:00:00 CET 1970

        EmailNotificationVisitor emailNotificationVisitor = new EmailNotificationVisitor(new Object());

        //action
        teoreticalExam.accept(emailNotificationVisitor);

        //assert
        Assert.assertEquals("egzamin teoretyczny w dniu: Thu Jan 01 01:00:00 CET 1970", emailNotificationVisitor.emailSubject);
        Assert.assertEquals("egzaminator: Andrzej Nowak sala: 2.22DH", emailNotificationVisitor.emailContent);
    }

    @Test
    public void visitPracticExamTest() throws Exception {
        //arrange
        PracticalExaminer practicalExaminer = new PracticalExaminer();
        practicalExaminer.name = "Janusz";
        practicalExaminer.surname = "Januszowski";

        Pkk pkk = new Pkk();
        pkk.name = "Piotr";
        pkk.surname = "Pjoterowski";

        Car car = new Car();
        car.setBrand("Ford");
        car.setModel("Fiesta");
        car.setPlate("TK XXX");
        car.setNumber(13);
        car.setColour("czerwony");

        PracticExam practicExam = new PracticExam();
        practicExam.setMachine(car);
        practicExam.setPracticalExaminer(practicalExaminer);
        practicExam.setExamDate(new Date(0)); //0 to Thu Jan 01 01:00:00 CET 1970
        practicExam.setPkk(pkk);

        EmailNotificationVisitor emailNotificationVisitor = new EmailNotificationVisitor(new Object());

        //action
        practicExam.accept(emailNotificationVisitor);

        //assert
        Assert.assertEquals("egzamin praktyczny w dniu: Thu Jan 01 01:00:00 CET 1970", emailNotificationVisitor.emailSubject);
        Assert.assertEquals("egzaminator: Janusz Januszowski zdający: Piotr Pjoterowski Auto nr: 13 marka: Ford model: Fiesta kolor: czerwony nr rejestracji: TK XXX", emailNotificationVisitor.emailContent);
    }
}
