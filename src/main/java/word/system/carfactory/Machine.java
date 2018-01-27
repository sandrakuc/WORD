package word.system.carfactory;
import word.system.common.DriveLicenseType;

import  javax.persistence.*;

@Entity
@Table(name = "WORD_MACHINES")
public class Machine {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
    @SequenceGenerator(sequenceName = "word_machines_seq", allocationSize = 1, name = "CUST_SEQ")
    Long id;

    protected float weight;
    protected float power;
    protected String brand;
    protected String model;
    protected String plate;
    protected String colour;
    //protected int number;
    //protected DriveLicenseType dlt;

    Machine(float weight, float power, String brand, String model, String plate){
        this.weight = weight;
        this.power = power;
        this.brand = brand;
        this.model = model;
        this.plate = plate;
    }

    public Machine() {

    }
}
