package word.system.gui.viewsControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class controllerPkkPanel {

    //dostęp do tej strony po zalogowaniu jako zdajacy, bedzie tu mogl sprawdzic status wniosku o prawko
    @RequestMapping("pkkPanel")
    public String pkkPanel(HttpServletRequest request) {
        return "userViews/pkkPanel";
    }

    @RequestMapping("takeTheExam")
    public String takeTheExam(HttpServletRequest request) {
        return "userViews/actions/takeTheExam";
    }

    @GetMapping("finishAndConfirmTheExam")
    public String finishAndConfirmTheExam(HttpServletRequest request) {
        return "userViews/actions/finishAndConfirmTheExam";
    }

    @PostMapping("finishAndConfirmTheExam")
    public String finishAndConfirmTheExam2(HttpServletRequest request) {
        return "userViews/actions/finishAndConfirmTheExam";
    }

}
