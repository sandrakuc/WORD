package word.system.exam;

import word.system.user.User;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="WORD_TEORETICAL_EXAM")
public class TeoreticalExam
{

    @Id @GeneratedValue
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
    //@SequenceGenerator(sequenceName = "word_teoretical_exam_seq", allocationSize = 1, name = "CUST_SEQ")
    Long id;

    protected Date date;
    protected String room;
    protected TeoreticalExamStatus teoreticalExamStatus;

    @ManyToOne
    protected User examiner;



    public void setExaminer(User examiner){
        if(examiner.getRole().equals(User.Role.TEORETICAL_EXAMINER)){
            this.examiner = examiner;
        }
    }

    public void setDate(Date date){
        this.date = date;
    }

    public Date getDate(){
        return date;
    }


    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public TeoreticalExamStatus getTeoreticalExamStatus() {
        return teoreticalExamStatus;
    }

    public void setTeoreticalExamStatus(TeoreticalExamStatus teoreticalExamStatus) {
        this.teoreticalExamStatus = teoreticalExamStatus;
    }

    public User getExaminer(){
        return examiner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "\n " + getId() + "   examinatorObj:" + getExaminer() + "    Daty: " + getDate()  + "    Pokoj:" + getRoom() + "    StatusEgz:" + getTeoreticalExamStatus();
    }
}
