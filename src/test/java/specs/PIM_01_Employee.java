package specs;

import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.DashboardPO;
import pages.LoginPO;
import pages.PageGenerator;
import pages.pim.employee.AddNewEmployeePO;
import pages.pim.employee.EmployeeListPO;
import pages.pim.employee.PersonalDetailPO;
import pojoData.EmployeeInfo;
import support.GlobalConstance;

import static support.BasePage.*;

public class PIM_01_Employee {
    private LoginPO loginPage;
    private DashboardPO dashboardPage;
    private EmployeeListPO employeeListPage;
    private AddNewEmployeePO addNewEmployeePage;
    private PersonalDetailPO personalDetailPage;
    private String avatarImageName = "HoChiMinh.jpg";
    private EmployeeInfo employeeInfo;
    @Parameters({"browser"})
    @BeforeClass
    void setup(String browser) {
        openBrowser(browser);
        getURL(GlobalConstance.SITE_URL);
        loginPage = PageGenerator.getLoginPage();
        employeeInfo = EmployeeInfo.getEmployeeInfo();

        employeeInfo.setFirstName("John");
        employeeInfo.setLastName("Wick");
        employeeInfo.setDriverLicenseNumber("012345678");
        employeeInfo.setLicenseExpiredDate("1999-15-12");
        employeeInfo.setNationality("American");
        employeeInfo.setMaritalStatus("Married");
        employeeInfo.setDateOfBirth("1999-15-03");
        employeeInfo.setGenderStatus("Male");

        loginPage.enterToUserNameTextbox(GlobalConstance.ADMIN_USERNAME);
        loginPage.enterToPasswordTextbox(GlobalConstance.ADMIN_PASSWORD);
        dashboardPage = loginPage.clickToLoginButton();
    }
    @Test(priority = 1)
    public void Employee_01_Add_New(){
        employeeListPage = dashboardPage.clickToPIMPage();
        addNewEmployeePage = employeeListPage.clickToEmployeeButton();
        addNewEmployeePage.enterToFirstNameTextbox(employeeInfo.getFirstName());
        addNewEmployeePage.enterToLastNameTextbox(employeeInfo.getLastName());
        employeeInfo.setEmployeeId(addNewEmployeePage.getEmployeeID());
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
        personalDetailPage.enterToFirstNameTextbox(employeeInfo.getFirstName());
        personalDetailPage.enterToLastNameTextbox(employeeInfo.getLastName());

        Assert.assertEquals(personalDetailPage.getEmployeeID(),employeeInfo.getEmployeeId());

        personalDetailPage.setPersonalDetail(employeeInfo);
        personalDetailPage.clickSaveButtonAtPersonalDetailContainer();

        Assert.assertTrue(isSuccessMessageDisplayed());
        waitAllLoadingIconInvisible();

        Assert.assertEquals(personalDetailPage.getFirstNameTextboxValue(),employeeInfo.getFirstName());
        Assert.assertEquals(personalDetailPage.getLastNameTextboxValue(),employeeInfo.getLastName());
        Assert.assertEquals(personalDetailPage.getEmployeeID(),employeeInfo.getEmployeeId());
        Assert.assertEquals(personalDetailPage.getDriverLicenseTextboxValue(),employeeInfo.getDriverLicenseNumber());
        Assert.assertEquals(personalDetailPage.getLicenseExpiredDateTextboxValue(),employeeInfo.getLicenseExpiredDate());
        Assert.assertEquals(personalDetailPage.getNationalityDropdownValue(),employeeInfo.getNationality());
        Assert.assertEquals(personalDetailPage.getMaritalStatusDropdownValue(),employeeInfo.getMaritalStatus());
        Assert.assertEquals(personalDetailPage.getDateOfBirthTextboxValue(),employeeInfo.getDateOfBirth());
        Assert.assertTrue(personalDetailPage.isMaleGenderRadioSelected(employeeInfo.getGenderStatus()));
    }
    @AfterClass
    void tearDown(){
        closeBrowser();
    }
}
