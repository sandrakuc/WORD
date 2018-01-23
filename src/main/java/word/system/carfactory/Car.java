package word.system.carfactory;

import word.system.common.DriveLicenseType;

public class Car extends Machine {

    public Car() {
        super();

    }

    Car(float weight, float power, String brand, String model, String plate){
        super(weight, power, brand, model, plate);
    }

    @Override
    void showInformations(){
        System.out.println("Typ pojazdu: SAMOCHÓD");
        System.out.println("Kategoria prawa jazdy: " + DriveLicenseType.B2);
        System.out.println("Numer rejestracyjny: " + plate);
        System.out.println("Marka: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Ciężar: " + weight + " ton");
        System.out.println("Moc silnika: " + power + " KM");
    }
}
