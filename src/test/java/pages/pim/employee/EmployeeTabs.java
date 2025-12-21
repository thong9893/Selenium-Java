package pages.pim.employee;

import org.openqa.selenium.WebDriver;
import pageUIs.EmployeeTabsPageUI;
import pages.PageGenerator;
import support.BasePage;

import static support.BasePage.*;
import io.qameta.allure.Step;

public class EmployeeTabs extends BasePage {
    public EmployeeTabs(WebDriver driver){
        super(driver);
    }
    @Step("Open Personal Detail tab")
    public PersonalDetailPage openPersonalDetailPage(){
        waitForElementClickAble(EmployeeTabsPageUI.PERSONAL_DETAIL_LINK);
        clickToElement(EmployeeTabsPageUI.PERSONAL_DETAIL_LINK);
        waitAllLoadingIconInvisible();
        return PageGenerator.getPersonalDetailPage(driver);
    }
    @Step("Open Contact Detail tab")
    public ContactDetailPage openContactDetailPage(){
        waitForElementClickAble(EmployeeTabsPageUI.CONTACT_DETAIL_LINK);
        clickToElement(EmployeeTabsPageUI.CONTACT_DETAIL_LINK);
        waitAllLoadingIconInvisible();
        return PageGenerator.getContactDetailPage(driver);
    }
    @Step("Open Emergency Contact tab")
    public EmergencyContactPage openEmergencyContactPage(){
        waitForElementClickAble(EmployeeTabsPageUI.EMERGENCY_CONTACT_LINK);
        clickToElement(EmployeeTabsPageUI.EMERGENCY_CONTACT_LINK);
        waitAllLoadingIconInvisible();
        return PageGenerator.getEmergencyContactPage(driver);
    }
}
