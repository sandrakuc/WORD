package word.system.gui.admin.entityView;

import com.vaadin.navigator.Navigator;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import word.system.exam.PracticExam;
import word.system.exam.PracticExamRepository;
import word.system.exam.TeoreticalQuestions.QuestionBase;
import word.system.exam.TeoreticalQuestions.QuestionRepository;

public class QuestionView extends EntityView<QuestionBase, QuestionRepository> {
    public QuestionView(Navigator navigator, QuestionRepository repository, Class<QuestionBase> questionBaseClass) {
        super(navigator, repository, questionBaseClass);
    }
}
