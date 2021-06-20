package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MainAbstractPage extends AbstractPage {
    @FindBy(xpath = "//a[@href=\"/compose/\"]")
    WebElement composeLetter;

    @FindBy(xpath = "//input[@tabindex=\"100\"]")
    WebElement addresseeInputXpath;

    public MainAbstractPage(WebDriver driver) {
        super(driver);
    }

    Actions actions = new Actions(getDriver());

    public MainAbstractPage clickToComposeLetter() {
        waitForElementPresence(composeLetter);
        actions.click(composeLetter).build().perform();
        return this;
    }

    public boolean isLetterOpen() {
        waitForElementPresence(addresseeInputXpath);
        return isElementPresent(addresseeInputXpath);
    }
}
