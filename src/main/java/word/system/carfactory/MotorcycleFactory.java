package word.system.carfactory;

public class MotorcycleFactory extends MachineFactory {
    @Override
    public Machine generate(float weight, float power, String brand, String model, String plate){
        return new Motorcycle(weight, power, brand, model, plate);
    }
}