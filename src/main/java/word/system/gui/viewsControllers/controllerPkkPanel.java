package word.system.gui.viewsControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import word.system.DrivingLicenseApplication.DrivingLicenseApplicationRepository;
import word.system.DrivingLicenseApplication.DrivingLicenseApplication;

import word.system.common.DriveLicenseType;
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
    DrivingLicenseApplicationRepository drivingLicenseApplicationRepository;

    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    CourseOfExamRepository courseOfExamRepository;

    @Autowired
    TeoreticalExamRepository teoreticalExamRepository;

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
        //zabezpieczenie
        session.setAttribute("questionBase1",null);
        session.setAttribute("questionBase2",null);
        session.setAttribute("questionBase3",null);
        session.setAttribute("answer1",null);
        session.setAttribute("answer2",null);
        session.setAttribute("answer3",null);
        session.setAttribute("teoreticalExam", null);


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



        for (long i=1; i<=teoreticalExamsNumber; i++ ) {
            TeoreticalExamToPkk teoreticalExamToPkk = teoreticalExamToPkkRepository.getById(i);

            if (teoreticalExamToPkk.getUser().equals(sessionUser)) {
                teoreticalExamToPKKList.add(teoreticalExamToPkk);

                if (teoreticalExamToPkk.getPercResult() >= 66.0 ){
                    teoreticalExamToPkk.setTextResult("ZDANE");
                }
                else if(teoreticalExamToPkk.getPercResult() == -1.0)
                {
                    teoreticalExamToPkk.setPercResult(0.0);
                    teoreticalExamToPkk.setTextResult("BRAK PODEJSCIA");
                }
                else
                {
                    teoreticalExamToPkk.setTextResult("NIEZDANE");
                }
            }
        }
        System.out.println("\n\n\n\n\n" + teoreticalExamToPKKList + "\n\n\n\n\n");

        ///wypisywanie wnioskow
        Long applicationRecorsNumber = drivingLicenseApplicationRepository.count();
        ArrayList<DrivingLicenseApplication> pkkApplicationsList = new ArrayList<DrivingLicenseApplication>();

        for (long i=1; i<=applicationRecorsNumber; i++ ) {
            DrivingLicenseApplication drivingLicenseApplication = drivingLicenseApplicationRepository.getById(i);

            if (drivingLicenseApplication.getUser().equals(sessionUser)) {
                pkkApplicationsList.add(drivingLicenseApplication);
            }
        }
        //System.out.println("\n\n\n\n\n" + pkkApplicationsList + "\n\n\n\n\n");

        model.addAttribute("userId", sessionUser.getId());
        model.addAttribute("pkkPracticalExamsList", pkkPracticalExamsList);
        model.addAttribute("teoreticalExamToPKKList", teoreticalExamToPKKList);
        model.addAttribute("pkkApplicationsList", pkkApplicationsList);
        return "userViews/pkkPanel";
    }

    @RequestMapping("takeTheExam")
    public String takeTheExam(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        FlashMessageManager flashMessageManager = new FlashMessageManager(request.getSession());
        Long examId = Long.valueOf(request.getParameter("id"));
        TeoreticalExam teoreticalExam = teoreticalExamRepository.getById(examId);
        User user = (User)session.getAttribute("user");
        TeoreticalExamToPkk teoreticalExamToPkk = teoreticalExamToPkkRepository.getByTeoreticalExamAndUser(teoreticalExam, user);
        if(teoreticalExam.getTeoreticalExamStatus().equals(TeoreticalExamStatus.TRWA) && teoreticalExamToPkk != null) {
            session.setAttribute("teoreticalExam", teoreticalExam);
            if (session.getAttribute("questionBase1") == null || session.getAttribute("questionBase2") == null || session.getAttribute("questionBase3") == null) {
                Random rd = new Random();
                long id1, id2, id3;
                do {
                    id1 = (long) rd.nextInt(15) + 1;
                    id2 = (long) rd.nextInt(15) + 1;
                    id3 = (long) rd.nextInt(15) + 1;
                } while (id1 == id2 || id1 == id3 || id2 == id3);
                QuestionBase questionBase1 = questionRepository.getById(id1);
                session.setAttribute("questionBase1", questionBase1);
                QuestionBase questionBase2 = questionRepository.getById(id2);
                session.setAttribute("questionBase2", questionBase2);
                QuestionBase questionBase3 = questionRepository.getById(id3);
                session.setAttribute("questionBase3", questionBase3);
                System.out.println(questionBase3.getContents());
                model.addAttribute("questionBase1", questionBase1);
                model.addAttribute("questionBase2", questionBase2);
                model.addAttribute("questionBase3", questionBase3);
            }
        }
        if(teoreticalExam.getTeoreticalExamStatus().equals(TeoreticalExamStatus.GOTOWY) && teoreticalExamToPkk != null){
            return "userViews/actions/examNotStartedYet";
        }
        if(teoreticalExam.getTeoreticalExamStatus().equals(TeoreticalExamStatus.ZAKONCZONY) && teoreticalExamToPkk != null){
            return "userViews/actions/examBlocked";
        }
        if(teoreticalExamToPkk == null){
            return "userViews/actions/notYoursExam";
        }
        return "userViews/actions/takeTheExam";
    }

    @PostMapping("finishAndConfirmTheExam")
    public String finishAndConfirmTheExam2(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        FlashMessageManager flashMessageManager = new FlashMessageManager(request.getSession());
        double i = 0.0;
        TeoreticalExam teoreticalExam = (TeoreticalExam) session.getAttribute("teoreticalExam");
        User user = (User)session.getAttribute("user");
        TeoreticalExamToPkk teoreticalExamToPkk = teoreticalExamToPkkRepository.getByTeoreticalExamAndUser(teoreticalExam,user);
        CourseOfExam courseOfExam1 = new CourseOfExam();
        CourseOfExam courseOfExam2 = new CourseOfExam();
        CourseOfExam courseOfExam3 = new CourseOfExam();
        QuestionBase questionBase1 = (QuestionBase)session.getAttribute("questionBase1");
        QuestionBase questionBase2 = (QuestionBase)session.getAttribute("questionBase2");
        QuestionBase questionBase3 = (QuestionBase)session.getAttribute("questionBase3");
        AnswerBase answer1 = new AnswerBase();
        answer1.setQuestion(questionBase1);
        answer1.setAnswer(request.getParameter("pierwsze"));
        System.out.println("DEBUG: " + answer1.getAnswer());
        if(answer1.getAnswer() != null)
            answerRepository.save(answer1);
        if(answer1.getAnswer().equals(questionBase1.getCorrectAnswer()))
            i+=1.0;
        session.setAttribute("answer1", answer1);
        courseOfExam1.setPartcipants((User)session.getAttribute("user"));
        courseOfExam1.setAnswers(answer1);
        courseOfExamRepository.save(courseOfExam1);
        AnswerBase answer2 = new AnswerBase();
        answer2.setQuestion(questionBase2);
        answer2.setAnswer(request.getParameter("drugie"));
        System.out.println("DEBUG: " + answer2.getAnswer());
        if(answer2.getAnswer() != null)
            answerRepository.save(answer2);
        if(answer2.getAnswer().equals(questionBase2.getCorrectAnswer()))
            i+=1.0;
        session.setAttribute("answer2", answer2);
        courseOfExam2.setPartcipants((User)session.getAttribute("user"));
        courseOfExam2.setAnswers(answer2);
        courseOfExamRepository.save(courseOfExam2);
        AnswerBase answer3 = new AnswerBase();
        answer3.setQuestion(questionBase3);
        answer3.setAnswer(request.getParameter("trzecie"));
        System.out.println("DEBUG: " + answer3.getAnswer());
        if(answer3.getAnswer() != null)
            answerRepository.save(answer3);
        if(answer3.getAnswer().equals(questionBase3.getCorrectAnswer()))
            i+=1.0;
        session.setAttribute("answer3", answer3);
        courseOfExam3.setPartcipants((User)session.getAttribute("user"));
        courseOfExam3.setAnswers(answer3);
        courseOfExamRepository.save(courseOfExam3);
        teoreticalExam.setTeoreticalExamStatus(TeoreticalExamStatus.ZAKONCZONY);
        teoreticalExamRepository.save(teoreticalExam);
        double result = (i/3)*100;
        System.out.println("DEBUG: " + result);
        String textResult;
        if(result < 66.0)
            textResult = "NIEZDANE";
        else
            textResult = "ZDANE";
        teoreticalExamToPkk.setPercResult(result);
        teoreticalExamToPkk.setTextResult(textResult);
        teoreticalExamToPkkRepository.save(teoreticalExamToPkk);
        ArrayList<CourseOfExam> courses = new ArrayList<>();
        courses.add(courseOfExam1);
        courses.add(courseOfExam2);
        courses.add(courseOfExam3);
        TeoreticalApproach teoreticalApproach = new TeoreticalApproach();
        teoreticalApproach.setCourses(courses);
        teoreticalApproach.setTeoreticalExam(teoreticalExam);
        teoreticalApproach.setType(DriveLicenseType.B);
        teoreticalApproachRepository.save(teoreticalApproach);
        model.addAttribute("questionBase1", questionBase1);
        model.addAttribute("questionBase2", questionBase2);
        model.addAttribute("questionBase3", questionBase3);
        return "userViews/actions/finishAndConfirmTheExam";
    }

    @PostMapping("examNotStartedYet")
    public String examNotStartedYet(HttpServletRequest request) {
        return "userViews/actions/examNotStartedYet";
    }

    @PostMapping("examBlocked")
    public String examBlocked(HttpServletRequest request) {
        return "userViews/actions/examBlocked";
    }

    @PostMapping("notYoursExam")
    public String notYoursExam(HttpServletRequest request) {
        return "userViews/actions/notYoursExam";
    }
}
