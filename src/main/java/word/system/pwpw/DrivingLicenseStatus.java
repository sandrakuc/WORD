package word.system.pwpw;

import java.util.Random;

public enum DrivingLicenseStatus {
    InProcecessOfMaking,
    ReadyToGetFromPWPW,
    ReadyToGet,
    Received;

    public static DrivingLicenseStatus getRandomDrivingLicenceStatus(){
        DrivingLicenseStatus[] dls = DrivingLicenseStatus.values();
        Random generator = new Random();
        return dls[generator.nextInt(dls.length)];
    }
}
