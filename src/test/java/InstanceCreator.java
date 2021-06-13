import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.*;
import utils.WebDriverCreator;

public class InstanceCreator {
    WebDriver driver;
    Actions actions;
    LoginPage loginPage;
    MainPage mainPage;
    LetterPage letterPage;
    DraftsPage draftsPage;
    DraftsLetterPage draftsLetterPage;
    LogoutPage logoutPage;
    FolderPage folderPage;

    @BeforeSuite
    public void instanceCreator() {
        driver = new WebDriverCreator().setDriver();
        actions = new Actions(driver);
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
