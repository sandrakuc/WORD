package word.system.exam.Task;

import word.system.exam.Task.question.Answer;
import word.system.exam.Task.question.Question;

import java.util.*;

/**
 * 
 */
public class QuestionResult implements TaskResult {

    boolean result;

    /**
     * Default constructor
     */
    public QuestionResult() {
    }

    protected Question question;

    /**
     * 
     */
    protected List<Answer> chooisedAnswers;




    /**
     * @return
     */
    public boolean isCorrect() {
        // TODO implement here
        return false;
    }

    /**
     * @param answer
     */
    public void addAnswer(Answer answer) {
        // TODO implement here
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public List<Answer> getChooisedAnswers() {
        return chooisedAnswers;
    }

    public void setChooisedAnswers(List<Answer> chooisedAnswers) {
        this.chooisedAnswers = chooisedAnswers;
    }

    @Override
    public boolean getResult() {
        return result;
    }

    @Override
    public void setResult(boolean result) {
        this.result = result;
    }
}