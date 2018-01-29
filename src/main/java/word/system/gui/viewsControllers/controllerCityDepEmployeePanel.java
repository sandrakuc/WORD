package word.system.gui.viewsControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import word.system.DrivingLicenseApplication.DrivingLicenseApplication;
import word.system.common.DriveLicenseType;
import word.system.user.User;
import word.system.user.UserRepository;
import word.system.DrivingLicenseApplication.ApplicationRepository;

import javax.servlet.http.HttpServletRequest;


@Controller
public class controllerCityDepEmployeePanel{

    @Autowired
    UserRepository userRepository;

    @Autowired
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

    @GetMapping("prepereDriverLicenseApplication")
    public String getMPrepereDriverLicenseApplication(HttpServletRequest request) {

        return "userViews/actions/prepereDriverLicenseApplication";
    }

    @PostMapping("prepereDriverLicenseApplication")
    public String postMPrepereDriverLicenseApplication(HttpServletRequest request, Model model) {
        DrivingLicenseApplication drivingLicenseApplication = new DrivingLicenseApplication();
        drivingLicenseApplication.setName(request.getParameter("name"));
        drivingLicenseApplication.setSurname(request.getParameter("surname"));
        drivingLicenseApplication.setAddress(request.getParameter("address"));
        drivingLicenseApplication.setPesel(request.getParameter("pesel"));
        drivingLicenseApplication.setPesel(request.getParameter("DLCategory"));
        drivingLicenseApplication.setStatus(DrivingLicenseApplication.Status.InPorcessOfMaking);
        applicationRepository.save(drivingLicenseApplication);

        model.addAttribute("drivingLicenseApplication", drivingLicenseApplication);

        return "userViews/actions/prepereDriverLicenseApplication";
    }




    @GetMapping("checkDriverLicenseApplication")
    public String getCheckDriverLicenseApplication(HttpServletRequest request, Model model) {
        DrivingLicenseApplication drivingLicenseApplication = new DrivingLicenseApplication();
        drivingLicenseApplication.setPesel(request.getParameter("pesel"));
        String tmpPesel = drivingLicenseApplication.getPesel();

        System.out.println("\n\n\n\n"+ tmpPesel + "\n\n\n\n");
        drivingLicenseApplication = applicationRepository.getByPesel(tmpPesel);

        System.out.println("\n\n\n\nStatus wniosku z bazy"+ drivingLicenseApplication.getStatus() + "\n\n\n\n");
        drivingLicenseApplication.setStatus(drivingLicenseApplication.getStatus());

        model.addAttribute("drivingLicenseApplication",drivingLicenseApplication);
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
