package word.system.gui.viewsControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class controllerKrysiaPanel {

    //dostęp do tej strony po zalogowaniu jako pani ustalajaca egzaminy, bedzie tu oznaczac wplaty oraz ogarniac terminy
    @RequestMapping("krysiaPanel")
    public String krysiaPanel(HttpServletRequest request) {
        return "userViews/krysiaPanel";
    }


    //Krysia actions
    @RequestMapping("getMoney")
    public String getMoney(HttpServletRequest request) {

        return "userViews/actions/getMoney";
    }

    @RequestMapping("signOnExam")
    public String signOnExam(HttpServletRequest request) {

        return "userViews/actions/signOnExam";
    }

    @RequestMapping("createExam")
    public String createExam(HttpServletRequest request) {

        return "userViews/actions/createExam";
    }

    @RequestMapping("createExamResults")
    public String createExamResults(HttpServletRequest request) {

        return "userViews/actions/createExamResults";
    }

}
