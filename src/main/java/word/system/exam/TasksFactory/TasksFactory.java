package word.system.exam.TasksFactory;

import word.system.exam.Task.ManeuverResult;
import word.system.exam.Task.QuestionResult;

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