package word.system.exam.TeoreticalQuestions;

import javax.persistence.*;

@Entity
@Table(name="WORD_ANSWERS")
public class AnswerBase {
    @Id
    @GeneratedValue
    Long id;

    @ManyToOne
    QuestionBase question;

    String answer;

    public void setQuestion(QuestionBase question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public QuestionBase getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
