package word.system.DrivingLicenseApplication;

import word.system.user.User;
import word.system.pwpw.DrivingLicenseStatus;
import word.system.pwpw.Pwpw;
import word.system.pwpw.PwpwProxy;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "WORD_APPLICATION")

public class DrivingLicenseApplication //implements ObservableDriverLicenseApplication
{

    @Id @GeneratedValue
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
    //@SequenceGenerator(sequenceName = "word_application_seq", allocationSize = 1, name = "CUST_SEQ")
    Long id;
    String name="";
    String surname="";
    String address="";
    String pesel="";
    String category="";

    @ManyToOne
    User user;

    ApplicationStatus status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    //@TODO zmienic tak by w zapytaniu wystarczylo dac samo id usera, aby to zrobic trzeba zmienic CityDepEmployeePanel i tam formatki pozmieniac
    @Override
    public String toString() {
        return "\n" + getId() + " " + getCategory() + " " + getStatus()  + " " + getUser();
    }
}
