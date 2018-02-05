package word.system.gui.admin.entityView;

import com.vaadin.navigator.Navigator;
import word.system.exam.approach.CourseOfExam;
import word.system.exam.approach.CourseOfExamRepository;
import word.system.exam.approach.PracticApproach;
import word.system.exam.approach.PracticApproachRepository;

public class PracticApproachView extends EntityView<PracticApproach, PracticApproachRepository> {
    public PracticApproachView(Navigator navigator, PracticApproachRepository repository, Class<PracticApproach> practicApproachClass) {
        super(navigator, repository, practicApproachClass);
    }
}
