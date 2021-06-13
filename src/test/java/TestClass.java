import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass extends InstanceCreator {
    String URL = "https://mail.ru/";
    String userName = "selenium.tester";
    String userPassword = "PRARppro3*u3";
    String addressee = "selenium.tester@mail.ru";
    String subject = "Hello";
    String bodyText = "Hello World!";
    String folderName = "Test Folder";

    @Test
    public void loginSuccessAssert() {
        loginPage.start(URL).inputUserName(userName)
                .clickLoginButton()
                .inputPassword(userPassword)
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
        letterPage.enterAddressee(addressee)
                .enterSubject(subject)
                .enterBodyText(bodyText)
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
        Assert.assertEquals(draftsLetterPage.verifyAddressee(), addressee);
    }

    @Test(dependsOnMethods = {"addresseeAssert"})
    public void mailSentAssert() {
        draftsLetterPage.sendMail().closeLetterSentWindow();
        Assert.assertTrue(draftsLetterPage.verifyMailIsSent());
    }

    @Test (dependsOnMethods = {"mailSentAssert"})
    public void createAndDeleteFolderAssert() {
        folderPage.clickToCreateNewFolder()
                .nameNewFolder(folderName)
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
