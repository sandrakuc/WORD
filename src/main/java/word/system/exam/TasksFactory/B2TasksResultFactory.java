package word.system.exam.TasksFactory;

import word.system.common.DriveLicenseType;
import word.system.exam.TasksFactory.TasksFactory;
import word.system.exam.maneouver.Maneuver;
import word.system.exam.maneouver.ManeuverResult;
import word.system.exam.question.Question;
import word.system.exam.question.QuestionResult;

import java.util.*;

/**
 * 
 */
public class B2TasksResultFactory implements TasksFactory {

    final int NUMBER_OF_QUESTION_ON_TEORETICAL_EXAM = 5;

    /**
     * Lista wszystkich manewrów dla prawa jazdy b2
     */
    List<Maneuver> maneuvers;


    public B2TasksResultFactory() {
        maneuvers = getManeuvers();
    }

    /**
     * @return
     */
    public List<ManeuverResult> generateManeuverResults() {

        ArrayList<ManeuverResult> maneuverResults = new ArrayList<ManeuverResult>();

        //dla wszystkich manewrów generujemy wyniki wykonania tego manewru
        for(Maneuver maneuver: maneuvers) {
            ManeuverResult maneuverResult = new ManeuverResult();
            maneuverResult.setManeuver(maneuver);
            maneuverResults.add(maneuverResult);
        }

        return maneuverResults;
    }

    /**
     * @return
     */
    public List<QuestionResult> generateQuestionResult() {
        ArrayList<QuestionResult> questionResults = new ArrayList<QuestionResult>();

        for(Question question: getRandomQuestion(NUMBER_OF_QUESTION_ON_TEORETICAL_EXAM)) {
            QuestionResult questionResult = new QuestionResult();
            questionResult.setQuestion(question);
            questionResults.add(questionResult);
        }

        return questionResults;
    }

    /**
     * pobiera z bazy danych liste wszystkich manewrów dla prawa jazdy b2
     * na razie tworze je z palca, ale na pewno będą one przechowywane w bazie, i będzie istniała tylko jedna instancja danego
     * manewru w systemie
     * @return
     */
    protected List<Maneuver> getManeuvers() {
        ArrayList<Maneuver> maneuvers = new ArrayList<Maneuver>();
        maneuvers.add(new Maneuver("parkowanie równoległe", "opis", DriveLicenseType.B2));
        maneuvers.add(new Maneuver("parkowanie prostopadłe", "opis", DriveLicenseType.B2));
        maneuvers.add(new Maneuver("podjazd pod górkę", "opis", DriveLicenseType.B2));
        maneuvers.add(new Maneuver("przejazd przez pasy", "opis", DriveLicenseType.B2));
        maneuvers.add(new Maneuver("przejazd przez skrzyżowanie", "opis", DriveLicenseType.B2));
        return maneuvers;
    }


    /**
     * Pobiera z bazy losowe pytania dla prawa jazdy b2
     * @param number
     * @return
     */
    protected List<Question> getRandomQuestion(int number) {
        ArrayList<Question> questions = new ArrayList<Question>();

        Question question = new Question();
        question.setQuestion("testowe pytanie 123");
        question.setType(DriveLicenseType.B2);
        //@todo odpowiedzi i poprawne odpowiedz


        questions.add(question);

        return questions;
    }

}