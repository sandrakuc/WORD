package word.system.gui.admin;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import word.system.Application;
import word.system.DrivingLicenseApplication.DrivingLicenseApplication;
import word.system.DrivingLicenseApplication.DrivingLicenseApplicationRepository;
import word.system.carfactory.Machine;
import word.system.carfactory.MachineRepository;
import word.system.exam.PracticExam;
import word.system.exam.PracticExamRepository;
import word.system.exam.TeoreticalExam;
import word.system.exam.TeoreticalExamRepository;
import word.system.exam.TeoreticalQuestions.AnswerBase;
import word.system.exam.TeoreticalQuestions.AnswerRepository;
import word.system.exam.TeoreticalQuestions.QuestionBase;
import word.system.exam.TeoreticalQuestions.QuestionRepository;
import word.system.exam.approach.*;
import word.system.gui.admin.entityView.*;
import word.system.user.User;
import word.system.user.UserRepository;

@SpringUI(path="/admin")
@Theme("valo")
public class VaadinUI extends UI {

    public Navigator navigator;

    UserRepository userRepository;
    MachineRepository machineRepository;
    AnswerRepository answerRepository;
    DrivingLicenseApplicationRepository drivingLicenseApplicationRepository;
    CourseOfExamRepository courseOfExamRepository;
    PracticApproachRepository practicApproachRepository;
    PracticExamRepository practicExamRepository;
    QuestionRepository questionRepository;
    TeoreticalApproachRepository teoreticalApproachRepository;
    TeoreticalExamRepository teoreticalExamRepository;


    @Autowired
    public VaadinUI(UserRepository repo,
                    MachineRepository machineRepository,
                    AnswerRepository answerRepository,
                    DrivingLicenseApplicationRepository drivingLicenseApplicationRepository,
                    CourseOfExamRepository courseOfExamRepository,
                    PracticApproachRepository practicApproachRepository,
                    PracticExamRepository practicExamRepository,
                    QuestionRepository questionRepository,
                    TeoreticalApproachRepository teoreticalApproachRepository,
                    TeoreticalExamRepository teoreticalExamRepository

    ) {
        this.userRepository = repo;
        this.machineRepository = machineRepository;
        this.answerRepository = answerRepository;
        this.drivingLicenseApplicationRepository = drivingLicenseApplicationRepository;
        this.courseOfExamRepository = courseOfExamRepository;
        this.practicApproachRepository = practicApproachRepository;
        this.practicExamRepository = practicExamRepository;
        this.questionRepository = questionRepository;
        this.teoreticalApproachRepository = teoreticalApproachRepository;
        this.teoreticalExamRepository = teoreticalExamRepository;
    }

    @Override
    protected void init(VaadinRequest request) {


        navigator = new Navigator(this, this);
        navigator.addView("", new UserView(navigator, userRepository, User.class));
        navigator.addView("user", new UserView(navigator, userRepository, User.class));
        navigator.addView("machine", new MachineView(navigator, machineRepository, Machine.class));
        navigator.addView("answer", new AnswerView(navigator, answerRepository, AnswerBase.class));
        navigator.addView("drivingLicenseApplication", new DrivingLicenseApplicationView(navigator, drivingLicenseApplicationRepository, DrivingLicenseApplication.class));
        navigator.addView("courseOfExam", new CourseOfExamView(navigator, courseOfExamRepository, CourseOfExam.class));
        navigator.addView("practicApproach", new PracticApproachView(navigator, practicApproachRepository, PracticApproach.class));
        navigator.addView("practicExam", new PracticExamView(navigator, practicExamRepository, PracticExam.class));
        navigator.addView("question", new QuestionView(navigator, questionRepository, QuestionBase.class));
        navigator.addView("teoreticalApproach", new TeoreticalApproachView(navigator, teoreticalApproachRepository, TeoreticalApproach.class));
        navigator.addView("teoreticalExam", new TeoreticalExamView(navigator, teoreticalExamRepository, TeoreticalExam.class));


    }
}
