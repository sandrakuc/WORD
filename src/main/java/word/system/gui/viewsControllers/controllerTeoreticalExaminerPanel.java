package word.system.gui.viewsControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import word.system.exam.TeoreticalExam;
import word.system.exam.TeoreticalExamRepository;
import word.system.user.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class controllerTeoreticalExaminerPanel {

    @Autowired
    TeoreticalExamRepository teoreticalExamRepository;

    //dostęp do tej strony po zalogowaniu jako egzaminator teoretyczny. bedzie tu ustalal pytania itd
    @PostMapping("teoreticalExaminerPanel")
    public String postMTeoreticalExaminerPanel(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        User sessionUser = (User)session.getAttribute("user");

        Long recordNumber = teoreticalExamRepository.count();
        ArrayList<TeoreticalExam> teoreticalExams = new ArrayList<TeoreticalExam>();

        for (long i=1; i<=recordNumber; i++ ) {
            TeoreticalExam teoreticalExam =  teoreticalExamRepository.getById(i);

            if(teoreticalExam.getExaminer().getId() == sessionUser.getId()) {
                teoreticalExams.add(teoreticalExam);
            }
        }
        System.out.println("\n\n\n" + teoreticalExams + "\n\n\n");
        randQuestions();

        model.addAttribute("userId", sessionUser.getId());
        model.addAttribute("teoreticalExams", teoreticalExams);

        return "userViews/teoreticalExaminerPanel";
    }

    public void randQuestions()
    {

    }

    @GetMapping("teoreticalExaminerPanel")
    public String getMTeoreticalExaminerPanel(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        User sessionUser = (User)session.getAttribute("user");

        Long recordNumber = teoreticalExamRepository.count();
        ArrayList<TeoreticalExam> teoreticalExams = new ArrayList<TeoreticalExam>();

        for (long i=1; i<=recordNumber; i++ ) {
            TeoreticalExam teoreticalExam =  teoreticalExamRepository.getById(i);

            if(teoreticalExam.getExaminer().getId() == sessionUser.getId()) {
                teoreticalExams.add(teoreticalExam);
            }
        }
        System.out.println("\n\n\n" + teoreticalExams + "\n\n\n");

        model.addAttribute("userId", sessionUser.getId());
        model.addAttribute("teoreticalExams", teoreticalExams);

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
