package specs;

import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DashboardPO;
import pages.LoginPO;
import pages.PageGenerator;
import pages.pim.employee.AddNewEmployeePO;
import pages.pim.employee.EmployeeListPO;
import pages.pim.employee.PersonalDetailPO;
import support.BaseTest;
import support.GlobalConstance;

import static support.BasePage.*;

public class PIM_01_Employee extends BaseTest {
    private LoginPO loginPage;
    private DashboardPO dashboardPage;
    private EmployeeListPO employeeListPage;
    private AddNewEmployeePO addNewEmployeePage;
    private PersonalDetailPO personalDetailPage;
    private String employeeID, firstName, lastName, editFirstName, editLastName;
    private String driverLicenseNumber, licenseExpiredDate, nationality, maritalStatus, dateOfBirth, gender;
    private String avatarImageName = "HoChiMinh.jpg";


    @BeforeClass
    void setup() {
        openBrowser("edge");
        getURL(GlobalConstance.SITE_URL);
        loginPage = PageGenerator.getLoginPage();

        firstName = "John";
        lastName = "Wick";
        editFirstName = "Donal";
        editLastName = "Trump";
        driverLicenseNumber = "012345678";
        licenseExpiredDate = "1999-12-15";
        nationality = "American";
        maritalStatus = "Married";
        dateOfBirth = "1999-03-15";
        gender = "Male";

        loginPage.enterToUserNameTextbox(GlobalConstance.ADMIN_USERNAME);
        loginPage.enterToPasswordTextbox(GlobalConstance.ADMIN_PASSWORD);
        dashboardPage = loginPage.clickToLoginButton();
    }
    @Test(priority = 1)
    public void Employee_01_Add_New(){
        employeeListPage = dashboardPage.clickToPIMPage();
        addNewEmployeePage = employeeListPage.clickToEmployeeButton();
        addNewEmployeePage.enterToFirstNameTextbox(firstName);
        addNewEmployeePage.enterToLastNameTextbox(lastName);
        employeeID = addNewEmployeePage.getEmployeeID();

        personalDetailPage = addNewEmployeePage.clickToSaveButtonAtEmployeeContainer();
    }
    @Test(priority = 2)
    public void Employee_2_Upload_Avatar(){
        personalDetailPage.clickToEmployeeAvatarImage();
        Dimension beforeUpload = personalDetailPage.getAvatarSize();
        uploadMultipleFiles(avatarImageName);
        personalDetailPage.clickToSaveButtonAtProfileContainer();
        Assert.assertTrue(isSuccessMessageDisplayed());
        Assert.assertTrue(personalDetailPage.isProfileAvatarUpdateSuccess(beforeUpload));

    }
    @Test(priority = 3)
    public void Employee_3_Personal_Details(){
        personalDetailPage.openPersonalDetailPage();
        personalDetailPage.enterToFirstNameTextbox(editFirstName);
        personalDetailPage.enterToLastNameTextbox(editLastName);

        Assert.assertEquals(personalDetailPage.getEmployeeID(),employeeID);

        personalDetailPage.enterToDriverLicenseTextbox(driverLicenseNumber);
        personalDetailPage.enterToLicenseExpiredDateTextbox(licenseExpiredDate);
        personalDetailPage.selectNationalityDropdown(nationality);
        personalDetailPage.selectMaritalStatusDropdown(maritalStatus);
        personalDetailPage.enterToDateOfBirthTextbox(dateOfBirth);
        personalDetailPage.selectGenderRadioButton(gender);
        personalDetailPage.clickSaveButtonAtPersonalDetailContainer();

        Assert.assertTrue(isSuccessMessageDisplayed());
        waitAllLoadingIconInvisible();

        Assert.assertEquals(personalDetailPage.getFirstNameTextboxValue(),editFirstName);
        Assert.assertEquals(personalDetailPage.getLastNameTextboxValue(),editLastName);
        Assert.assertEquals(personalDetailPage.getEmployeeID(),employeeID);
        Assert.assertEquals(personalDetailPage.getDriverLicenseTextboxValue(),driverLicenseNumber);
        Assert.assertEquals(personalDetailPage.getLicenseExpiredDateTextboxValue(),licenseExpiredDate);
        Assert.assertEquals(personalDetailPage.getNationalityDropdownValue(),nationality);
        Assert.assertEquals(personalDetailPage.getMaritalStatusDropdownValue(),maritalStatus);
        Assert.assertEquals(personalDetailPage.getDateOfBirthTextboxValue(),dateOfBirth);
        Assert.assertTrue(personalDetailPage.isMaleGenderRadioSelected(gender));
    }
    @AfterClass
    void tearDown(){
        closeBrowser();
    }
}
