package word.system.carfactory;

abstract public class Machine {
    float weight, power;
    String brand, model, plate;

    Machine(float weight, float power, String brand, String model, String plate){
        this.weight = weight;
        this.power = power;
        this.brand = brand;
        this.model = model;
        this.plate = plate;
    }

    abstract void showInformations();



}
