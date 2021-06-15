package runner;

import business_objects.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.InstanceCreator;

public class TestClass extends InstanceCreator {
    @Test
    public void loginSuccessAssert() {
        loginPage.start(user.getMailUrl()).inputUserName(user.getUserName())
                .clickLoginButton()
                .inputPassword(user.getUserPassword())
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
        letterPage.enterAddressee(user.getMailAddress())
                .enterSubject(user.getMailSubject())
                .enterBodyText(user.getMailText())
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
        Assert.assertEquals(draftsLetterPage.verifyAddressee(), user.getMailAddress());
    }

    @Test(dependsOnMethods = {"addresseeAssert"})
    public void mailSentAssert() {
        draftsLetterPage.sendMail().closeLetterSentWindow();
        Assert.assertTrue(draftsLetterPage.verifyMailIsSent());
    }

    @Test (dependsOnMethods = {"mailSentAssert"})
    public void createAndDeleteFolderAssert() {
        folderPage.clickToCreateNewFolder()
                .nameNewFolder(user.getFolderName())
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
