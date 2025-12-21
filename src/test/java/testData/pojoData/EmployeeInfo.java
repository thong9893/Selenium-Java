package testData.pojoData;

public class EmployeeInfo {
    private String employeeId;
    private String firstName;
    private String lastName;
    private String nickName;
    private String ssnNumber;
    private String sinNumber;
    private String dateOfBirth;
    private String genderStatus;
    private String smokerStatus;
    private String nationality;
    private String maritalStatus;
    private String licenseExpiredDate;
    private String driverLicenseNumber;

    public EmployeeInfo() {
    }
    public static EmployeeInfo getEmployeeInfo(){
        return new EmployeeInfo();
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSsnNumber() {
        return ssnNumber;
    }

    public void setSsnNumber(String ssnNumber) {
        this.ssnNumber = ssnNumber;
    }

    public String getSinNumber() {
        return sinNumber;
    }

    public void setSinNumber(String sinNumber) {
        this.sinNumber = sinNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGenderStatus() {
        return genderStatus;
    }

    public void setGenderStatus(String genderStatus) {
        this.genderStatus = genderStatus;
    }

    public String getSmokerStatus() {
        return smokerStatus;
    }

    public void setSmokerStatus(String smokerStatus) {
        this.smokerStatus = smokerStatus;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getLicenseExpiredDate() {
        return licenseExpiredDate;
    }

    public void setLicenseExpiredDate(String licenseExpiredDate) {
        this.licenseExpiredDate = licenseExpiredDate;
    }

    public String getDriverLicenseNumber() {
        return driverLicenseNumber;
    }

    public void setDriverLicenseNumber(String driverLicenseNumber) {
        this.driverLicenseNumber = driverLicenseNumber;
    }
}
