package word.system.gui.viewsControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import word.system.exam.TeoreticalQuestions.QuestionBase;
import word.system.exam.TeoreticalQuestions.QuestionRepository;

import javax.servlet.http.HttpServletRequest;

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
    public String takeTheExam(HttpServletRequest request) {
        QuestionBase questionBase = questionRepository.getById((long) 1);
        System.out.println(questionBase.getContents());
        System.out.println(questionBase.getPossibleAnswer1());
        System.out.println(questionBase.getPossibleAnswer2());
        System.out.println(questionBase.getPossibleAnswer3());
        System.out.println(questionBase.getPossibleAnswer4());
        questionBase = questionRepository.getById((long) 2);
        System.out.println(questionBase.getContents());
        System.out.println(questionBase.getPossibleAnswer1());
        System.out.println(questionBase.getPossibleAnswer2());
        System.out.println(questionBase.getPossibleAnswer3());
        System.out.println(questionBase.getPossibleAnswer4());
        questionBase = questionRepository.getById((long) 3);
        System.out.println(questionBase.getContents());
        System.out.println(questionBase.getPossibleAnswer1());
        System.out.println(questionBase.getPossibleAnswer2());
        System.out.println(questionBase.getPossibleAnswer3());
        System.out.println(questionBase.getPossibleAnswer4());

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
