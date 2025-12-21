package support;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import pages.DashboardPage;
import pages.LoginPage;
import pages.PageGenerator;

import java.io.File;

public class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected BasePage basePage;


    @Parameters({"browser"})
    @BeforeClass
    public void setup(String browser){
        driver = DriverFactory.createDriver(browser);
        driver.get(GlobalConstance.SITE_URL);
        basePage = new BasePage(driver);
        loginPage = PageGenerator.getLoginPage(driver);
        dashboardPage = loginPage.login(GlobalConstance.ADMIN_USERNAME, GlobalConstance.ADMIN_PASSWORD);
    }

    @AfterClass
    public void tearDown(){
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeSuite
    public void deleteReportFolder() {
        deleteAllFileInFolder("allure-results");
    }



    private void deleteAllFileInFolder(String folderName) {
        try {
            String pathFolderDownload = GlobalConstance.PROJECT_PATH + File.separator + folderName;
            File file = new File(pathFolderDownload);
            File[] listOfFiles = file.listFiles();
            if (listOfFiles != null && listOfFiles.length > 0) {
                for (File f : listOfFiles) {
                    if (f.isFile() && !"environment.properties".equals(f.getName())) {
                        f.delete();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
