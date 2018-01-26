package word.system.exam;

import word.system.carfactory.Machine;
import word.system.user.User;

import javax.persistence.*;

@Entity
@Table(name="WORD_PRACTIC_EXAM")
public class PracticExam extends AbstractExam {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
    @SequenceGenerator(sequenceName = "word_practic_exam_seq", allocationSize = 1, name = "CUST_SEQ")
    private long id;


    //private Machine machine;

    //public Machine getMachine() {
    //    return machine;
    //}

//    public void setMachine(Machine machine) {
//        this.machine = machine;
//    }


    public User getPkk() {
        return pkkList.get(0);
    }

    public void setPkk(User pkk) {
        pkkList.clear();
        pkkList.add(pkk);
    }

    @Override
    void run() {
        System.out.println("Egzamin praktyczny w toku");
    }

    @Override
    public String toString(){
        return "Egzamin praktyczny";
    }

}
