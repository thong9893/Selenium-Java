package pages.pim.employee;

import org.openqa.selenium.WebDriver;
import pageUIs.EmployeeTabsPageUI;
import pages.PageGenerator;
import support.BasePage;

import static support.BasePage.*;

public class EmployeeTabs extends BasePage {
    public EmployeeTabs(WebDriver driver){
        super(driver);
    }
    public PersonalDetailPage openPersonalDetailPage(){
        waitForElementClickAble(EmployeeTabsPageUI.PERSONAL_DETAIL_LINK);
        clickToElement(EmployeeTabsPageUI.PERSONAL_DETAIL_LINK);
        waitAllLoadingIconInvisible();
        return PageGenerator.getPersonalDetailPage(driver);
    }
    public ContactDetailPage openContactDetailPage(){
        waitForElementClickAble(EmployeeTabsPageUI.CONTACT_DETAIL_LINK);
        clickToElement(EmployeeTabsPageUI.CONTACT_DETAIL_LINK);
        waitAllLoadingIconInvisible();
        return PageGenerator.getContactDetailPage(driver);
    }
    public EmergencyContactPage openEmergencyContactPage(){
        waitForElementClickAble(EmployeeTabsPageUI.EMERGENCY_CONTACT_LINK);
        clickToElement(EmployeeTabsPageUI.EMERGENCY_CONTACT_LINK);
        waitAllLoadingIconInvisible();
        return PageGenerator.getEmergencyContactPage(driver);
    }
}
