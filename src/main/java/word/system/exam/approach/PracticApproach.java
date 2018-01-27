package word.system.exam.approach;

import word.system.common.DriveLicenseType;
import word.system.exam.PracticExam;
import word.system.user.User;

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

    @OneToOne
    protected PracticExam practicExam;

    @ManyToOne
    protected User pkk;

    public void setType(DriveLicenseType type){
        this.type = type;
    }

    public void setPracticExam(PracticExam practicExam){
        this.practicExam = practicExam;
    }

    public void setPkk(User pkk){
        if(pkk.getRole().equals(User.Role.PKK))
            this.pkk = pkk;
    }

    public DriveLicenseType getType(){
        return type;
    }

    public PracticExam getPracticExam(){
        return practicExam;
    }

    public User getPkk(){
        return pkk;
    }


}