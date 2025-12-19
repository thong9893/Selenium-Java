package pages;

import pageUIs.LoginPageUI;
import support.BasePage;

public class LoginPage extends BasePage {
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
        return PageGenerator.getDashboardPage();
    }
}
