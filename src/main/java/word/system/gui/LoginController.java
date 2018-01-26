package word.system.gui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;
import word.system.user.User;
import word.system.user.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

@Controller
public class LoginController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("login")
    public String index(HttpServletRequest request) {
        HttpSession session = request.getSession();
        FlashMessageManager flashMessageManager = new FlashMessageManager(request.getSession());

        if(session.getAttribute("user") != null ) {
            flashMessageManager.addMessage("Jesteś już zalogowany!", FlashMessageManager.Type.ERROR);
        }

        if(request.getParameter("login") != null) {
            String login = request.getParameter("login");
            User user = userRepository.getByLogin(login);

            if(user == null) {
                flashMessageManager.addMessage("Hasło lub login niepoprawne!", FlashMessageManager.Type.ERROR);
            }else if(user.getPassword().equals(request.getParameter("password"))) {
                flashMessageManager.addMessage("zalogowano", FlashMessageManager.Type.INFO);
                session.setAttribute("user", user);
            } else {
                flashMessageManager.addMessage("Hasło lub login niepoprawne", FlashMessageManager.Type.ERROR);
            }
        }

        return "login/login";
    }

    //dostęp do tej strony po zalogowaniu jako egzaminator teoretyczny. bedzie tu ustalal pytania itd
    @RequestMapping("teoreticalExaminerPanel")
    public String teoreticalExaminerPanel(HttpServletRequest request) {
        return "userViews/teoreticalExaminerPanel";
    }

    //dostęp do tej strony po zalogowaniu jako egzaminator praktyczny.
    @RequestMapping("practicalExaminerPanel")
    public String practicalExaminerPanel(HttpServletRequest request) {
        return "userViews/practicalExaminerPanel";
    }


    //dostęp do tej strony po zalogowaniu jako zdajacy, bedzie tu mogl sprawdzic status wniosku o prawko
    @RequestMapping("pkkPanel")
    public String pkkPanel(HttpServletRequest request) {
        return "userViews/pkkPanel";
    }

    //dostęp do tej strony po zalogowaniu jako admin, bedzie tu zarzadxzał bazą np dodawanie aut do bazy, egzaminatorow itp
    @RequestMapping("adminPanel")
    public String adminPanel(HttpServletRequest request) {
        return "userViews/adminPanel";
    }

    //dostęp do tej strony po zalogowaniu jako pani ustalajaca egzaminy, bedzie tu oznaczac wplaty oraz ogarniac terminy
    @RequestMapping("krysiaPanel")
    public String krysiaPanel(HttpServletRequest request) {
        return "userViews/krysiaPanel";
    }
}
