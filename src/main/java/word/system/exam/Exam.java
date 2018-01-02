package word.system.exam;

import word.system.exam.examiners.PracticalExaminer;
import word.system.exam.examiners.TeoreticalExaminer;
import word.system.pkk.Pkk;

import java.util.ArrayList;
import java.util.Date;

/* Product */
public class Exam {
    private Date examDate;
    private PracticalExaminer practicalExaminer;
    private TeoreticalExaminer teoreticalExaminer;
    private ArrayList<Pkk> pkkList;

    public void setDate(Date examDate) {
        this.examDate=examDate;
    }

    public void setPracticalExaminer (PracticalExaminer practicalExaminer)
    {
        this.practicalExaminer=practicalExaminer;
    }

    public void setTeoreticalExaminer (TeoreticalExaminer teoreticalExaminer)
    {
        this.teoreticalExaminer=teoreticalExaminer;
    }

    public void setPkkList (ArrayList<Pkk> pkkList)
    {
        this.pkkList=pkkList;
    }
}
