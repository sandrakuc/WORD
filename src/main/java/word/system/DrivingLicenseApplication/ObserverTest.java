package word.system.DrivingLicenseApplication;

import word.system.pkk.CityDepartamentEmployee;
import word.system.pkk.Pkk;

public class ObserverTest {
    public static void main(String args[])
    {
        DrivingLicenseApplication dla = new DrivingLicenseApplication(1);
        Pkk pkk = new Pkk(1,"Jan","Nowak","21.01.2000","Nowa 21");
        CityDepartamentEmployee cde = new CityDepartamentEmployee(1,"Adam","Kowalczyk","20.10.1990",
                                                                    "Stara 32");
        dla.setDrivingLicenseCategory("B2");

        ///zapisanie PKK i urzednika do obserwowania obiektu DrivingLicenseApplication;
        dla.attach(pkk);
        dla.attach(cde);

        //Przygotowanie wniosku i wyslanie go do PWPW. PWPW zmieni status wniosku zwracajac ten status do DrivingLicenseApplication
        //Status wniosku sie wtedy zmieni co uruchomi notifyObservers() powiadamiajac o zmianie statusu wniosku obsserwatorów
        dla.generateApplication(pkk);
        dla.sendToPWPW(dla);





    }
}
