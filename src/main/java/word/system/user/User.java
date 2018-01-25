package word.system.user;

import word.system.common.Address;
import javax.persistence.*;

@Entity
@Table(name = "WORD_USER")
public class User {

    public enum Role {
        PRACTIC_EXAMINER, TEORETICAL_EXAMINER, CITY_DEPARTMENT, PKK, ADMIN, CASHEER
    }

    protected Role role;

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
    @SequenceGenerator(sequenceName = "word_user_seq", allocationSize = 1, name = "CUST_SEQ")
    Long id;

    @ManyToOne
    protected Address address;

    protected String firstName;

    protected String lastName;

    protected String login;

    protected String password;

    protected String email;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}