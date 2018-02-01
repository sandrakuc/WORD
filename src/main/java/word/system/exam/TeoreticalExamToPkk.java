package word.system.exam;

import word.system.user.User;

import javax.persistence.*;

@Entity
@Table(name="WORD_TEORETICAL_EXAM_TO_PKK")
public class TeoreticalExamToPkk {

    @Id @GeneratedValue
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
    //@SequenceGenerator(sequenceName = "word_teoretical_exam_seq", allocationSize = 1, name = "CUST_SEQ")
    Long id;

    @ManyToOne
    protected User user;

    @ManyToOne
    protected TeoreticalExam teoreticalExam;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TeoreticalExam getTeoreticalExam() {
        return teoreticalExam;
    }

    public void setTeoreticalExam(TeoreticalExam teoreticalExam) {
        this.teoreticalExam = teoreticalExam;
    }

    @Override
    public String toString() {
        return getId() + " " + getTeoreticalExam()  + " " + getUser();
    }
}
