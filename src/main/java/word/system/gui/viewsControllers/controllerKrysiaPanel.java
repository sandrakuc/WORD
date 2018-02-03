package word.system.gui.viewsControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import word.system.carfactory.Machine;
import word.system.carfactory.MachineRepository;
import word.system.carfactory.MachineType;
import word.system.exam.*;
import word.system.user.User;
import word.system.user.UserRepository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
    @Autowired
    MachineRepository machineRepository;
    @Autowired
    TeoreticalExamToPkkRepository teoreticalExamToPkkRepository;



    //dostęp do tej strony po zalogowaniu jako pani ustalajaca egzaminy, bedzie tu oznaczac wplaty oraz ogarniac terminy
    @RequestMapping("krysiaPanel")
    public String krysiaPanel(HttpServletRequest request) {
        return "userViews/krysiaPanel";
    }


    //Krysia actions

    @GetMapping("signOnTeoreticalExam")
    public String GetMSignOnTeoreticalExam(HttpServletRequest request, Model model) {
        ArrayList<TeoreticalExam> examRecords = getTeoreticalExamRecords();
        model.addAttribute("examRecords",examRecords);
        return "userViews/actions/signOnTeoreticalExam";
    }

    @PostMapping("signOnTeoreticalExamResult")
    public String PostMSignOnTeoreticalExam(HttpServletRequest request, Model model) {
        String examIdFromForm = (String)request.getParameter("teoreticalExamId");
        String peselFromForm = (String)request.getParameter("pesel");
        Boolean pkkCorrect = false;
        Boolean examIdCorrect = false;
//        System.out.println("\nPkk poprz str " + examIdFromForm + " " + peselFromForm);

        TeoreticalExamToPkk teoreticalExamToPkk = new TeoreticalExamToPkk();
        teoreticalExamToPkk.setPercResult(-1.0); //zawsze tyle przy nowym podejsciu
        teoreticalExamToPkk.setTextResult("brak"); //zawsze tyle przy nowym podejsciu

        //sprawdzanie czy istnieje podany egzamin teoretyczny
        ArrayList<TeoreticalExam> examRecordsList = getTeoreticalExamRecords();  //pobranie wszystkich rekordow z tabeli
        for (int i=0; i<examRecordsList.size(); i++ )
        {
            String examId = Long.toString( examRecordsList.get(i).getId() );
//            System.out.println("\negz Z bazy " + examId);
//            System.out.println(" Z formularza " + examIdFromForm);

            if( examId.equals(examIdFromForm) ){
                teoreticalExamToPkk.setTeoreticalExam(examRecordsList.get(i));
                System.out.println(" \n\nZnaleziono pasujace examId");
                examIdCorrect=true;
            }
        }

        //sprawdzanie czy istnieje podany pkkId
        ArrayList<User> pkkRecordsList = getUsersWithPkkRole();
        for (int i=0; i<pkkRecordsList.size(); i++ )
        {
            String pkkPesel = pkkRecordsList.get(i).getPesel();
//            System.out.println("\nPkk Z bazy " + pkkPesel);
//            System.out.println(" Z formularza " + peselFromForm);

            if( pkkPesel.equals(peselFromForm)){
                teoreticalExamToPkk.setUser(pkkRecordsList.get(i));
                System.out.println(" \n\nZnaleziono pasujace pkk\n\n");
                pkkCorrect=true;
            }

        }



        if(teoreticalExamToPkk.getUser()!=null && teoreticalExamToPkk.getTeoreticalExam()!=null && teoreticalExamToPkk.getTeoreticalExam().getTeoreticalExamStatus()!= TeoreticalExamStatus.ZAKONCZONY)
        {
            teoreticalExamToPkkRepository.save(teoreticalExamToPkk);
            model.addAttribute("pkkName",teoreticalExamToPkk.getUser().getFirstName());
            model.addAttribute("pkkSurname",teoreticalExamToPkk.getUser().getLastName());
            model.addAttribute("examData", teoreticalExamToPkk.getTeoreticalExam().getDate());
            model.addAttribute("examRoom", teoreticalExamToPkk.getTeoreticalExam().getRoom());
        }

        if(pkkCorrect==false && examIdCorrect == false){
            setPkkErrMsg(model);
            setExamErrMsg(model);
        }
        else if(pkkCorrect==false)
            setPkkErrMsg(model);
        else if(examIdCorrect==false)
            setExamErrMsg(model);
        else if( teoreticalExamToPkk.getTeoreticalExam().getTeoreticalExamStatus()== TeoreticalExamStatus.ZAKONCZONY )
            setStatusErrMsq(model);

        return "userViews/actions/signOnTeoreticalExamResult";
    }



    @GetMapping("createPracticalExam")
    public String createPracticalExam(HttpServletRequest request, Model model) {
        model.addAttribute("curTime", getCurTimeForDatatimeForm());
        return "userViews/actions/createPracticalExam";
    }

    @GetMapping("createTeoreticalExam")
    public String postMCreateTeoreticalExam(HttpServletRequest request, Model model) {
        model.addAttribute("curTime", getCurTimeForDatatimeForm());
        return "userViews/actions/createTeoreticalExam";
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




    @PostMapping("createPracticalExamResult")
    public String createPracticalExamResults(HttpServletRequest request, Model model) throws ParseException {

        PracticExam practicExam = new PracticExam();
        String stringDate = request.getParameter("pracExamDate");
        practicExam.setDate( parseDate(stringDate) );
        practicExam.setExamResult(ExamResult.NIEROZPOCZETY);
        String pesel = request.getParameter("pesel");
        practicExam.setPesel(pesel);

        //losowanie egzaminatora praktycznego
        ArrayList<User> practicalExaminersList = getPracticalExaminersFromDB();
        User examiner = randExaminer(practicalExaminersList);
        practicExam.setExaminer(examiner);

        ///losowanie maszyny
        String examCategory = request.getParameter("examCategory");
        ArrayList<Machine> machineList = getMachinesFromDB(examCategory);
        Machine machine = randMachine(machineList);
        practicExam.setMachine(machine);

        //Mapowanie userId po peselu
        User tmpUser = mapPeselToPkkId( pesel );
        if(tmpUser != null)
        {
            practicExam.setPkk(tmpUser);
           // System.out.println("\n\n\n\n\n" +practicExam);
            practicExamRepository.save(practicExam);
        }
        else {
            String message = "Nie ma zdajacego o takim peselu";
            model.addAttribute("message", message);
        }

        model.addAttribute("examType", "Praktyczny");
        model.addAttribute("date", practicExam.getDate());
        model.addAttribute("examinerFirstName",practicExam.getExaminer().getFirstName());
        model.addAttribute("examinerLastName",practicExam.getExaminer().getLastName());

        //x System.out.println("\n\n\n\n"+practicalExaminersList.size() + "\n\n\n\n");
//        System.out.println("\n\n\n\nLista "+practicalExaminersList + "\n\n\n\n");
//        System.out.println("\n\n\n\nWylosowany "+examiner + "\n\n\n\n");
        //System.out.println("\n\n\n\nLista pojazdow "+machineList + "\n\n\n\n");
        return "userViews/actions/createPracticalExamResult";
    }

    @PostMapping("getMoney")
    public String getMoney(HttpServletRequest request) {

        return "userViews/actions/getMoney";
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



    public ArrayList<TeoreticalExam> getTeoreticalExamRecords()
    {
        Long recordsNumber = teoreticalExamRepository.count();
        ArrayList<TeoreticalExam> recordList = new ArrayList<TeoreticalExam>();

        for (long i=1; i<=recordsNumber; i++ ) {
            TeoreticalExam record  = teoreticalExamRepository.getById(i);
            recordList.add(record);
        }
        return recordList;
    }

    public ArrayList<Machine> getMachinesFromDB(String examCategory) {
        Long machineRecordsNumber = machineRepository.count();
        ArrayList<Machine> machineList = new ArrayList<Machine>();

        for (long i=1; i<=machineRecordsNumber; i++ ) {
            Machine machine = machineRepository.getById(i);

            ///jesli wpisano kategorie A lub pochodne to szukaj motyocykli jesli nie to aut
            if ( examCategory.equals("AM") || examCategory.equals("A1") || examCategory.equals("A2") || examCategory.equals("A"))
            {
               // System.out.println("\n\n\n\n\nWybieram motocykle");
               if(machine.getType().equals(MachineType.MOTORCYCLE))
                 machineList.add(machine);

            }
            else
            {
                //System.out.println("\n\n\n\n\nWybieram Auta");
                if(machine.getType().equals(MachineType.MOTORCYCLE))
                  machineList.add(machine);

            }
        }
        return machineList;
    }

    public ArrayList<User> getPracticalExaminersFromDB(){
        Long userRecordsNumber = userRepository.count();
        ArrayList<User> practicalExaminersList = new ArrayList<User>();

        for (long i=1; i<=userRecordsNumber; i++ ) {
            User practicalExaminer  = userRepository.getById(i);

            if (practicalExaminer.getRole().equals(User.Role.PRACTIC_EXAMINER)) {
                practicalExaminersList.add(practicalExaminer);
            }
        }
        return practicalExaminersList;
    }



    public User randExaminer(ArrayList<User> examinersList)
    {
        Integer randTopBorder = examinersList.size();
        Random rand = new Random();
        User examiner =  examinersList.get(rand.nextInt(randTopBorder));
        return examiner;
    }

    private Machine randMachine(ArrayList<Machine> machineList) {
        Integer randTopBorder = machineList.size();
        Random rand = new Random();
        Machine machine =  machineList.get(rand.nextInt(randTopBorder));
        return machine;
    }


    public String getCurTimeForDatatimeForm(){
        LocalDate dateNow = LocalDate.now();
        LocalTime timeNow = LocalTime.now();

        String hours = Integer.toString( timeNow.getHour());
        if(timeNow.getHour() <10)
            hours = "0" + Integer.toString( timeNow.getHour());

        String minute = Integer.toString( timeNow.getMinute());
        if(timeNow.getMinute() <10)
            minute = "0" + Integer.toString( timeNow.getMinute());


        String curDateForForm = dateNow.toString() + "T" + hours + ":" + minute;
        System.out.println("\n\n\n\n "+ curDateForForm+ "\n\n\n\n");
        return  curDateForForm;
    }

    public User mapPeselToPkkId(String tmp_pesel)
    {
        Long recordNumber = userRepository.count();
        for (long i=1; i<=recordNumber; i++ ) {
            User user =  userRepository.getById(i);
           // System.out.println("\n\n\n\n\nZnaleziono zgodny pesel" + user.getPesel() + " " + tmp_pesel + "\n\n\n\n\n");

            if(user.getPesel().equals(tmp_pesel)) {
                return user;
            }
        }
        return null;
    }

    private ArrayList<User> getUsersWithPkkRole() {
        Long recordNumber = userRepository.count();
        ArrayList<User> pkkList = new ArrayList<User>();
        for (long i=1; i<=recordNumber; i++ ) {
            User user =  userRepository.getById(i);
            if(user.getRole().equals(User.Role.PKK)) {
                pkkList.add(user);
            }
        }
        return pkkList;
    }

    private void setPkkErrMsg(Model model)
    {
        model.addAttribute("pkkErrMsg","Nie ma takiego PKK");
    }

    private void setExamErrMsg(Model model)
    {
        model.addAttribute("examErrMsg","Nie ma takiego egzaminu");
    }

    private void setStatusErrMsq(Model model) { model.addAttribute("examStatusErrMsg","Egzamin jest zamkniety");
    }



}
