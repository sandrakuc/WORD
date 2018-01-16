package word.system.exam;

import word.system.exam.examiners.TeoreticalExaminer;

public class TeoreticalAbstractExam extends AbstractExam
{
    private TeoreticalExaminer teoreticalExaminer;

    public TeoreticalExaminer getTeoreticalExaminer() {
        return teoreticalExaminer;
    }

    public void setTeoreticalExaminer(TeoreticalExaminer teoreticalExaminer) {
        this.teoreticalExaminer = teoreticalExaminer;
    }
}
