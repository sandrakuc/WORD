package word.system.exam;

import word.system.carfactory.Machine;
import word.system.user.User;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name="WORD_PRACTIC_EXAM")
public class PracticExam {



    @Id @GeneratedValue
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
    //@SequenceGenerator(sequenceName = "word_practic_exam_seq", allocationSize = 1, name = "CUST_SEQ")
    Long id;

    protected Date date;
    protected String pesel;
    protected ExamResult examResult;

    @ManyToOne
    protected User examiner;

    @ManyToOne
    protected Machine machine;



    public void setExaminer(User examiner){
        if(examiner.getRole().equals(User.Role.PRACTIC_EXAMINER)){
            this.examiner = examiner;
        }
    }

    public void setMachine(Machine machine){
        this.machine = machine;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public Date getDate(){
        return date;
    }

    public User getExaminer(){
        return examiner;
    }

    public Machine getMachine(){
        return machine;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public ExamResult getExamResult() {
        return examResult;
    }

    public void setExamResult(ExamResult examResult) {
        this.examResult = examResult;
    }

    @Override
    public String toString() {

        return  getId() + " " + getDate() + " " + getMachine() + " " + getPesel() + " " + getExamResult() ;

    }
}
