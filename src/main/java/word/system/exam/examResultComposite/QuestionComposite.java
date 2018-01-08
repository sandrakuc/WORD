package word.system.exam.examResultComposite;

import java.util.ArrayList;

public class QuestionComposite extends ArrayList<ExamResultComponent> implements ExamResultComponent {


    @Override
    public float getResultInPercent() {

        float suma = 0;
        for(ExamResultComponent component: this) {
            suma = suma + component.getResultInPercent();
        }

        return suma/this.size();
    }
}
