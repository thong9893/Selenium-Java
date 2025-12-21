package specs;

import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.pim.employee.AddNewEmployeePage;
import pages.pim.employee.EmployeeListPage;
import pages.pim.employee.PersonalDetailPage;
import testData.pojoData.EmployeeInfo;
import support.BaseTest;

public class PIM_01_Employee extends BaseTest {
    
    private EmployeeListPage employeeListPage;
    private AddNewEmployeePage addNewEmployeePage;
    private PersonalDetailPage personalDetailPage;
    private String avatarImageName = "HoChiMinh.jpg";
    private EmployeeInfo employeeInfo;
    
    @BeforeClass
    public void initData(){
        employeeInfo = EmployeeInfo.getEmployeeInfo();
        employeeInfo.setFirstName("John");
        employeeInfo.setLastName("Wick");
        employeeInfo.setDriverLicenseNumber("012345678");
        employeeInfo.setLicenseExpiredDate("1999-15-12");
        employeeInfo.setNationality("American");
        employeeInfo.setMaritalStatus("Married");
        employeeInfo.setDateOfBirth("1999-15-03");
        employeeInfo.setGenderStatus("Male");
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
        basePage.uploadMultipleFiles(avatarImageName);
        personalDetailPage.clickToSaveButtonAtProfileContainer();
        Assert.assertTrue(basePage.isSuccessMessageDisplayed());
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

        Assert.assertTrue(basePage.isSuccessMessageDisplayed());
        basePage.waitAllLoadingIconInvisible();

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
    
}
