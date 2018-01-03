package word.system.exam.Task.taskResultCreator;

import word.system.common.DriveLicenseType;
import word.system.exam.Task.QuestionResult;
import word.system.exam.Task.TaskResult;
import word.system.exam.Task.question.Question;

import java.util.ArrayList;
import java.util.List;

public class BQuestionTaskResultCreator  implements TaskResultCreator {

    final int NUMBER_OF_QUESTION_ON_TEORETICAL_EXAM = 5;

    /**
     * Pobiera z bazy losowe pytania dla prawa jazdy b2
     * @param number
     * @return
     */
    protected List<Question> getRandomQuestion(int number) {
        ArrayList<Question> questions = new ArrayList<>();

        Question question = new Question();
        question.setQuestion("testowe pytanie 123");
        question.setType(DriveLicenseType.B2);
        //@todo odpowiedzi i poprawne odpowiedz

        questions.add(question);
        return questions;
    }

    @Override
    public List<TaskResult> createList() {
        ArrayList<TaskResult> questionResults = new ArrayList<>();

        for(Question question: getRandomQuestion(NUMBER_OF_QUESTION_ON_TEORETICAL_EXAM)) {
            QuestionResult questionResult = new QuestionResult();
            questionResult.setQuestion(question);
            questionResults.add(questionResult);
        }

        return questionResults;
    }
}
