package word.system.exam;

import javax.persistence.*;

@Entity
@Table(name="WORD_TEORETICAL_EXAM")
public class TeoreticalExam extends AbstractExam
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
    @SequenceGenerator(sequenceName = "word_teoretical_exam", allocationSize = 1, name = "CUST_SEQ")
    protected long id;

    private String sala;

    @Override
    void run() {
        System.out.println("Niezaimplementowane jeszcze dzialania zwiazane z obsuga egzaminu teoretycznego");
    }


    @Override
    public String toString(){
        return "Egzamin teoretyczny";
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }
}
