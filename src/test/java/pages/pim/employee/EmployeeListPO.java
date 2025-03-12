package pages.pim.employee;

import pageUIs.EmployeeListPageUI;
import pages.PageGenerator;

import static support.BasePage.*;

public class EmployeeListPO {
    public AddNewEmployeePO clickToEmployeeButton() {
        waitForElementClickAble(EmployeeListPageUI.ADD_EMPLOYEE_NAV_BUTTON);
        clickToElement(EmployeeListPageUI.ADD_EMPLOYEE_NAV_BUTTON);
        return PageGenerator.getAddNewEmployeePage();
    }
}
