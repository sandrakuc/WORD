package word.system.carfactory;

abstract public class Machine {
    public float weight, power;
    public String brand, model, plate, colour;
    public int number;

    Machine(float weight, float power, String brand, String model, String plate){
        this.weight = weight;
        this.power = power;
        this.brand = brand;
        this.model = model;
        this.plate = plate;
    }

    public Machine() {

    }

    abstract void showInformations();

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getPower() {
        return power;
    }

    public void setPower(float power) {
        this.power = power;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}
