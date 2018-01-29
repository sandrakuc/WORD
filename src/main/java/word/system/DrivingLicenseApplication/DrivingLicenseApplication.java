package word.system.DrivingLicenseApplication;

import word.system.user.User;
import word.system.pwpw.DrivingLicenseStatus;
import word.system.pwpw.Pwpw;
import word.system.pwpw.PwpwProxy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "WORD_APPLICATION")

public class DrivingLicenseApplication //implements ObservableDriverLicenseApplication
{
    public enum Status {
        SendToPkk,ReadyToGet,InPorcessOfMaking
    }
    @Id @GeneratedValue
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
    //@SequenceGenerator(sequenceName = "word_application_seq", allocationSize = 1, name = "CUST_SEQ")
    Long id;
    String name;
    String surname;
    String address;
    String pesel;
    String category;
    Status status;

    @ManyToOne
    User user;

}
