package word.system.carfactory;
import word.system.common.DriveLicenseType;

import  javax.persistence.*;

@Entity
@Table(name = "WORD_MACHINES")
public class Machine {

    public enum Type{
        CAR,
        MOTORCYCLE
    }

    @Id @GeneratedValue
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
    //@SequenceGenerator(sequenceName = "word_machines_seq", allocationSize = 1, name = "CUST_SEQ")
    Long id;

    protected float weight;
    protected float power;
    protected String brand;
    protected String model;
    protected String plate;
    protected String colour;
    protected Type type;

    public void setWeight(float weight){
        this.weight = weight;
    }

    public void setPower(float power){
        this.power = power;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }

    public void setModel(String model){
        this.model = model;
    }

    public void setPlate(String plate){
        this.plate = plate;
    }

    public void setColour(String colour){
        this.colour = colour;
    }

    public void setType(Type type){
        this.type = type;
    }

    public float getWeight(){
        return weight;
    }

    public float getPower(){
        return power;
    }

    public String getBrand(){
        return brand;
    }

    public String getModel(){
        return model;
    }

    public String getPlate(){
        return plate;
    }

    public String getColour(){
        return colour;
    }

    public Type getType(){
        return type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "" + getId();
    }
}
