package word.system.gui.viewsControllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import word.system.user.User;

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



    @GetMapping("createPkk")
    public String formGet() {
        return "userViews/actions/createPkk";
    }

    @PostMapping("createPkk")
    public String formPost(User user, Model model) {
        model.addAttribute("user", user);
        return "userViews/actions/createPkk";
    }

//    @RequestMapping("createPkk")
//    public String createPkk(HttpServletRequest request) {
//
//        return "userViews/actions/createPkk";
//    }
}
