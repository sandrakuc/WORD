package word.system.carfactory;

public class CarFactory extends MachineFactory {
    @Override
    public Machine generate(float weight, float power, String brand, String model, String plate){
        return new Car(weight, power, brand, model, plate);
    }
}
