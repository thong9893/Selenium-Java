package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
    public static WebDriver createDriver(String browser) {
        if (browser == null) {
            throw new IllegalArgumentException("Browser cannot be null");
        }
        String b = browser.trim().toLowerCase();
        switch (b) {
            case "chrome": {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                return new ChromeDriver(options);
            }
            case "firefox":
                return new FirefoxDriver();
            case "edge":
                return new EdgeDriver();
            case "safari":
                return new SafariDriver();
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }
}
