package word.system.pkk;

import word.system.common.Address;

import java.util.ArrayList;
import java.util.Date;

public class CityDepartamentEmployee {
    private int id;
    private String name;
    private String surname;
    private Date birthDate;
    private Address address;

    public CityDepartamentEmployee(int id, String name, String surname, Date birthDate, Address address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.address = address;
    }
}


