package support;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageUIs.BasePageUI;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePage {
    public static WebDriverWait wait;
    public static WebDriver driver;
    public static ChromeOptions options;
    public static void openBrowser(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            options = new ChromeOptions();
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        } else {
            throw new IllegalArgumentException("unexpectedValue" + browser);
        }
        wait = new WebDriverWait(driver, Duration.ofMillis(20000));
    }
    public static WebDriverWait getWait(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstance.LONG_TIMEOUT));
        return wait;
    }
    public static void waitForElementVisible(String locator){
        getWait().until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
    }
    public static boolean waitForListElementInVisible(String locator){
       return getWait().until(ExpectedConditions.invisibilityOfAllElements(getListElement((locator))));
    }
    public static void waitForElementClickAble(String locator ,String...elementName){
        getWait().until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicString(locator,elementName))));
    }
    public static void waitForElementSelected(String locator, String...elementName){
        getWait().until(ExpectedConditions.elementToBeSelected(getByLocator(getDynamicString(locator,elementName))));
    }
    public static boolean waitAllLoadingIconInvisible(){
       return waitForListElementInVisible(BasePageUI.LOADING_ICON);
    }
    public static void sendKeyToElement(String locator, String keyToSend){
        Keys key = null;
        if(GlobalConstance.OS_NAME.toLowerCase().contains(("windows"))){
            key = Keys.CONTROL;
        }else {
            key = Keys.COMMAND;
        }
        sleepInSecond(1);
        getElement(locator).sendKeys(Keys.chord(key,"a",Keys.BACK_SPACE));
        getElement(locator).sendKeys(keyToSend);
    }
    public static void clickToElement(String locator){
        driver.findElement(getByLocator(locator)).click();
    }
    public static String getDynamicString(String locator, String...name){
        return String.format(locator,name);
    }
    public static List<WebElement> getListElement(String locator){
        List<WebElement> listElement = driver.findElements(getByLocator(locator));
        return  listElement;
    }
    public static String getElementText(String locator){
        return getElement(locator).getText();
    }
    public static WebElement getElement(String locator){
        return  driver.findElement(getByLocator(locator));
    }
    public static String getElementAttribute(String locator){
        return driver.findElement(getByLocator(getDynamicString(locator))).getAttribute("value");
    }
    public static void uploadMultipleFiles(String... fileName){
        String filePath = GlobalConstance.UPLOAD_PATH;
        String fullFileName = "";

        for (String file: fileName) {
            fullFileName += filePath + file + "\n";
        }

        fullFileName = fullFileName.trim();
        getElement(BasePageUI.UPLOAD_FILE_TYPE).sendKeys(fullFileName);
    }
    public static Dimension getElementSize(String locator){
        return getElement(locator).getSize();
    }

    public static By getByLocator(String locatorType){
        if(locatorType == null || locatorType.isEmpty()){
            throw new RuntimeException("Locator cannot be null or empty ");
        }
        String type = locatorType.toLowerCase();
        if (type.startsWith("id=")){
            return By.id(locatorType.substring(3));
        }
        if (type.startsWith("class=")){
            return By.className(locatorType.substring(6));
        }
        if (type.startsWith("name=")){
            return By.name(locatorType.substring(5));
        }
        if (type.startsWith("css=")){
            return By.cssSelector(locatorType.substring(4));
        }
        if (type.startsWith("xpath=")){
            return By.xpath(locatorType.substring(6));
        }
        else {
            throw new RuntimeException("Locator type is not support !");
        }
    }
    public static boolean isSuccessMessageDisplayed() {
        waitForElementVisible(BasePageUI.SUCCESS_MESSAGE);
        return isElementDisPlayed(BasePageUI.SUCCESS_MESSAGE);
    }
    public static void selectItemInCustomDropdown(String parentLocator, String childLocator, String expectedItem){
        getElement((parentLocator)).click();
        wait = new WebDriverWait(driver,Duration.ofSeconds(GlobalConstance.LONG_TIMEOUT));
        sleepInSecond(1);
        List<WebElement> allItems = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childLocator)));
        sleepInSecond(1);
        for (WebElement item :allItems) {
            if (item.getText().trim().equals(expectedItem)){
                item.click();
                break;
            }
        }
    }
    public static void sleepInSecond(long time){
        try {
            Thread.sleep(time * 1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public static boolean isElementSelected(String locator,String elementName){
        return getElement(getDynamicString(locator,elementName)).isSelected();
    }
    public static void clickToElementByJS(String locator,String elementName) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(getDynamicString(locator,elementName)));
        sleepInSecond(1);
    }
    public static void closeBrowser(){
        driver.quit();
    }
    public static void getURL(String url){
        driver.get(url);
    }
    public static boolean isElementDisPlayed(String locator){
        if (driver.findElements(getByLocator(locator)).size() > 0){
            return true;
        }
        return false;
    }
    public static String getElementAttribute(String locator, String attributeName){
        return  getElement(locator).getAttribute(attributeName);
    }
    public static void overrideGlobalTimeout(long timeOut){
        driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
    }
}
