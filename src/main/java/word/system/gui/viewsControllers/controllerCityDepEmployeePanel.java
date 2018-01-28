package word.system.gui.viewsControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class controllerCityDepEmployeePanel {

    //dostęp do tej strony po zalogowaniu jako admin, bedzie tu zarzadxzał bazą np dodawanie aut do bazy, egzaminatorow itp
    @RequestMapping("cityDepEmployeePanel")
    public String cityDepEmployeePanel(HttpServletRequest request) {
        return "userViews/cityDepEmployeePanel";
    }

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
}
