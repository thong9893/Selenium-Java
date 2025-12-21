package pages;
import org.openqa.selenium.WebDriver;

import pages.pim.employee.*;
public class PageGenerator {
    public static LoginPage getLoginPage(WebDriver driver){
        return new LoginPage(driver);
    }
    public static DashboardPage getDashboardPage(WebDriver driver){
        return new DashboardPage(driver);
    }
    public static AddNewEmployeePage getAddNewEmployeePage(WebDriver driver){
        return new AddNewEmployeePage(driver);
    }
    public static EmployeeListPage getEmployeeListPage(WebDriver driver){
        return new EmployeeListPage(driver);
    }
    public static PersonalDetailPage getPersonalDetailPage(WebDriver driver){
        return new PersonalDetailPage(driver);
    }
    public static ContactDetailPage getContactDetailPage(WebDriver driver){
        return new ContactDetailPage(driver);
    }
    public static EmergencyContactPage getEmergencyContactPage(WebDriver driver){
        return new EmergencyContactPage(driver);
    }

}
