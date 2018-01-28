package word.system.gui.viewsControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class controllerTeoreticalExaminerPanel {

    //dostęp do tej strony po zalogowaniu jako egzaminator teoretyczny. bedzie tu ustalal pytania itd
    @RequestMapping("teoreticalExaminerPanel")
    public String teoreticalExaminerPanel(HttpServletRequest request) {
        return "userViews/teoreticalExaminerPanel";
    }

    @RequestMapping("openExam")
    public String openExam(HttpServletRequest request) {

        return "userViews/actions/openExam";
    }

    @RequestMapping("closeExam")
    public String closeExam(HttpServletRequest request) {

        return "userViews/actions/closeExam";
    }

}
