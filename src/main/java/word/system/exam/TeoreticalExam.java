package word.system.exam;

import word.system.exam.examiners.TeoreticalExaminer;
import word.system.exam.notification.Visitor;

public class TeoreticalExam extends AbstractExam
{
    private TeoreticalExaminer teoreticalExaminer;

    public TeoreticalExaminer getTeoreticalExaminer() {
        return teoreticalExaminer;
    }

    public void setTeoreticalExaminer(TeoreticalExaminer teoreticalExaminer) {
        this.teoreticalExaminer = teoreticalExaminer;
    }

    @Override
    void run() {
        System.out.println("Niezaimplementowane jeszcze dzialania zwiazane z obsuga egzaminu teoretycznego");
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString(){
        return "Egzamin teoretyczny";
    }
}
