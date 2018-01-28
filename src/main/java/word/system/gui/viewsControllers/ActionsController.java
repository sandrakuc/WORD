package word.system.gui.viewsControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ActionsController {

    ///CityDepEmployee actions
    @RequestMapping("prepereDriverLicenseApplication")
    public String prepereDriverLicenseApplication(HttpServletRequest request) {

        return "userViews/actions/prepereDriverLicenseApplication";
    }

    @RequestMapping("checkDriverLicenseApplication")
    public String checkDriverLicenseApplication(HttpServletRequest request) {

        return "userViews/actions/checkDriverLicenseApplication";
    }

    @RequestMapping("createPkk")
    public String createPkk(HttpServletRequest request) {

        return "userViews/actions/createPkk";
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

    //egzaminator teoretyczny actions
    @RequestMapping("openExam")
    public String openExam(HttpServletRequest request) {

        return "userViews/actions/openExam";
    }

    @RequestMapping("closeExam")
    public String closeExam(HttpServletRequest request) {

        return "userViews/actions/closeExam";
    }


}
