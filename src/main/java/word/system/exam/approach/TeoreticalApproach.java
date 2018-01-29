package word.system.exam.approach;

import word.system.common.DriveLicenseType;
import word.system.exam.TeoreticalExam;
import word.system.user.User;

import javax.persistence.*;
import java.util.Collection;

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

    @ManyToMany
    protected Collection<User> participants;

    @OneToOne
    protected TeoreticalExam teoreticalExam;

    public void setType(DriveLicenseType type){
        this.type = type;
    }

    public void setTeoreticalExam(TeoreticalExam teoreticalExam){
        this.teoreticalExam = teoreticalExam;
    }

    public void setParticipants(Collection<User> participants ){
        this.participants = participants;
    }

    public void addToParticipants(User pkk){
        if(pkk.getRole().equals(User.Role.PKK)){
            participants.add(pkk);
        }
    }

    public DriveLicenseType getType(){
        return type;
    }

    public TeoreticalExam getTeoreticalExam(){
        return teoreticalExam;
    }

    public Collection<User>  getParticipants(){
        return participants;
    }

    /**
     * @param questionResult 
     * @param answer
     */
    /*public void chooseAnswer(QuestionResult questionResult, Answer answer) {
        // TODO implement here
    }*/

    /**
     * 
     */
    public void endApproach() {
        // TODO implement here
    }

}