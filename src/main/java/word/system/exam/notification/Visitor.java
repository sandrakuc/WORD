package word.system.exam.notification;

import word.system.exam.PracticAbstractExam;
import word.system.exam.TeoreticalAbstractExam;

public interface Visitor {

    void visit(TeoreticalAbstractExam exam);
    void visit(PracticAbstractExam exam);
}
