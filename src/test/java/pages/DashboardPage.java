package pages;

import pageUIs.DashboardPageUI;
import pages.pim.employee.EmployeeListPage;
import support.BasePage;

import static support.BasePage.*;

public class DashboardPage extends BasePage {
    public EmployeeListPage clickToPIMPage() {
        waitForElementClickAble(DashboardPageUI.PIM_LINK);
        clickToElement(DashboardPageUI.PIM_LINK);
        return PageGenerator.getEmployeeListPage();
    }
}
