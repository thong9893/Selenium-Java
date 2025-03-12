package pages.pim.employee;

import pageUIs.AddNewEmployeePageUI;
import pages.PageGenerator;

import static support.BasePage.*;

public class AddNewEmployeePO {
    public void enterToFirstNameTextbox(String firstName) {
        waitForElementVisible(AddNewEmployeePageUI.FIRSTNAME_TEXTBOX);
        sendKeyToElement(AddNewEmployeePageUI.FIRSTNAME_TEXTBOX,firstName);
    }
    public void enterToLastNameTextbox(String lastName) {
        waitForElementVisible(AddNewEmployeePageUI.LASTNAME_TEXTBOX);
        sendKeyToElement(AddNewEmployeePageUI.LASTNAME_TEXTBOX,lastName);
    }
    public String getEmployeeID() {
        waitForElementVisible(AddNewEmployeePageUI.EMPLOYEE_ID_TEXTBOX);
        return getElementAttribute(AddNewEmployeePageUI.EMPLOYEE_ID_TEXTBOX);
    }
    public PersonalDetailPO clickToSaveButtonAtEmployeeContainer() {
        waitForElementClickAble(AddNewEmployeePageUI.SAVE_BUTTON_AT_ADD_EMPLOYEE_CONTAINER);
        clickToElement(AddNewEmployeePageUI.SAVE_BUTTON_AT_ADD_EMPLOYEE_CONTAINER);
        return PageGenerator.getPersonalDetailPage();
    }
}
