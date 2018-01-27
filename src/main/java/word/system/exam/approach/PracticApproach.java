package word.system.exam.approach;

import word.system.common.DriveLicenseType;

import javax.persistence.*;

/**
 * 
 */
@Entity
@Table(name="WORD_PRACTIC_APPROACH")
public class PracticApproach {

    /**
     * Default constructor
     */
    public PracticApproach() {
    }

    @Id @GeneratedValue
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
    //@SequenceGenerator(sequenceName = "word_user_seq", allocationSize = 1, name = "CUST_SEQ")
    Long id;
    /**
     * 
     */
    //protected File videoOfExam;

    /**
     * 
     */
    protected DriveLicenseType type;

    /**
     * 
     */
    //public Pkk pkk;

    /**
     * 
     */
    //protected PracticExamBuilder practicExam;





}