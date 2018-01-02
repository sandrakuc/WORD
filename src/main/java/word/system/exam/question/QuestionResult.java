package word.system.exam.question;

import java.util.*;

/**
 * 
 */
public class QuestionResult {

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
}