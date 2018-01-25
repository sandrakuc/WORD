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

        if(session.getAttribute("user") != null ) {
            //@todo flashmessage
        }

        if(request.getParameter("login") != null) {
            String login = request.getParameter("login");
            User user = userRepository.getByLogin(login);
            if(user.getPassword().equals(request.getParameter("password"))) {
                System.out.println("zalogowano");
                session.setAttribute("user", user);
            } else {
                System.out.println("niepoprawne hasło");
            }
        }




        return "login/login";
    }
}
