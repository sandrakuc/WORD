package word.system.exam.approach;

import word.system.exam.TeoreticalQuestions.AnswerBase;
import word.system.user.User;

import javax.persistence.*;

@Entity
@Table(name = "WORD_COURSE_OF_EXAM")
public class CourseOfExam {
    @Id
    @GeneratedValue
    Long id;

    @ManyToOne
    protected AnswerBase answers;

    @ManyToOne
    protected User partcipants;

    void setPartcipants(User pkk){
        if(pkk.getRole().equals(User.Role.PKK))
            partcipants = pkk;
    }

    User getParticipants(){
        return partcipants;
    }

    void setAnswers(AnswerBase answers){
        this.answers = answers;
    }

    AnswerBase getAnswers(){
        return answers;
    }
}
