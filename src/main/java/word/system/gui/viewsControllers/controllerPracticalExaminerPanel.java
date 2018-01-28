package word.system.gui.viewsControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class controllerPracticalExaminerPanel {

    //dostęp do tej strony po zalogowaniu jako egzaminator praktyczny.
    @RequestMapping("practicalExaminerPanel")
    public String practicalExaminerPanel(HttpServletRequest request) {
        return "userViews/practicalExaminerPanel";
    }
}
