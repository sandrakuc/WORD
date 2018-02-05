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
import word.system.exam.TeoreticalQuestions.AnswerBase;
import word.system.exam.TeoreticalQuestions.AnswerRepository;
import word.system.gui.admin.entityView.AnswerView;
import word.system.gui.admin.entityView.DrivingLicenseApplicationView;
import word.system.gui.admin.entityView.MachineView;
import word.system.gui.admin.entityView.UserView;
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


    @Autowired
    public VaadinUI(UserRepository repo,
                    MachineRepository machineRepository,
                    AnswerRepository answerRepository,
                    DrivingLicenseApplicationRepository drivingLicenseApplicationRepository

    ) {
        this.userRepository = repo;
        this.machineRepository = machineRepository;
        this.answerRepository = answerRepository;
        this.drivingLicenseApplicationRepository = drivingLicenseApplicationRepository;


    }

    @Override
    protected void init(VaadinRequest request) {


        navigator = new Navigator(this, this);
        navigator.addView("", new UserView(navigator, userRepository, User.class));
        navigator.addView("user", new UserView(navigator, userRepository, User.class));
        navigator.addView("machine", new MachineView(navigator, machineRepository, Machine.class));
        navigator.addView("answer", new AnswerView(navigator, answerRepository, AnswerBase.class));
        navigator.addView("drivingLicenseApplication", new DrivingLicenseApplicationView(navigator, drivingLicenseApplicationRepository, DrivingLicenseApplication.class));

    }
}
