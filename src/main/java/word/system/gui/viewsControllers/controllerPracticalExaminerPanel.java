package word.system.gui.viewsControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import word.system.exam.PracticExam;
import word.system.exam.PracticExamRepository;
import word.system.user.User;
import word.system.user.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class controllerPracticalExaminerPanel {

    @Autowired
    PracticExamRepository practicExamRepository;
    @Autowired
    UserRepository userRepository;

    //dostęp do tej strony po zalogowaniu jako egzaminator praktyczny.

//    @RequestMapping("practicalExaminerPanel")
//    public String practicalExaminerPanel(HttpServletRequest request) {
//        Long recordNumber = practicExamRepository.count();
//        ArrayList<PracticExam> practicExamsList = new ArrayList<PracticExam>();
//
//        for (long i=1; i<=recordNumber; i++ ) {
//            practicExamsList.add( practicExamRepository.getById(i) );
////            System.out.println("\n\n" + practicExamRepository.getById(i) + "\n\n");
//        }
////        System.out.println("Lista obiektow\n\n" + practicExamsList + "\n\n");
////        System.out.println("Record number" + recordNumber + "\n\n");
////        System.out.println( practicExamsList.get(1).getId()+ "\n\n"); //return 2 wiec id=1 to id=0 na liscie
//        return "userViews/practicalExaminerPanel";
//    }


    @PostMapping("practicalExaminerPanel")
    public String postMPrepereDriverLicenseApplication(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        User sessionUser = (User)session.getAttribute("user");


        Long recordNumber = practicExamRepository.count();
        ArrayList<PracticExam> practicExamsList = new ArrayList<PracticExam>();

        //pobranie egzaminow jesli obiekt egzaminu ma w sobie id egzaminatora takie same jak id egzaminatora w sesji
        //to ten egzamin zostanie dodany do practicExamList a potem wyswietlony na stronie
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
