package word.system.exam;

import word.system.carfactory.Machine;
import word.system.exam.examiners.PracticalExaminer;
import word.system.exam.notification.Visitor;

public class PracticAbstractExam extends AbstractExam {

    private Machine machine;
    private PracticalExaminer practicalExaminer;

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public PracticalExaminer getPracticalExaminer() {
        return practicalExaminer;
    }

    public void setPracticalExaminer(PracticalExaminer practicalExaminer) {
        this.practicalExaminer = practicalExaminer;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
