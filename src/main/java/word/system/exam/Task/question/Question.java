package word.system.exam.Task.question;

import word.system.common.DriveLicenseType;

import java.io.File;
import java.util.*;

/**
 * 
 */
public class Question {

    /**
     * Default constructor
     */
    public Question() {
    }

    /**
     * 
     */
    protected String question;

    /**
     * 
     */
    protected File image;

    protected List<Answer> answers;

    protected List<Answer> corectAnswers;

    /**
     * 
     */
    protected DriveLicenseType type;


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public List<Answer> getCorectAnswers() {
        return corectAnswers;
    }

    public void setCorectAnswers(List<Answer> corectAnswers) {
        this.corectAnswers = corectAnswers;
    }

    public DriveLicenseType getType() {
        return type;
    }

    public void setType(DriveLicenseType type) {
        this.type = type;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}