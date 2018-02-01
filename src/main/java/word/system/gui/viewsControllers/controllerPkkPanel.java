package word.system.gui.viewsControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import word.system.DrivingLicenseApplication.ApplicationRepository;
import word.system.DrivingLicenseApplication.DrivingLicenseApplication;

import word.system.exam.*;

import word.system.exam.PracticExam;
import word.system.exam.PracticExamRepository;
import word.system.exam.TeoreticalQuestions.AnswerBase;
import word.system.exam.TeoreticalQuestions.AnswerRepository;

import word.system.exam.TeoreticalQuestions.QuestionBase;
import word.system.exam.TeoreticalQuestions.QuestionRepository;
import word.system.exam.approach.CourseOfExam;
import word.system.exam.approach.CourseOfExamRepository;
import word.system.exam.approach.TeoreticalApproach;
import word.system.exam.approach.TeoreticalApproachRepository;
import word.system.gui.FlashMessageManager;
import word.system.user.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

@Controller
public class controllerPkkPanel {
    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    PracticExamRepository practicExamRepository;

    @Autowired
    TeoreticalExamToPkkRepository teoreticalExamToPkkRepository;

    @Autowired
    ApplicationRepository applicationRepository;

    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    CourseOfExamRepository courseOfExamRepository;

    @Autowired
    TeoreticalApproachRepository teoreticalApproachRepository;

    //dostęp do tej strony po zalogowaniu jako zdajacy, bedzie tu mogl sprawdzic status wniosku o prawko
    @GetMapping("pkkPanel")
    public String PostMPkkPanel(HttpServletRequest request, Model model) {


        return "userViews/pkkPanel";
    }

    @PostMapping("pkkPanel")
    public String GetMPkkPanel(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        User sessionUser = (User)session.getAttribute("user");

        ///wypisywanie egzaminow praktycznych
        Long practicalExamsRecordsNumber = practicExamRepository.count();
        ArrayList<PracticExam> pkkPracticalExamsList = new ArrayList<PracticExam>();

        for (long i=1; i<=practicalExamsRecordsNumber; i++ ) {
            PracticExam practicExam =  practicExamRepository.getById(i);

            if(practicExam.getPkk().equals(sessionUser)) {
                pkkPracticalExamsList.add(practicExam);
            }


        }
        //System.out.println("\n\n\n\n\n" + pkkPracticalExamsList + "\n\n\n\n\n");


        ///wypisywanie egz teoretycznych
        Long teoreticalExamsNumber = teoreticalExamToPkkRepository.count();
        ArrayList<TeoreticalExamToPkk> teoreticalExamToPKKList = new ArrayList<TeoreticalExamToPkk>();
        String textResult = "";

        for (long i=1; i<=teoreticalExamsNumber; i++ ) {
            TeoreticalExamToPkk teoreticalExamToPkk = teoreticalExamToPkkRepository.getById(i);

            if (teoreticalExamToPkk.getUser().equals(sessionUser)) {
                teoreticalExamToPKKList.add(teoreticalExamToPkk);

                if (teoreticalExamToPkk.getPercResult() >= 66.0 ){
                    textResult = "ZDANE";
                }
                else if(teoreticalExamToPkk.getPercResult() == -1.0)
                {
                    teoreticalExamToPkk.setPercResult(0.0);
                    textResult = "BRAK PODEJSCIA";
                }
                else
                {
                    textResult = "NIEZDANE";
                }
            }
        }
        System.out.println("\n\n\n\n\n" + teoreticalExamToPKKList + "\n\n\n\n\n");

        ///wypisywanie wnioskow
        Long applicationRecorsNumber = applicationRepository.count();
        ArrayList<DrivingLicenseApplication> pkkApplicationsList = new ArrayList<DrivingLicenseApplication>();

        for (long i=1; i<=applicationRecorsNumber; i++ ) {
            DrivingLicenseApplication drivingLicenseApplication = applicationRepository.getById(i);

            if (drivingLicenseApplication.getUser().equals(sessionUser)) {
                pkkApplicationsList.add(drivingLicenseApplication);
            }
        }
        //System.out.println("\n\n\n\n\n" + pkkApplicationsList + "\n\n\n\n\n");

        model.addAttribute("userId", sessionUser.getId());
        model.addAttribute("pkkPracticalExamsList", pkkPracticalExamsList);

        model.addAttribute("teoreticalExamToPKKList", teoreticalExamToPKKList);
        model.addAttribute("textResult", textResult);

        model.addAttribute("pkkApplicationsList", pkkApplicationsList);
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

    @PostMapping("takeTheExam")
    public String answerPost(HttpServletRequest request) {
        Collection<CourseOfExam> courses = null;
        HttpSession session = request.getSession();
        FlashMessageManager flashMessageManager = new FlashMessageManager(request.getSession());
        CourseOfExam courseOfExam1 = new CourseOfExam();
        CourseOfExam courseOfExam2 = new CourseOfExam();
        CourseOfExam courseOfExam3 = new CourseOfExam();
        AnswerBase answer1 = new AnswerBase();
        answer1.setQuestion((QuestionBase) session.getAttribute("questionBase1"));
        answer1.setAnswer(request.getParameter("pierwsze"));
        session.setAttribute("answer1", answer1);
        answerRepository.save(answer1);
        courseOfExam1.setAnswers(answer1);
        courseOfExam1.setPartcipants((User)session.getAttribute("user"));
        session.setAttribute("courseOfExam1",courseOfExam1);
        courseOfExamRepository.save(courseOfExam1);
        AnswerBase answer2 = new AnswerBase();
        answer2.setQuestion((QuestionBase)session.getAttribute("questionBase2"));
        answer2.setAnswer(request.getParameter("drugie"));
        session.setAttribute("answer2", answer2);
        answerRepository.save(answer2);
        courseOfExam2.setAnswers(answer2);
        courseOfExam2.setPartcipants((User)session.getAttribute("user"));
        session.setAttribute("courseOfExam2",courseOfExam2);
        courseOfExamRepository.save(courseOfExam2);
        AnswerBase answer3 = new AnswerBase();
        answer3.setQuestion((QuestionBase)session.getAttribute("questionBase3"));
        answer3.setAnswer(request.getParameter("trzecie"));
        session.setAttribute("answer3", answer3);
        answerRepository.save(answer3);
        courseOfExam3.setAnswers(answer3);
        courseOfExam3.setPartcipants((User)session.getAttribute("user"));
        session.setAttribute("courseOfExam3",courseOfExam3);
        courseOfExamRepository.save(courseOfExam3);
        courses.add(courseOfExam1);
        courses.add(courseOfExam2);
        courses.add(courseOfExam3);
        TeoreticalApproach approach = new TeoreticalApproach();
        approach.setCourses(courses); //to do: przemyslec jak pobrac egzamin
        session.setAttribute("approach", approach); //przemyslec jak zrobic sesje dla kilku osob naraz
        teoreticalApproachRepository.save(approach);

        return "userViews/actions/takeTheExam";
    }


    @GetMapping("finishAndConfirmTheExam")
    public String finishAndConfirmTheExam(HttpServletRequest request) {
        HttpSession session = request.getSession();
        FlashMessageManager flashMessageManager = new FlashMessageManager(request.getSession());
        session.setAttribute("questionBase1", null);
        session.setAttribute("questionBase2", null);
        session.setAttribute("questionBase3", null);
        session.setAttribute("answer1", null);
        session.setAttribute("answer2", null);
        session.setAttribute("answer3", null);
        session.setAttribute("courseOfExam1", null);
        session.setAttribute("courseOfExam2", null);
        session.setAttribute("courseOfExam3", null);
        session.setAttribute("approach", null);
        return "userViews/actions/finishAndConfirmTheExam";
    }

    @PostMapping("finishAndConfirmTheExam")
    public String finishAndConfirmTheExam2(HttpServletRequest request) {
        HttpSession session = request.getSession();
        FlashMessageManager flashMessageManager = new FlashMessageManager(request.getSession());
        session.setAttribute("questionBase1", null);
        session.setAttribute("questionBase2", null);
        session.setAttribute("questionBase3", null);
        session.setAttribute("answer1", null);
        session.setAttribute("answer2", null);
        session.setAttribute("answer3", null);
        session.setAttribute("courseOfExam1", null);
        session.setAttribute("courseOfExam2", null);
        session.setAttribute("courseOfExam3", null);
        session.setAttribute("approach", null);
        return "userViews/actions/finishAndConfirmTheExam";
    }

}
