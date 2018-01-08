package word.system.exam.examResultComposite;

import word.system.exam.Task.question.Answer;

public class AnswerLeaf implements ExamResultComponent {

    protected Answer answer;

    public AnswerLeaf(Answer answer) {
        this.answer = answer;
    }

    @Override
    public float getResultInPercent() {
        return (answer.isCorrect) ? 1 : 0; // nie można konwertować bezpośrendio z boolean do float
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
