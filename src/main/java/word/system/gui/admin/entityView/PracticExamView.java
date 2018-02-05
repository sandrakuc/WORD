package word.system.gui.admin.entityView;

import com.vaadin.navigator.Navigator;
import word.system.exam.PracticExam;
import word.system.exam.PracticExamRepository;
import word.system.exam.approach.CourseOfExam;
import word.system.exam.approach.CourseOfExamRepository;

public class PracticExamView extends EntityView<PracticExam, PracticExamRepository> {

    public PracticExamView(Navigator navigator, PracticExamRepository repository, Class<PracticExam> practicExamClass) {
        super(navigator, repository, practicExamClass);
    }
}
