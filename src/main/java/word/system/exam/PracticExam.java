package word.system.exam;

import word.system.carfactory.Machine;
import word.system.user.User;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="WORD_PRACTIC_EXAM")
public class PracticExam {

    @Id @GeneratedValue
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
    //@SequenceGenerator(sequenceName = "word_practic_exam_seq", allocationSize = 1, name = "CUST_SEQ")
    Long id;

    protected Date date;

    @OneToMany(mappedBy = "User.id")
    protected User examiner;

    @ManyToOne
    protected User pkk;

    public void setExaminer(User examiner) {
        if(examiner.getRole().equals(User.Role.PRACTIC_EXAMINER)){
            this.examiner = examiner;
        }
    }

    public void setPkk(User pkk){
        if(pkk.getRole().equals(User.Role.PKK)){
            this.pkk = pkk;
        }
    }
}
