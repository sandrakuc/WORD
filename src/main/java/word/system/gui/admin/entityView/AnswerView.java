package word.system.gui.admin.entityView;

import com.vaadin.navigator.Navigator;
import word.system.exam.TeoreticalQuestions.AnswerBase;
import word.system.exam.TeoreticalQuestions.AnswerRepository;

public class AnswerView extends EntityView<AnswerBase, AnswerRepository> {

    public AnswerView(Navigator navigator, AnswerRepository repository, Class<AnswerBase> answerBaseClass) {
        super(navigator, repository, answerBaseClass);
    }
}
