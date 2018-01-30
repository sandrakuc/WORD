package word.system.exam.TeoreticalQuestions;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="WORD_QUESTIONS")
public class QuestionBase {

    @Id
    @GeneratedValue
    Long id;

    protected String contents;

    protected String correctAnswer;

    protected String possibleAnswer1;
    protected String possibleAnswer2;
    protected String possibleAnswer3;

    public void setContents(String contents){
        this.contents = contents;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void setPossibleAnswer1(String possibleAnswer1) {
        this.possibleAnswer1 = possibleAnswer1;
    }

    public void setPossibleAnswer2(String possibleAnswer2) {
        this.possibleAnswer2 = possibleAnswer2;
    }

    public void setPossibleAnswer3(String possibleAnswer3) {
        this.possibleAnswer3 = possibleAnswer3;
    }

    public String getContents() {
        return contents;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getPossibleAnswer1() {
        return possibleAnswer1;
    }

    public String getPossibleAnswer2() {
        return possibleAnswer2;
    }

    public String getPossibleAnswer3() {
        return possibleAnswer3;
    }

}
