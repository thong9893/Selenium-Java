package pages.pim.employee;

import pageUIs.EmployeeTabsPageUI;
import pages.PageGenerator;

import static support.BasePage.*;

public class EmployeeTabs {
    public PersonalDetailPO openPersonalDetailPage(){
        waitForElementClickAble(EmployeeTabsPageUI.PERSONAL_DETAIL_LINK);
        clickToElement(EmployeeTabsPageUI.PERSONAL_DETAIL_LINK);
        waitAllLoadingIconInvisible();
        return PageGenerator.getPersonalDetailPage();
    }
    public ContactDetailPO openContactDetailPage(){
        waitForElementClickAble(EmployeeTabsPageUI.CONTACT_DETAIL_LINK);
        clickToElement(EmployeeTabsPageUI.CONTACT_DETAIL_LINK);
        waitAllLoadingIconInvisible();
        return PageGenerator.getContactDetailPage();
    }
    public EmergencyContactPO openEmergencyContactPage(){
        waitForElementClickAble(EmployeeTabsPageUI.EMERGENCY_CONTACT_LINK);
        clickToElement(EmployeeTabsPageUI.EMERGENCY_CONTACT_LINK);
        waitAllLoadingIconInvisible();
        return PageGenerator.getEmergencyContactPage();
    }
}
