package test;

import business_object.Mail;
import business_object.User;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.*;
import singleton_pattern.WebDriverCreator;

public class TestClass {

    private static final String FOLDER_NAME = "Test Folder";
    private static final String MAIL_ADDRESS = "selenium.tester@mail.ru";

    WebDriver driver;
    private User user;
    private Mail mail;
    private LoginAbstractPage loginPage;
    private MainAbstractPage mainPage;
    private LetterAbstractPage letterPage;
    private DraftsAbstractPage draftsPage;
    private DraftsLetterAbstractPage draftsLetterPage;
    private LogoutAbstractPage logoutPage;
    private FolderAbstractPage folderPage;

    @BeforeClass
    public void setUp() {
        driver = WebDriverCreator.getDriver();
        user = new User();
        mail = new Mail();
        loginPage = new LoginAbstractPage(driver);
        mainPage = new MainAbstractPage(driver);
        letterPage = new LetterAbstractPage(driver);
        draftsPage = new DraftsAbstractPage(driver);
        draftsLetterPage = new DraftsLetterAbstractPage(driver);
        folderPage = new FolderAbstractPage(driver);
        logoutPage = new LogoutAbstractPage(driver);
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void loginSuccessAssert() {
        loginPage.openPage().inputUserName(user.getName())
                .clickLoginButton()
                .inputPassword(user.getPassword())
                .enterPasswordButton();
        Assert.assertTrue(loginPage.verifyLoginSuccess());
    }

    @Test(dependsOnMethods = {"loginSuccessAssert"})
    public void clickToComposeLetterAssert() {
        mainPage.clickToComposeLetter();
        Assert.assertTrue(mainPage.isLetterOpen());
    }

    @Test(dependsOnMethods = {"clickToComposeLetterAssert"})
    public void letterCreationAssert() {
        letterPage.enterAddressee(MAIL_ADDRESS)
                .enterSubject(mail.getLetterSubject())
                .enterBodyText(mail.getLetterText())
                .saveToDrafts()
                .closeLetterPage();
        Assert.assertTrue(letterPage.isStillOpen());
    }

    @Test(dependsOnMethods = {"letterCreationAssert"})
    public void letterIsInDraftsAssert() {
        draftsPage.openDrafts();
        Assert.assertTrue(draftsPage.isInDrafts());
    }

    @Test(dependsOnMethods = {"letterIsInDraftsAssert"})
    public void addresseeAssert() {
        draftsLetterPage.openLastSaved();
        Assert.assertEquals(draftsLetterPage.verifyAddressee(), MAIL_ADDRESS);
    }

    @Test(dependsOnMethods = {"addresseeAssert"})
    public void mailSentAssert() {
        draftsLetterPage.sendMail().closeLetterSentWindow();
        Assert.assertTrue(draftsLetterPage.verifyMailIsSent());
    }

    @Test (dependsOnMethods = {"mailSentAssert"})
    public void createAndDeleteFolderAssert() {
        folderPage.clickToCreateNewFolder()
                .nameNewFolder(FOLDER_NAME)
                .createNewFolder()
                .openSentToMySelf()
                .dragLetterToNewFolder()
                .deleteFolder();
        Assert.assertTrue(folderPage.isFolderDeleted());
    }

    @Test(dependsOnMethods = {"createAndDeleteFolderAssert"})
    public void logoutAssert() {
        logoutPage.pressDropdown().pressLogout();
        Assert.assertTrue(logoutPage.isLogout());
    }
}
