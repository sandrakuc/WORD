package word.system.DrivingLicenseApplication;

import word.system.pkk.Pkk;
import word.system.pwpw.DrivingLicenseStatus;
import word.system.pwpw.Pwpw;
import word.system.pwpw.PwpwProxy;
import java.util.ArrayList;
import java.util.List;

public class DrivingLicenseApplication implements ObservableDriverLicenseApplication {
    private int id;
    private static DrivingLicenseStatus drivingLicenseStatus = DrivingLicenseStatus.InProcecessOfMaking;;
    private Pkk pkk;
    private String drivingLicenseCategory;

    private List<ObserverDrivingLicenseApplication> observersList = new ArrayList<ObserverDrivingLicenseApplication>();
    private boolean isChanged;
    DrivingLicenseApplication drivingLicenseApplication;



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

    //-------------------------------METODY WZORCA OBSERVER

    public boolean isChanged() {
        return isChanged;
    }

    public void setChanged(boolean isChanged) {
        this.isChanged = isChanged;
        notifyObservers();
    }

    @Override
    public void attach(ObserverDrivingLicenseApplication obj) {
        observersList.add(obj);
        System.out.println("Obiekt dodany jako obserwator");
    }


    @Override
    public void notifyObservers() {
        for (ObserverDrivingLicenseApplication observer : observersList) {
            System.out.println("\nPowiadamiam obserwatora:   " + observer.toString());
            observer.update(drivingLicenseStatus);
        }
    }
     //----------------METODY WZORCA OBSERVER


        //-------------METODY WZORCA FASADA


    public void sendToPWPW(DrivingLicenseApplication dla)
    {
        Pwpw pwpw = new PwpwProxy();

        //sprawdzanie poprawnosci wniosku
        if(pwpw.verifyApplicationData()==Boolean.TRUE);
        {
            System.out.println("PWPW potwierdziło dane z wniosku");
        }

        //sprawdzenie statusu wniosku
        drivingLicenseStatus = pwpw.getDrivingLicenseStatus(dla.getPkk());

        System.out.println("Status prawa jazdy odebrany z PWPW: " + drivingLicenseStatus);
        System.out.println("Status zmienił sie. Powiadomie o tym obserwatorów (PKK i Urzednika)");


        ///powiadamianie ze jest zmiana
        setChanged(Boolean.TRUE);
    }

    public void generateApplication(Pkk pkk)
    {
        System.out.println("");
        System.out.println("Generuje wniosek o prawo jazdy");
        System.out.println("Imie wnioskodawcy: " + pkk.name);
        System.out.println("Nazwisko wnioskodawcy: " + pkk.surname);
        System.out.println("Adres wnioskodawcy: " + pkk.address);
        System.out.println("Data urodzenia wnioskodawcy: " + pkk.birthDate);
        System.out.println("Prawo jazdy kategorii: "+ getDrivingLicenseCategory());
        System.out.println("");
    }
    //----------------METODY WZORCA FASADA

//    public static void main(String[] args) {
//        DrivingLicenseApplication dla = new DrivingLicenseApplication(1);
//        dla.setDrivingLicenseCategory("B2");
//        Pkk pkk = new Pkk(1,"Marek","Nowak","21.01.1993","Polna 12");
//
//        dla.generateApplication(pkk);
//        dla.sendToPWPW(dla);
//
//        System.out.println("\n\nStatus prawa jazdy w obiekcie 'DrivingLicenseApplication': " + dla.getDrivingLicenseStatus());
//        System.out.println("Status prawa jazdy zmienil sie w tym obiekcie i mozna o tym fakcie poinformowac obserwatorow przy uzyciu wzorca Observer");
//    }


}
