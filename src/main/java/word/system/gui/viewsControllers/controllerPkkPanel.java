package word.system.gui.viewsControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class controllerPkkPanel {

    //dostęp do tej strony po zalogowaniu jako zdajacy, bedzie tu mogl sprawdzic status wniosku o prawko
    @RequestMapping("pkkPanel")
    public String pkkPanel(HttpServletRequest request) {
        return "userViews/pkkPanel";
    }

}
