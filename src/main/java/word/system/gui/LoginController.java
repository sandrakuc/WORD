package word.system.gui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;
import word.system.user.User;
import word.system.user.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

@Controller
public class LoginController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("login")
    public String index(HttpServletRequest request) {
        if(request.getSession().getAttribute("user") != null ) {
            //@todo flashmessage
        }

        if(request.getParameter("login") != null) {
            String login = request.getParameter("login");
            User user = userRepository.getByLogin(login);



        }




        return "login/login";
    }
}
