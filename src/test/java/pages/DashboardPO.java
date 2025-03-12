package pages;

import pageUIs.DashboardPageUI;
import pages.pim.employee.EmployeeListPO;

import static support.BasePage.*;

public class DashboardPO {
    public EmployeeListPO clickToPIMPage() {
        waitForElementClickAble(DashboardPageUI.PIM_LINK);
        clickToElement(DashboardPageUI.PIM_LINK);
        return PageGenerator.getEmployeeListPage();
    }
}
