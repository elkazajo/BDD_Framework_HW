package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class FolderAbstractPage extends AbstractPage {
    @FindBy(xpath = "//div[@class=\"new-folder-btn__button-wrapper\"]")
    WebElement newFolderCreator;

    @FindBy(xpath = "//input[@data-test-id=\"name\"]")
    WebElement newFolderNamingForm;

    @FindBy(xpath = "//button[@data-test-id=\"submit\"]")
    WebElement createNewFolderButton;

    @FindBy(xpath = "//div[@class=\"nav__folder-name__txt\" and text()=\"Test Folder\"]")
    WebElement createdFolder;

    @FindBy(xpath = "//a[@href=\"/tomyself/\"]")
    WebElement sentToMySelf;

    @FindBy(xpath = "//a[@tabindex=\"-1\"][1]")
    WebElement letter;

    @FindBy(xpath = "//div[@class=\"layer__submit-button\"]")
    WebElement folderDeleteButton;

    @FindBy(xpath = "//span[text()=\"Удалить папку\"]")
    WebElement deleteAtContext;

    Actions actions = new Actions(getDriver());

    public FolderAbstractPage(WebDriver driver) {
        super(driver);
    }

    public FolderAbstractPage clickToCreateNewFolder() {
        waitForElementPresence(newFolderCreator);
        actions.click(newFolderCreator).build().perform();
        return this;
    }

    public FolderAbstractPage nameNewFolder(String name) {
        waitForElementPresence(newFolderNamingForm);
        actions.click(newFolderNamingForm).build().perform();
        actions.sendKeys(name).build().perform();
        return this;
    }

    public FolderAbstractPage createNewFolder() {
        actions.click(createNewFolderButton).build().perform();
        return this;
    }

    public FolderAbstractPage openSentToMySelf() {
        actions.click(sentToMySelf).build().perform();
        return this;
    }

    public FolderAbstractPage dragLetterToNewFolder() {
        int x = 52;
        int y = 330;
        waitForElementPresence(letter);
        actions.click(letter).build().perform();
        actions.dragAndDropBy(letter,x, y).build().perform();
        return this;
    }

    public FolderAbstractPage deleteFolder() {
        waitForElementPresence(createdFolder);
        actions.contextClick(createdFolder).perform();
        waitForElementPresence(deleteAtContext);
        deleteAtContext.click();
        waitForElementPresence(folderDeleteButton);
        actions.click(folderDeleteButton).build().perform();
        return this;
    }

    public boolean isFolderDeleted() {
        return isElementPresent(createdFolder);
    }
}
