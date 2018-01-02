package word.system.exam.TasksFactory;

import word.system.exam.maneouver.ManeuverResult;
import word.system.exam.question.QuestionResult;

import java.util.*;

/**
 * 
 */
public interface TasksFactory {

    /**
     * @return
     */
    public List<ManeuverResult> generateManeuverResults();

    /**
     * @return
     */
    public List<QuestionResult> generateQuestionResult();

}