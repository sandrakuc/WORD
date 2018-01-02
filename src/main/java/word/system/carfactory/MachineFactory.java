package word.system.carfactory;

abstract public class MachineFactory {

    abstract public Machine generate(float weight, float power, String brand, String model, String plate);

    public void showGenerationStatus(Machine machine){
        System.out.println("Pojazd został poprawnie wygenerowany!");
        machine.showInformations();
    }
}
