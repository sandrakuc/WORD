package word.system.common;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "WORD_ADDRESS")
public class Address {

    public Address() {
    }

    @Id @GeneratedValue
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
    //@SequenceGenerator(sequenceName = "word_address_seq", allocationSize = 1, name = "CUST_SEQ")
    @OneToMany(mappedBy = "User.address")
    Long id;

    protected String street;

    protected String city;

    protected String state;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    protected String postalCode;

}
