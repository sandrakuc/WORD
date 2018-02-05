package word.system.gui.admin.entityView;

import com.vaadin.navigator.Navigator;
import word.system.carfactory.Machine;
import word.system.carfactory.MachineRepository;
import word.system.exam.approach.CourseOfExam;
import word.system.exam.approach.CourseOfExamRepository;

public class CourseOfExamView extends EntityView<CourseOfExam, CourseOfExamRepository> {

    public CourseOfExamView(Navigator navigator, CourseOfExamRepository repository, Class<CourseOfExam> courseOfExamClass) {
        super(navigator, repository, courseOfExamClass);
    }
}
