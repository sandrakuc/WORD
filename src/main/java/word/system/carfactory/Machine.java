package word.system.carfactory;
import word.system.common.DriveLicenseType;

import  javax.persistence.*;

@Entity
@Table(name = "WORD_MACHINES")
public class Machine {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
    @SequenceGenerator(sequenceName = "word_machines_seq", allocationSize = 1, name = "CUST_SEQ")
    protected long id;
    protected float weight;
    protected float power;
    protected String brand;
    protected String model;
    protected String plate;
    protected String colour;
    protected int number;
    protected DriveLicenseType dlt;

    Machine(float weight, float power, String brand, String model, String plate){
        this.weight = weight;
        this.power = power;
        this.brand = brand;
        this.model = model;
        this.plate = plate;
    }

    public Machine() {

    }

    void showInformations(){
        System.out.println("Kategoria prawa jazdy: " + dlt);
        System.out.println("Numer rejestracyjny: " + plate);
        System.out.println("Marka: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Ciężar: " + weight + " ton");
        System.out.println("Moc silnika: " + power + " KM");
    }

    public DriveLicenseType getDlt() {
        return dlt;
    }

    public void setDlt(DriveLicenseType dlt){
        this.dlt = dlt;
    }

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
