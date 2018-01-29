package word.system.gui.viewsControllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import word.system.DrivingLicenseApplication.DrivingLicenseApplication;
import word.system.exam.PracticExam;
import word.system.exam.PracticExamRepository;
import word.system.exam.TeoreticalExam;
import word.system.exam.TeoreticalExamRepository;

import javax.servlet.http.HttpServletRequest;

@Controller
public class controllerKrysiaPanel {

    PracticExamRepository practicExamRepository;
    TeoreticalExamRepository teoreticalExamRepository;

    //dostęp do tej strony po zalogowaniu jako pani ustalajaca egzaminy, bedzie tu oznaczac wplaty oraz ogarniac terminy
    @RequestMapping("krysiaPanel")
    public String krysiaPanel(HttpServletRequest request) {
        return "userViews/krysiaPanel";
    }


    //Krysia actions
    @RequestMapping("signOnPracticalExam")
    public String signOnPracticalExam(HttpServletRequest request) {

        return "userViews/actions/signOnPracticalExam";
    }

    @RequestMapping("signOnTeoreticalExam")
    public String signOnTeoreticalExam(HttpServletRequest request) {

        return "userViews/actions/signOnTeoreticalExam";
    }

    @RequestMapping("getMoney")
    public String getMoney(HttpServletRequest request) {

        return "userViews/actions/getMoney";
}



    @RequestMapping("createTeoreticalExam")
    public String createTeoreticalExam(HttpServletRequest request) {
        TeoreticalExam teoreticalExam = new TeoreticalExam();
        teoreticalExam.setDate(null);
        return "userViews/actions/createTeoreticalExam";
    }

    @RequestMapping("createPracticalExam")
    public String createPracticalExam(HttpServletRequest request) {

        return "userViews/actions/createPracticalExam";
    }

    @RequestMapping("createExamResults")
    public String createExamResults(HttpServletRequest request) {

        return "userViews/actions/createExamResults";
    }

}
