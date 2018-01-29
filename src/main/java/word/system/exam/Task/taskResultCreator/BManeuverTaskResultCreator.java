package word.system.exam.Task.taskResultCreator;

import word.system.exam.Task.ManeuverResult;
import word.system.exam.Task.TaskResult;
import word.system.exam.Task.maneouver.Maneuver;
import word.system.common.DriveLicenseType;

import java.util.ArrayList;
import java.util.List;

public class BManeuverTaskResultCreator implements TaskResultCreator {

    /**
     * Lista wszystkich manewrów dla prawa jazdy b2
     */
    List<Maneuver> maneuvers;

    public BManeuverTaskResultCreator() {
        maneuvers = getManeuvers();
    }

    @Override
    public List<TaskResult> createList() {
        ArrayList<TaskResult> taskResults = new ArrayList<>();

        //dla wszystkich manewrów generujemy wyniki wykonania tego manewru
        for(Maneuver maneuver: maneuvers) {
            ManeuverResult maneuverResult = new ManeuverResult();
            maneuverResult.setManeuver(maneuver);
            taskResults.add(maneuverResult);
        }

        return taskResults;
    }

    /**
     * pobiera z bazy danych liste wszystkich manewrów dla prawa jazdy b2
     * na razie tworze je z palca, ale na pewno będą one przechowywane w bazie, i będzie istniała tylko jedna instancja danego
     * manewru w systemie
     * @return
     */
    protected List<Maneuver> getManeuvers() {
        ArrayList<Maneuver> maneuvers = new ArrayList<>();
        maneuvers.add(new Maneuver("parkowanie równoległe", "opis", DriveLicenseType.B));
        maneuvers.add(new Maneuver("parkowanie prostopadłe", "opis", DriveLicenseType.B));
        maneuvers.add(new Maneuver("podjazd pod górkę", "opis", DriveLicenseType.B));
        maneuvers.add(new Maneuver("przejazd przez pasy", "opis", DriveLicenseType.B));
        maneuvers.add(new Maneuver("przejazd przez skrzyżowanie", "opis", DriveLicenseType.B));
        return maneuvers;
    }
}
