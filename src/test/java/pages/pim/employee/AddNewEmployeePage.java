package pages.pim.employee;

import org.openqa.selenium.WebDriver;
import pageUIs.AddNewEmployeePageUI;
import pages.PageGenerator;
import support.BasePage;
import io.qameta.allure.Step;

import static support.BasePage.*;

public class AddNewEmployeePage extends BasePage {
    public AddNewEmployeePage(WebDriver driver){
        super(driver);
    }
    @Step("Enter first name: {0}")
    public void enterToFirstNameTextbox(String firstName) {
        waitForElementVisible(AddNewEmployeePageUI.FIRSTNAME_TEXTBOX);
        sendKeyToElement(AddNewEmployeePageUI.FIRSTNAME_TEXTBOX,firstName);
    }
    @Step("Enter last name: {0}")
    public void enterToLastNameTextbox(String lastName) {
        waitForElementVisible(AddNewEmployeePageUI.LASTNAME_TEXTBOX);
        sendKeyToElement(AddNewEmployeePageUI.LASTNAME_TEXTBOX,lastName);
    }
    @Step("Get employee ID")
    public String getEmployeeID() {
        waitForElementVisible(AddNewEmployeePageUI.EMPLOYEE_ID_TEXTBOX);
        return getElementAttribute(AddNewEmployeePageUI.EMPLOYEE_ID_TEXTBOX);
    }
    @Step("Click Save on Add Employee container")
    public PersonalDetailPage clickToSaveButtonAtEmployeeContainer() {
        waitForElementClickAble(AddNewEmployeePageUI.SAVE_BUTTON_AT_ADD_EMPLOYEE_CONTAINER);
        clickToElement(AddNewEmployeePageUI.SAVE_BUTTON_AT_ADD_EMPLOYEE_CONTAINER);
        return PageGenerator.getPersonalDetailPage(driver);
    }

    @Step("Enter new employee first name: {0}")
    public void enterNewEmployeeFirstName(String firstName) {
        enterToFirstNameTextbox(firstName);
    }

    @Step("Enter new employee last name: {0}")
    public void enterNewEmployeeLastName(String lastName) {
        enterToLastNameTextbox(lastName);
    }

    @Step("Get generated employee ID")
    public String getNewEmployeeID() {
        return getEmployeeID();
    }

    @Step("Save new employee")
    public PersonalDetailPage saveNewEmployee() {
        return clickToSaveButtonAtEmployeeContainer();
    }
}
