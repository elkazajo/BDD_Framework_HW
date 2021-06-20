package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DraftsAbstractPage extends AbstractPage {
    @FindBy(xpath = "//a[@href=\"/drafts/\"]")
    WebElement drafts;
    @FindBy(xpath = "//span[@title=\"selenium.tester@mail.ru\"][1]")
    WebElement lastSaved;

    public DraftsAbstractPage(WebDriver driver) {
        super(driver);
    }

    public DraftsAbstractPage openDrafts() {
        drafts.click();
        return this;
    }

    public boolean isInDrafts() {
        waitForElementPresence(lastSaved);
        return isElementPresent(lastSaved);
    }
}
