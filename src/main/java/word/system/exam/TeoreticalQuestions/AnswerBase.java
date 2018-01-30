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
}
