package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class FolderPage extends AbstractPage {
    @FindBy(xpath = "//div[@class=\"new-folder-btn__button-wrapper\"]")
    WebElement newFolder;

    @FindBy(xpath = "//input[@data-test-id=\"name\"]")
    WebElement newFolderName;

    @FindBy(xpath = "//button[@data-test-id=\"submit\"]")
    WebElement createNewFolder;

    @FindBy(xpath = "//div[@class=\"nav__folder-name__txt\" and text()=\"Test Folder\"]")
    WebElement firstNewlyCreatedFolder;

    @FindBy(xpath = "//a[@href=\"/tomyself/\"]")
    WebElement sentToMySelf;

    @FindBy(xpath = "//div[@class=\"llct__content llct__content_unread\"]")
    WebElement letter;

    @FindBy(xpath = "//div[@class=\"layer__submit-button\"]")
    WebElement folderDeleteButton;

    @FindBy(xpath = "//span[text()=\"Удалить папку\"]")
    WebElement deleteAtContext;

    public FolderPage(WebDriver driver) {
        super(driver);
    }

    public FolderPage clickToCreateNewFolder() {
        waitForElementPresence(newFolder);
        actions.click(newFolder).build().perform();
        return this;
    }

    public FolderPage nameNewFolder(String name) {
        waitForElementPresence(newFolderName);
        actions.click(newFolderName).build().perform();
        actions.sendKeys(name).build().perform();
        return this;
    }

    public FolderPage createNewFolder() {
        actions.click(createNewFolder).build().perform();
        return this;
    }

    public FolderPage openSentToMySelf() {
        actions.click(sentToMySelf).build().perform();
        return this;
    }

    public FolderPage dragLetterToNewFolder() {
        waitForElementPresence(letter);
        actions.click(letter).build().perform();
        actions.dragAndDrop(letter, firstNewlyCreatedFolder);
        return this;
    }

    public FolderPage deleteFolder() {
        actions.contextClick(firstNewlyCreatedFolder).perform();
        waitForElementPresence(deleteAtContext);
        deleteAtContext.click();
        waitForElementPresence(folderDeleteButton);
        actions.click(folderDeleteButton).build().perform();
        return this;
    }

    public boolean isFolderDeleted() {
        return isElementPresent(firstNewlyCreatedFolder);
    }
}
