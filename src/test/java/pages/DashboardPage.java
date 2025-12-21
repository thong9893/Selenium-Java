package pages;

import org.openqa.selenium.WebDriver;
import pageUIs.DashboardPageUI;
import io.qameta.allure.Step;
import pages.pim.employee.EmployeeListPage;
import support.BasePage;

import static support.BasePage.*;

public class DashboardPage extends BasePage {
    public DashboardPage(WebDriver driver){
        super(driver);
    }
    @Step("Navigate to PIM page")
    public EmployeeListPage clickToPIMPage() {
        waitForElementClickAble(DashboardPageUI.PIM_LINK);
        clickToElement(DashboardPageUI.PIM_LINK);
        return PageGenerator.getEmployeeListPage(driver);
    }
}
