package word.system.gui.viewsControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import word.system.user.User;
import word.system.user.UserRepository;
import word.system.DrivingLicenseApplication.ApplicationRepository;

import javax.servlet.http.HttpServletRequest;


@Controller
public class controllerCityDepEmployeePanel {

    @Autowired
    UserRepository userRepository;
    ApplicationRepository applicationRepository;

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


    @GetMapping("checkDriverLicenseApplication")
    public String checkDriverLicenseApplication(Model model) {
        
        return "userViews/actions/checkDriverLicenseApplication";
    }





    @GetMapping("createPkk")
    public String formGet() {


        return "userViews/actions/createPkk";
    }

    @PostMapping("createPkk")
    public String formPost(HttpServletRequest request, Model model) {

        User user = new User();
        user.setAddress(request.getParameter("address"));
        user.setFirstName(request.getParameter("firstName"));
        user.setLastName(request.getParameter("lastName"));
        user.setAddress(request.getParameter("address"));
        user.setEmail(request.getParameter("email"));
        user.setRole(User.Role.PKK);
        user.setLogin(request.getParameter("login"));
        user.setPassword(request.getParameter("password"));

        //System.out.println(user);
        userRepository.save(user);

        model.addAttribute("user", user);
        return "userViews/actions/createPkk";
    }


}
