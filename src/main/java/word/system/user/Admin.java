package word.system.user;
import java.util.Scanner;
import word.system.carfactory.*;

public class Admin {
    private Machine machine;

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
    } // definicja tej funkcji ma wyłącznie charakter testowy. Zakładam, że za podawanie danych będzie odpowiadało GUI z formularzem.

    //zakładam, że zostanie utworzona baza danych, z której admin będzie korzystał

    //void updateMachineDatabase(Machine machine) throws DatabaseSQLException{}

    //List <Machine> getListOfMachine() throws DatabaseSQLExcpeption{}


}
