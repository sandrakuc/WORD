package word.system.exam.notification;

import word.system.exam.PracticExam;
import word.system.exam.TeoreticalExam;

public interface Visitor {

    void visit(TeoreticalExam exam);
    void visit(PracticExam exam);
}
