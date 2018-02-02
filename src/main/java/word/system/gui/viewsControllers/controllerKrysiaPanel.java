package word.system.gui.viewsControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import word.system.DrivingLicenseApplication.DrivingLicenseApplication;
import word.system.exam.*;
import word.system.user.User;
import word.system.user.UserRepository;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

@Controller
public class controllerKrysiaPanel {

    @Autowired
    PracticExamRepository practicExamRepository;
    @Autowired
    TeoreticalExamRepository teoreticalExamRepository;
    @Autowired
    UserRepository userRepository;



    //dostęp do tej strony po zalogowaniu jako pani ustalajaca egzaminy, bedzie tu oznaczac wplaty oraz ogarniac terminy
    @RequestMapping("krysiaPanel")
    public String krysiaPanel(HttpServletRequest request) {
        return "userViews/krysiaPanel";
    }


    //Krysia actions
    @RequestMapping("signOnPracticalExam")
    public String signOnPracticalExam(HttpServletRequest request) {

        return "userViews/actions/signOnPracticalExam";
    }

    @RequestMapping("signOnTeoreticalExam")
    public String signOnTeoreticalExam(HttpServletRequest request) {

        return "userViews/actions/signOnTeoreticalExam";
    }

    @RequestMapping("getMoney")
    public String getMoney(HttpServletRequest request) {

        return "userViews/actions/getMoney";
}



    @GetMapping("createTeoreticalExam")
    public String postMCreateTeoreticalExam(HttpServletRequest request, Model model) {
        model.addAttribute("curTime", getCurTimeForDatatimeForm());
        return "userViews/actions/createTeoreticalExam";
    }

    @PostMapping("createTeoreticalExam")
    public String getMCreateTeoreticalExam(HttpServletRequest request, Model model) throws ParseException {

        return "userViews/actions/createTeoreticalExam";
    }

    @RequestMapping("createPracticalExam")
    public String createPracticalExam(HttpServletRequest request) {


        return "userViews/actions/createPracticalExam";
    }

    @PostMapping("createTeoreticalExamResult")
    public String createExamResults(HttpServletRequest request, Model model) throws ParseException {
        TeoreticalExam teoreticalExam = new TeoreticalExam();
        String stringDate = request.getParameter("teorExamDate");

        teoreticalExam.setDate( parseDate(stringDate) );
        teoreticalExam.setRoom(request.getParameter("room"));

        //losowanie egzaminatora
        ArrayList<User> teoreticalExaminersList = getTeoreticalExaminersFromDB();
        User examiner = randExaminer(teoreticalExaminersList);
        teoreticalExam.setExaminer(examiner);

        teoreticalExam.setTeoreticalExamStatus(TeoreticalExamStatus.GOTOWY);

        teoreticalExamRepository.save(teoreticalExam);

        model.addAttribute("examType", "Teoretyczny");
        model.addAttribute("date", teoreticalExam.getDate());
        model.addAttribute("examinerFirstName",teoreticalExam.getExaminer().getFirstName());
        model.addAttribute("examinerLastName",teoreticalExam.getExaminer().getLastName());

        //x System.out.println("\n\n\n\n"+teoreticalExaminersList.size() + "\n\n\n\n");
//        System.out.println("\n\n\n\nLista "+teoreticalExaminersList + "\n\n\n\n");
//        System.out.println("\n\n\n\nWylosowany "+examiner + "\n\n\n\n");
        return "userViews/actions/createTeoreticalExamResult";
    }



    public Date parseDate(String stringDate) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        Date date = (Date)formatter.parse(stringDate);
        System.out.println("Date after parse: \n\n\n\n" + date);
        return  date;
    }

    public ArrayList<User> getTeoreticalExaminersFromDB(){
        Long userRecordsNumber = userRepository.count();
        ArrayList<User> teoreticalExaminersList = new ArrayList<User>();

        for (long i=1; i<=userRecordsNumber; i++ ) {
            User teoreticalExaminer  = userRepository.getById(i);

            if (teoreticalExaminer.getRole().equals(User.Role.TEORETICAL_EXAMINER)) {
                teoreticalExaminersList.add(teoreticalExaminer);
            }
        }
        return teoreticalExaminersList;
    }

    public User randExaminer(ArrayList<User> teoreticalExaminersList)
    {
        Integer randTopBorder = teoreticalExaminersList.size();
        Random rand = new Random();
        User examiner =  teoreticalExaminersList.get(rand.nextInt(randTopBorder));
        return examiner;
    }

    public String getCurTimeForDatatimeForm(){
        LocalDate dateNow = LocalDate.now();
        LocalTime timeNow = LocalTime.now();
        //System.out.println("\n\n\n\n "+ curDateForForm+ "\n\n\n\n");
        return  dateNow.toString() + "T" +timeNow.getHour() + ":" +timeNow.getMinute();
    }

}
