package word.system.exam;

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

    Date date;
}
