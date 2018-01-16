package word.system.exam;

import word.system.exam.examiners.TeoreticalExaminer;
import word.system.exam.notification.Visitor;

public class TeoreticalAbstractExam extends AbstractExam
{
    private TeoreticalExaminer teoreticalExaminer;

    public TeoreticalExaminer getTeoreticalExaminer() {
        return teoreticalExaminer;
    }

    public void setTeoreticalExaminer(TeoreticalExaminer teoreticalExaminer) {
        this.teoreticalExaminer = teoreticalExaminer;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
