package word.system.gui.viewsControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import word.system.DrivingLicenseApplication.ApplicationStatus;
import word.system.DrivingLicenseApplication.DrivingLicenseApplication;
import word.system.common.DriveLicenseType;
import word.system.gui.FlashMessageManager;
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

    public DrivingLicenseApplication mapPeselToPkkId(String tmp_pesel, DrivingLicenseApplication drivingLicenseApplication)
    {
        Long recordNumber = userRepository.count();
        for (long i=1; i<=recordNumber; i++ ) {
            User user =  userRepository.getById(i);
                                                //System.out.println("\n\n\n\n\n" + user.getPesel() + " " + tmp_pesel + "\n\n\n\n\n");
            if(user.getPesel().equals(tmp_pesel)) {
                                               //System.out.println("\n\n\n\n\n" +user.getId());
                //ustawiam obiekt usera dla wniosku po wyszukaniu go. Obiekt wniosku przechowuje obiekt usera
                drivingLicenseApplication.setUser(user);
                return drivingLicenseApplication;
            }
        }
        return null;
    }

    @PostMapping("prepereDriverLicenseApplication")
    public String postMPrepereDriverLicenseApplication(HttpServletRequest request, Model model) {
        String message = "";
        boolean applicationApply = false;

        DrivingLicenseApplication drivingLicenseApplication = new DrivingLicenseApplication();
        drivingLicenseApplication.setName(request.getParameter("name"));
        drivingLicenseApplication.setSurname(request.getParameter("surname"));
        drivingLicenseApplication.setAddress(request.getParameter("address"));
        drivingLicenseApplication.setPesel(request.getParameter("pesel"));
        drivingLicenseApplication.setCategory(request.getParameter("DLCategory"));
        drivingLicenseApplication.setStatus(ApplicationStatus.PODANIE_UTWORZONE);

        //mapowanie peselu do id pkk
        String tmp_pesel = request.getParameter("pesel");
        if(mapPeselToPkkId(tmp_pesel, drivingLicenseApplication)!=null)
        {
            System.out.println("\n\n\n\n\n" +drivingLicenseApplication);
            applicationRepository.save(drivingLicenseApplication);
            message="Dodano wniosek dla usera o id = " + drivingLicenseApplication.getId();
            applicationApply=true;
        }
        else
            message ="Nie ma zdajacego o takim peselu";


        model.addAttribute("drivingLicenseApplication", drivingLicenseApplication);
        model.addAttribute("message", message);
        model.addAttribute("applicationApply", applicationApply);

        return "userViews/actions/prepereDriverLicenseApplication";
    }




    @GetMapping("checkDriverLicenseApplication")
    public String getCheckDriverLicenseApplication(HttpServletRequest request, Model model) {

        Long applicationId = Long.parseLong(request.getParameter("id"));
        //System.out.println("\n\n\n\n"+ applicationId + "\n\n\n\n");

        DrivingLicenseApplication drivingLicenseApplication = applicationRepository.getById(applicationId);
        System.out.println("\n\n\n" + drivingLicenseApplication + "\n\n\n\n");

        if(drivingLicenseApplication!=null){
            model.addAttribute("drivingLicenseApplication",drivingLicenseApplication);
        }
        else{
            String errMessage = "Nie ma takiego wniosku";
            model.addAttribute("errMessage",errMessage);
        }

        return "userViews/actions/checkDriverLicenseApplication";

    }



    @RequestMapping("createPkk")
    public String createPkk(){
        return "userViews/actions/createPkk";
    }

    @GetMapping("createPkk")
    public String formGet() {
        return "userViews/actions/createPkk";
    }

    @PostMapping("createPkk")
    public String formPost(HttpServletRequest request, Model model) {

        User usertmp = new User();
        usertmp.setAddress(request.getParameter("address"));
        usertmp.setFirstName(request.getParameter("firstName"));
        usertmp.setLastName(request.getParameter("lastName"));
        usertmp.setAddress(request.getParameter("address"));
        usertmp.setPesel(request.getParameter("pesel"));
        usertmp.setEmail(request.getParameter("email"));
        usertmp.setRole(User.Role.PKK);
        usertmp.setLogin(request.getParameter("login"));
        usertmp.setPassword(request.getParameter("password"));

        System.out.println("\n\n\n\n"+usertmp + "\n\n\n\n");
        //System.out.println(user);
        userRepository.save(usertmp);


        model.addAttribute("usertmp", usertmp);
        return "userViews/actions/createPkk";
    }


}
