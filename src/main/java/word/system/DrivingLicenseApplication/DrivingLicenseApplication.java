package word.system.DrivingLicenseApplication;

import word.system.pkk.Pkk;
import word.system.pwpw.DrivingLicense;
import word.system.pwpw.DrivingLicenseStatus;
import word.system.pwpw.PwpwFascade;

public class DrivingLicenseApplication {
    private int id;
    private static DrivingLicenseStatus drivingLicenseStatus = DrivingLicenseStatus.InProcecessOfMaking;;
    private Pkk pkk;
    private String drivingLicenseCategory;

    public DrivingLicenseApplication(int id) {
        this.id = id;
    }

    public DrivingLicenseStatus getDrivingLicenseStatus() {
        return drivingLicenseStatus;
    }

    public String getDrivingLicenseCategory() {
        return drivingLicenseCategory;
    }

    public void setDrivingLicenseCategory(String drivingLicenseCategory) {
        this.drivingLicenseCategory = drivingLicenseCategory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pkk getPkk() {
        return pkk;
    }

    public void sendToPWPW(DrivingLicenseApplication dla)
    {
        PwpwFascade pwpwFascade = new PwpwFascade();

        //sprawdzanie poprawnosci wniosku
        if( pwpwFascade.verifyApplicationData(pkk)==Boolean.TRUE );
        {
            System.out.println("PWPW potwierdziło dane z wniosku");
        }

        //sprawdzenie statusu wniosku
        drivingLicenseStatus = pwpwFascade.checkAvaliable(dla.getPkk());
        switch (drivingLicenseStatus)
        {

            case InProcecessOfMaking:
                System.out.println("PWPW tworzy prawo jazdy");
                drivingLicenseStatus = DrivingLicenseStatus.InProcecessOfMaking;
                break;
            case ReadyToGetFromPWPW:
                System.out.println("PWPW utworzyło prawo jazdy");
                drivingLicenseStatus = DrivingLicenseStatus.ReadyToGetFromPWPW;
                break;
            case ReadyToGet:
                System.out.println("Prawo jazdy gotowe do odebrania");
                drivingLicenseStatus = DrivingLicenseStatus.ReadyToGet;
                break;
            case Received:
                System.out.println("Prawo jazdy odebrane");
                drivingLicenseStatus = DrivingLicenseStatus.Received;
                break;

                ///status wniosku ustawiony. W innej metodzie mozna uzyc wzorca observer
               //do poinformowania obserwujacych o zmianie stanu obiektu
        }


    }

    public void generateApplication(Pkk pkk)
    {
        System.out.println("Generuje wniosek o prawo jazdy");
        System.out.println("Imie wnioskodawcy: " + pkk.name);
        System.out.println("Nazwisko wnioskodawcy: " + pkk.surname);
        System.out.println("Adres wnioskodawcy: " + pkk.address);
        System.out.println("Data urodzenia wnioskodawcy: " + pkk.birthDate);
        System.out.println("Prawo jazdy kategorii: "+ getDrivingLicenseCategory());
        System.out.println("");
    }

    public static void main(String[] args) {
        DrivingLicenseApplication dla = new DrivingLicenseApplication(1);
        dla.setDrivingLicenseCategory("B2");
        Pkk pkk = new Pkk(1,"Marek","Nowak","21.01.1993","Polna 12");

        dla.generateApplication(pkk);
        dla.sendToPWPW(dla);
    }
}
