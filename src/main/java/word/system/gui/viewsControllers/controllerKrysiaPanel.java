package word.system.gui.viewsControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import word.system.DrivingLicenseApplication.DrivingLicenseApplication;
import word.system.exam.PracticExam;
import word.system.exam.PracticExamRepository;
import word.system.exam.TeoreticalExam;
import word.system.exam.TeoreticalExamRepository;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class controllerKrysiaPanel {

    @Autowired
    PracticExamRepository practicExamRepository;
    @Autowired
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


    @GetMapping("createTeoreticalExam")
    public String postMCreateTeoreticalExam(HttpServletRequest request) throws ParseException {

        return "userViews/actions/createTeoreticalExam";
    }

    @PostMapping("createTeoreticalExam")
    public String getMCreateTeoreticalExam(HttpServletRequest request, Model model) throws ParseException {
      
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
