package word.system.gui;

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



}
