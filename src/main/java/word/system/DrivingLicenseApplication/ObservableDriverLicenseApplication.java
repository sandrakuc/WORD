package word.system.DrivingLicenseApplication;

public interface ObservableDriverLicenseApplication
{
    public void attach(ObserverDrivingLicenseApplication obj);

    //method to notify observers of change
    public void notifyObservers();
}
