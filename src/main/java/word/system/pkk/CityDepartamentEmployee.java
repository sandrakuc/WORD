package word.system.pkk;

import word.system.DrivingLicenseApplication.DrivingLicenseApplication;
import word.system.DrivingLicenseApplication.ObservableDriverLicenseApplication;
import word.system.DrivingLicenseApplication.ObserverDrivingLicenseApplication;
import word.system.common.Address;
import word.system.pwpw.DrivingLicenseStatus;

import java.util.Date;

public class CityDepartamentEmployee implements ObserverDrivingLicenseApplication {
    private int id;
    private String name;
    private String surname;
    private String birthDate;
    private String address;
    private DrivingLicenseApplication drivingLicenseApplication;
    private DrivingLicenseStatus drivingLicenseStatus;


    public CityDepartamentEmployee(int id, String name, String surname, String birthDate, String address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.address = address;
    }


    @Override
    public void update(DrivingLicenseStatus drivingLicenseStatus) {
        this.drivingLicenseStatus = drivingLicenseStatus;
        printDrivingLicenseStatus();
    }

    @Override
    public void printDrivingLicenseStatus()
    {
        System.out.println("Status prawa jazdy u urzednika: "+ drivingLicenseStatus);
    }

    public DrivingLicenseStatus setAsReadyToGet()
    {
        return drivingLicenseStatus.ReadyToGet;
    }



    public static void main(String args[])
    {
        DrivingLicenseApplication drivingLicenseApplication = new DrivingLicenseApplication(1);
        Pkk pkk = new Pkk(1, "Jan", "Nowak", "21.01.2000", "Nowa 21");
        CityDepartamentEmployee cityDepartamentEmployee = new CityDepartamentEmployee(1, "Adam", "Kowalczyk", "20.10.1990",
                "Stara 32");
        drivingLicenseApplication.setDrivingLicenseCategory("B2");

        ///zapisanie PKK i urzednika do obserwowania obiektu DrivingLicenseApplication;
        drivingLicenseApplication.attach(pkk);
        drivingLicenseApplication.attach(cityDepartamentEmployee);

        //Przygotowanie wniosku i wyslanie go do PWPW. PWPW zmieni status wniosku zwracajac ten status do DrivingLicenseApplication
        //Status wniosku sie wtedy zmieni co uruchomi notifyObservers() powiadamiajac o zmianie statusu wniosku obsserwatorów
        drivingLicenseApplication.generateApplication(pkk);
        drivingLicenseApplication.sendToPWPW(drivingLicenseApplication);

        //urzednik ma tu juz prawo jazdy i oznacza je jako gotowe do odebrania
        if(drivingLicenseApplication.getDrivingLicenseStatus()==DrivingLicenseStatus.ReadyToGetFromPWPW) {
            System.out.println("Wniosek gotowy w PWPW. Zawiadamiam zdającego");
            drivingLicenseApplication.setDrivingLicenseStatus(DrivingLicenseStatus.ReadyToGet);
            drivingLicenseApplication.notifyPkkOnly();
        }

    }
}


