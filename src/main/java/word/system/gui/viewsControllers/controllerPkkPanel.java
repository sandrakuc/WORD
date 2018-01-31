package word.system.gui.viewsControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import word.system.exam.TeoreticalQuestions.QuestionBase;
import word.system.exam.TeoreticalQuestions.QuestionRepository;
import word.system.gui.FlashMessageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Random;

@Controller
public class controllerPkkPanel {
    @Autowired
    QuestionRepository questionRepository;

    //dostęp do tej strony po zalogowaniu jako zdajacy, bedzie tu mogl sprawdzic status wniosku o prawko
    @RequestMapping("pkkPanel")
    public String pkkPanel(HttpServletRequest request) {
        return "userViews/pkkPanel";
    }

    @RequestMapping("takeTheExam")
    public String takeTheExam(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        FlashMessageManager flashMessageManager = new FlashMessageManager(request.getSession());
        if(session.getAttribute("questionBase1") == null || session.getAttribute("questionBase2") == null || session.getAttribute("questionBase3")==null) {
            Random rd = new Random();
            long id1, id2, id3;
            do {
                id1 = (long) rd.nextInt(15) + 1;
                id2 = (long) rd.nextInt(15) + 1;
                id3 = (long) rd.nextInt(15) + 1;
            } while (id1 == id2 || id1 == id3 || id2 == id3);
            QuestionBase questionBase1 = questionRepository.getById(id1);
            session.setAttribute("questionBase1", questionBase1);
            System.out.println(questionBase1.getContents());
            System.out.println(questionBase1.getPossibleAnswer1());
            System.out.println(questionBase1.getPossibleAnswer2());
            System.out.println(questionBase1.getPossibleAnswer3());
            QuestionBase questionBase2 = questionRepository.getById(id2);
            session.setAttribute("questionBase2", questionBase2);
            System.out.println(questionBase2.getContents());
            System.out.println(questionBase2.getPossibleAnswer1());
            System.out.println(questionBase2.getPossibleAnswer2());
            System.out.println(questionBase2.getPossibleAnswer3());
            QuestionBase questionBase3 = questionRepository.getById(id3);
            session.setAttribute("questionBase3", questionBase3);
            System.out.println(questionBase3.getContents());
            System.out.println(questionBase3.getPossibleAnswer1());
            System.out.println(questionBase3.getPossibleAnswer2());
            System.out.println(questionBase3.getPossibleAnswer3());
            model.addAttribute("questionBase1", questionBase1);
            model.addAttribute("questionBase2", questionBase2);
            model.addAttribute("questionBase3", questionBase3);
        }
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
