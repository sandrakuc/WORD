package word.system.gui.viewsControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import word.system.exam.ExamResult;
import word.system.exam.PracticExam;
import word.system.exam.PracticExamRepository;
import word.system.user.User;
import word.system.user.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import static java.lang.Math.toIntExact;


@Controller
public class controllerPracticalExaminerPanel {

    @Autowired
    PracticExamRepository practicExamRepository;
    @Autowired
    UserRepository userRepository;




    @PostMapping("practicalExaminerPanel")
    public String postMPrepereDriverLicenseApplication(HttpServletRequest request, Model model) {


        HttpSession session = request.getSession();
        User sessionUser = (User)session.getAttribute("user");

        Long recordNumber = practicExamRepository.count();
        ArrayList<PracticExam> practicExamsList = new ArrayList<PracticExam>();

        //pobranie wszystkich egzaminow jesli obiekt egzaminu ma w sobie id egzaminatora takie same jak id egzaminatora w sesji
        //to ten egzamin zostanie dodany do practicExamList a potem wyswietlony na stronie
        for (long i=1; i<=recordNumber; i++ ) {
            PracticExam practicExam =  practicExamRepository.getById(i);

            if(practicExam.getExaminer().getId() == sessionUser.getId()) {
                practicExamsList.add(practicExam);
            }
        }

        modifyTable(request,model,practicExamsList);

        model.addAttribute("userId", sessionUser.getId());
        model.addAttribute("practicExamsList", practicExamsList);

        return "userViews/practicalExaminerPanel";
    }

    private void modifyTable(HttpServletRequest request, Model model, ArrayList<PracticExam> practicExams)
    {
        String message = "";

        //gdy user wprowadzi jakies id do pola tekstowego
        if(request.getParameter("examId")!="" && request.getParameter("examId")!=null)
        {
            //pobieranie id egzaminu do zmiany i sprawdzanie czy taki istnieje na liscie dla tego egzaminatora egzaminow wtedy go zmieniamy
            Integer examIdToChange = Integer.parseInt(request.getParameter("examId"));

            Integer idInDatabase = examIdToChange;
            Integer idInArrayList = examIdToChange-1;


            if(checkIdEnterOnField(practicExams,idInArrayList)==true)
            {
                //sprawdzanie co bylo zaznaczone w radioboxach
                if(request.getParameter("examResult").equals("positive"))
                {
                    practicExams.get(idInArrayList).setExamResult(ExamResult.ZALICZONY);
                }
                else
                    practicExams.get(idInArrayList).setExamResult(ExamResult.NIEZALICZONY);
               message = "Zmodyfikowano wpis";

                practicExamRepository.save(practicExams.get(idInArrayList));

            }else
                message = "Wprowadziłeś złe id" + examIdToChange;


        }
        model.addAttribute("message",message);
    }

    private boolean checkIdEnterOnField(ArrayList<PracticExam> practicExams, Integer idInArrayList)
    {
        if(idInArrayList==null)
            return false;

        for (PracticExam p: practicExams)
        {
            if(toIntExact( p.getId()-1 ) == idInArrayList){
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }


    @GetMapping("practicalExaminerPanel")
    public String getMPrepereDriverLicenseApplication(HttpServletRequest request, Model model) {


        HttpSession session = request.getSession();
        User sessionUser = (User)session.getAttribute("user");

        Long recordNumber = practicExamRepository.count();
        ArrayList<PracticExam> practicExamsList = new ArrayList<PracticExam>();

        for (long i=1; i<=recordNumber; i++ ) {
            PracticExam practicExam =  practicExamRepository.getById(i);

            if(practicExam.getExaminer().getId() == sessionUser.getId()) {
                practicExamsList.add(practicExam);
            }
        }

        model.addAttribute("userId", sessionUser.getId());
        model.addAttribute("practicExamsList", practicExamsList);

        return "userViews/practicalExaminerPanel";
    }

}