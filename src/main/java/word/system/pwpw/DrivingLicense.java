package word.system.pwpw;

import word.system.pkk.Pkk;

public class DrivingLicense {
    private Pkk pkk;
    private String address;
    private String issuingOffice;
    private DrivingLicenseStatus drivingLicenseStatus;

    public DrivingLicense(Pkk pkk, String address, String issuingOffice, DrivingLicenseStatus drivingLicenseStatus) {
        this.pkk = pkk;
        this.address = address;
        this.issuingOffice = issuingOffice;
        this.drivingLicenseStatus = drivingLicenseStatus;
    }

    public Pkk getPkk() {
        return pkk;
    }

    public String getAddress() {
        return address;
    }

    public String getIssuingOffice() {
        return issuingOffice;
    }

    public DrivingLicenseStatus getDrivingLicenseStatus() {
        return drivingLicenseStatus;
    }

    public void setDrivingLicenseStatus(DrivingLicenseStatus drivingLicenseStatus) {
        this.drivingLicenseStatus = drivingLicenseStatus;
    }
}
