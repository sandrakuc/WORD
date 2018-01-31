package word.system.gui.viewsControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import word.system.exam.TeoreticalExam;
import word.system.exam.TeoreticalExamRepository;
import word.system.exam.TeoreticalExamStatus;
import word.system.user.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

import static java.lang.Math.toIntExact;

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
        modifyTable(request,model,teoreticalExams);

        model.addAttribute("userId", sessionUser.getId());
        model.addAttribute("teoreticalExams", teoreticalExams);

        return "userViews/teoreticalExaminerPanel";
    }


    private void modifyTable(HttpServletRequest request, Model model, ArrayList<TeoreticalExam> teoreticalExams)
    {
        String message = "";

        //gdy user wprowadzi jakies id do pola tekstowego
        if(request.getParameter("examId")!="" && request.getParameter("examId")!=null)
        {
            //pobieranie id egzaminu do zmiany i sprawdzanie czy taki istnieje na liscie dla tego egzaminatora egzaminow wtedy go zmieniamy
            Integer examIdToChange = Integer.parseInt(request.getParameter("examId"));

            Integer idInDatabase = examIdToChange;
            Integer idInArrayList = checkIdEnterOnField(teoreticalExams,idInDatabase);
            System.out.println("\n\n\n\n\n"+ idInArrayList + "\n\n\n\n");

            if(checkIdEnterOnField(teoreticalExams,idInDatabase)!=-1)
            {
                //sprawdzanie co bylo zaznaczone w radioboxach
                if(request.getParameter("examStatus").equals("otwarty"))
                {
                    teoreticalExams.get(idInArrayList).setTeoreticalExamStatus(TeoreticalExamStatus.TRWA);
                }
                else if(request.getParameter("examStatus").equals("zamkniety")) {
                    teoreticalExams.get(idInArrayList).setTeoreticalExamStatus(TeoreticalExamStatus.ZAKONCZONY);
                }
                message = "Zmodyfikowano wpis";

                teoreticalExamRepository.save(teoreticalExams.get(idInArrayList));
                model.addAttribute("message",message);

            }else
                message = "Nie ma takiego id";


        }
        model.addAttribute("message",message);
    }

    private Integer checkIdEnterOnField(ArrayList<TeoreticalExam> teoreticalExams, Integer idInDatabase)
    {
        if(idInDatabase==null)
            return -1;

        for (TeoreticalExam p: teoreticalExams)
        {
            if(toIntExact( p.getId() ) == idInDatabase){
                return teoreticalExams.indexOf(p);
            }
        }
        return -1;
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
