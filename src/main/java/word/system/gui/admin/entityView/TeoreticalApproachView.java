package word.system.gui.admin.entityView;

import com.vaadin.navigator.Navigator;
import word.system.exam.TeoreticalQuestions.QuestionBase;
import word.system.exam.TeoreticalQuestions.QuestionRepository;
import word.system.exam.approach.TeoreticalApproach;
import word.system.exam.approach.TeoreticalApproachRepository;

public class TeoreticalApproachView extends EntityView<TeoreticalApproach, TeoreticalApproachRepository> {

    public TeoreticalApproachView(Navigator navigator, TeoreticalApproachRepository repository, Class<TeoreticalApproach> teoreticalApproachClass) {
        super(navigator, repository, teoreticalApproachClass);
    }
}
