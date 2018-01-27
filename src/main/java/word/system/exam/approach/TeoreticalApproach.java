package word.system.exam.approach;

import word.system.common.DriveLicenseType;
import word.system.exam.Task.question.Answer;
import word.system.exam.Task.QuestionResult;

import javax.persistence.*;

/**
 * 
 */
@Entity
@Table(name="WORD_TEORETICAL_APPROACH")
public class TeoreticalApproach {

    /**
     * Default constructor
     */
    public TeoreticalApproach() {
    }

    /**
     * 
     */
    @Id @GeneratedValue
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
    //@SequenceGenerator(sequenceName = "word_user_seq", allocationSize = 1, name = "CUST_SEQ")
    Long id;

    protected DriveLicenseType type;

    /**
     * 
     */
    //public Pkk pkk;

    /**
     * 
     */
    //protected TeoreticalExamBuilder teoreticalExam;





    /**
     * @param questionResult 
     * @param answer
     */
    public void chooseAnswer(QuestionResult questionResult, Answer answer) {
        // TODO implement here
    }

    /**
     * 
     */
    public void endApproach() {
        // TODO implement here
    }

}