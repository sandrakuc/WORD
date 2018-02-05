package word.system.gui.admin.entityView;

import com.vaadin.navigator.Navigator;
import word.system.exam.TeoreticalExam;
import word.system.exam.TeoreticalExamRepository;
import word.system.exam.TeoreticalQuestions.QuestionBase;
import word.system.exam.TeoreticalQuestions.QuestionRepository;

public class TeoreticalExamView extends EntityView<TeoreticalExam, TeoreticalExamRepository> {
    public TeoreticalExamView(Navigator navigator, TeoreticalExamRepository repository, Class<TeoreticalExam> teoreticalExamClass) {
        super(navigator, repository, teoreticalExamClass);
    }
}
