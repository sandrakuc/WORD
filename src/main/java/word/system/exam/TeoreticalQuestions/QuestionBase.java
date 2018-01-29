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

    String contents;

    String correctAnswer;

    String possibleAnswers[] = new String[4];


}
