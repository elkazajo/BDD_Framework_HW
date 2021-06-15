package utils;

import business_objects.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.*;

public class InstanceCreator {
    protected WebDriver driver;
    protected Actions actions;
    protected User user;
    protected LoginPage loginPage;
    protected MainPage mainPage;
    protected LetterPage letterPage;
    protected DraftsPage draftsPage;
    protected DraftsLetterPage draftsLetterPage;
    protected LogoutPage logoutPage;
    protected FolderPage folderPage;

    @BeforeSuite
    public void instanceCreator() {
        driver = new WebDriverCreator().setDriver();
        actions = new Actions(driver);
        user = new User();
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        letterPage = new LetterPage(driver);
        draftsPage = new DraftsPage(driver);
        draftsLetterPage = new DraftsLetterPage(driver);
        folderPage = new FolderPage(driver);
        logoutPage = new LogoutPage(driver);
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
