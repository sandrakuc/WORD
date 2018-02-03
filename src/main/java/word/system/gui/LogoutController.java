package word.system.gui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import word.system.user.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class LogoutController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("logout")
    public String logout(HttpServletRequest request/*, HttpServletResponse response*/) {
        request.getSession().invalidate();
        /*try {
            response.sendRedirect(request.getContextPath() + "login");
        } catch (IOException e) {
            System.out.println(e);
        }*/
        return "redirect:/login";
    }

}
