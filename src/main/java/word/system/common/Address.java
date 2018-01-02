package word.system.common;

import java.util.*;

/**
 *
 */
public class Address {


    /**
     * Default constructor
     */
    public Address() {
    }

    /**
     *
     */
    protected String street;

    /**
     *
     */
    protected String city;

    /**
     *
     */
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

    /**
     *
     */
    protected String postalCode;

}
