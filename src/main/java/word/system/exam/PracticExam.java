package word.system.exam;

import word.system.carfactory.Machine;
import word.system.exam.examiners.PracticalExaminer;
import word.system.exam.notification.Visitor;
import word.system.pkk.Pkk;

public class PracticExam extends AbstractExam {

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

    public Pkk getPkk() {
        return pkkList.get(0);
    }

    public void setPkk(Pkk pkk) {
        pkkList.clear();
        pkkList.add(pkk);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
