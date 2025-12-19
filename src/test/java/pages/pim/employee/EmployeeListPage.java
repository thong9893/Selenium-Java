package pages.pim.employee;

import pageUIs.EmployeeListPageUI;
import pages.PageGenerator;
import support.BasePage;

import static support.BasePage.*;

public class EmployeeListPage extends BasePage {
    public AddNewEmployeePage clickToEmployeeButton() {
        waitForElementClickAble(EmployeeListPageUI.ADD_EMPLOYEE_NAV_BUTTON);
        clickToElement(EmployeeListPageUI.ADD_EMPLOYEE_NAV_BUTTON);
        return PageGenerator.getAddNewEmployeePage();
    }
}
