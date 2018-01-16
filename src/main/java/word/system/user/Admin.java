package word.system.user;
import java.util.Scanner;
import java.util.ArrayList;
import word.system.carfactory.*;
import word.system.exam.*;

public class Admin {
    private Machine machine;
    private MachineDataBaseFascade mdbf;
    private static PracticExam practicExam;
    private static TeoreticalExam teoreticalExam;
    private static ExamCaretaker examCaretaker;

    public Machine getMachine() {
        return machine;
    }

    public Admin(){
        mdbf = new MachineDataBaseFascade();
    }

    public void createMachine(){
        int type;
        float weight, power;
        String plate, brand, model;
        Scanner s = new Scanner(System.in);
        System.out.println("Podaj nr rejestracyjny pojazdu: ");
        plate = s.nextLine();
        System.out.println("Podaj markę i model pojazdu: ");
        brand = s.nextLine();
        model = s.nextLine();
        System.out.println("Podaj wagę pojazdu w tonach: ");
        weight = s.nextFloat();
        System.out.println("Podaj moc w koniach mechanicznych: ");
        power = s.nextFloat();
        System.out.println("Chcesz dodać samochód, czy motocykl?");
        System.out.println("0 - samochód;\n1-motocykl");
        type = s.nextInt();
        switch (type){
            case 0: {
                MachineFactory mf1 = new CarFactory();
                machine = mf1.generate(weight,power, brand,model,plate);
                mf1.showGenerationStatus(machine);
                break;
            }
            case 1: {
                MachineFactory mf1 = new MotorcycleFactory();
                machine = mf1.generate(weight,power, brand,model,plate);
                mf1.showGenerationStatus(machine);
                break;
            }
            default:{
                System.out.println("Tworzenie pojazdu nie powiodło się!");
            }
        }
        updateMachineDatabase();
    }

    void updateMachineDatabase(){
        mdbf.update(machine);
    }

    ArrayList<Machine> getListOfMachine(){
        return mdbf.getAll();
    }

    Machine getMachine(String plate){
        return mdbf.getMachineByPlate(plate);
    }

    static public void main(String arg[]){
        practicExam = new PracticExam();
        examCaretaker = new ExamCaretaker(practicExam);
        practicExam.setState(ExamStatus.Accepted);
        System.out.println(practicExam);
        examCaretaker.saveExamState();
        practicExam.setState(ExamStatus.Rejected);
        System.out.println(practicExam);
        examCaretaker.restoreState();
        System.out.println(practicExam);

        teoreticalExam = new TeoreticalExam();
        examCaretaker = new ExamCaretaker(teoreticalExam);
        teoreticalExam.setState(ExamStatus.Accepted);
        System.out.println(teoreticalExam);
        examCaretaker.saveExamState();
        teoreticalExam.setState(ExamStatus.Rejected);
        System.out.println(teoreticalExam);
        examCaretaker.restoreState();
        System.out.println(teoreticalExam);

    }
}
