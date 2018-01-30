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
                
                if(user.getRole()== User.Role.ADMIN){
                    return "admin";
                }else if (user.getRole()== User.Role.PKK) {
                    return "pkkPanel";
                }
                else if (user.getRole()== User.Role.PRACTIC_EXAMINER) {
                    return "practicalExaminerPanel";
                }
                else if (user.getRole()== User.Role.TEORETICAL_EXAMINER) {
                    return "teoreticalExaminerPanel";
                }
                else if (user.getRole()== User.Role.CASHEER) {
                    return "krysiaPanel";
                }
                else if (user.getRole()== User.Role.CITY_DEPARTMENT) {
                    return "cityDepEmployeePanel";
                }
            } else {
                flashMessageManager.addMessage("Hasło lub login niepoprawne", FlashMessageManager.Type.ERROR);
            }


        }


        return "login/login";
    }

}
