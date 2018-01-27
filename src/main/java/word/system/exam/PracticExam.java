package word.system.exam;

import word.system.carfactory.Machine;
import word.system.user.User;

import javax.persistence.*;

@Entity
@Table(name="WORD_PRACTIC_EXAM")
public class PracticExam {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
    @SequenceGenerator(sequenceName = "word_practic_exam_seq", allocationSize = 1, name = "CUST_SEQ")
    Long id;

}
