package word.system.user;

import word.system.common.Address;
import javax.persistence.*;

@Entity
@Table(name = "WORD_USER")
public class User {

    public enum Role {
        PRACTIC_EXAMINER, TEORETICAL_EXAMINER, CITY_DEPARTMENT, PKK
    }

    protected Role role;

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
    @SequenceGenerator(sequenceName = "word_user_seq", allocationSize = 1, name = "CUST_SEQ")
    Long id;

    @ManyToOne
    public Address address;

    public String firstName;

    public String lastName;

    public String login;

    public String password;

    public String email;

}