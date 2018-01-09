package word.system.user;
import java.util.Scanner;
import java.util.ArrayList;
import word.system.carfactory.*;

public class Admin {
    private Machine machine;
    private MachineDataBaseFascade mdbf;

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
        Admin a = new Admin();
        System.out.println("Witam w panelu administracyjnym");
        while(true){
            int x;
            Scanner s = new Scanner(System.in);
            System.out.println("Co chcesz zrobić: ");
            System.out.println("1 - utworzyć pojazd i dodać go do bazy danych");
            System.out.println("2 - wyszukać pojazd na podstawie tablic rejestracyjnych");
            System.out.println("3 - wyświetlić listę dostępnych pojazdów");
            System.out.println("Inna wartość - zakończenie pracy w panelu");
            x = s.nextInt();
            switch(x){
                case 1: {
                    a.createMachine();
                    break;
                }
                case 2: {
                    String plate;
                    System.out.println("Podaj numer rejestracyjny pojazdu");
                    plate = s.nextLine();
                    plate = s.nextLine();
                    if(a.getMachine(plate)!= null)
                        System.out.println("Marka i model: " + a.getMachine(plate).brand + " " + a.getMachine(plate).model);
                    else
                        System.out.println("Błędny numer rejestracyjny lub brak pojazdu");
                    break;
                }
                case 3: {
                    ArrayList<Machine> machines;
                    machines = a.getListOfMachine();
                    for(int i = 0; i<machines.size(); i++){
                        System.out.println("Pojazd nr " + i);
                        System.out.println("Marka i model: " + machines.get(i).brand + " " + machines.get(i).model);
                        System.out.println("Mumer rejestracyjny: " + machines.get(i).plate);
                    }
                    break;
                }
                default:{
                    System.exit(0);
                }
            }
        }
    }
}
