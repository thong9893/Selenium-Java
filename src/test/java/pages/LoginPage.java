package pages;

import org.openqa.selenium.WebDriver;
import pageUIs.LoginPageUI;
import support.BasePage;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver){
        super(driver);
    }
    public void enterToUserNameTextbox(String username) {
        waitForElementVisible(LoginPageUI.USERNAME_TEXTBOX);
        sendKeyToElement(LoginPageUI.USERNAME_TEXTBOX,username);
    }
    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(LoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(LoginPageUI.PASSWORD_TEXTBOX,password);
    }

    public DashboardPage clickToLoginButton() {
        waitForElementClickAble(LoginPageUI.LOGIN_BUTTON);
        clickToElement(LoginPageUI.LOGIN_BUTTON);
        return PageGenerator.getDashboardPage(driver);
    }
        public DashboardPage login(String username, String password){
        enterToUserNameTextbox(username);
        enterToPasswordTextbox(password);
        return clickToLoginButton();
    }
}
