package support;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import static support.BasePage.driver;

public class BaseTest {
    public static void captureScreenshot(ITestResult testResult){
        Instant instant = Instant.ofEpochMilli(testResult.getStartMillis());
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDate localDate = instant.atZone(zoneId).toLocalDate();

        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(String.format("D:\\Thông\\root_selenium\\src\\main\\java\\FailScreenCapture/%s-%s.png",testResult.getName(),localDate));
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
