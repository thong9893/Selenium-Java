package specs;

import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Description;
import pages.pim.employee.AddNewEmployeePage;
import pages.pim.employee.EmployeeListPage;
import pages.pim.employee.PersonalDetailPage;
import testData.pojoData.EmployeeInfo;
import support.BaseTest;

@Epic("PIM - Employee Management")
@Feature("Employee: Add / Avatar / Personal Details")
@Description("Suite: Verify adding a new employee, uploading avatar and updating personal details.")
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
        addNewEmployeePage = employeeListPage.clickAddEmployeeButton();
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
        personalDetailPage.verifyAvatarUpdated(beforeUpload);

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
        personalDetailPage.verifyPersonalDetails(employeeInfo);

    }
    
}
