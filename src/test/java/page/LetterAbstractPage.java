package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LetterAbstractPage extends AbstractPage {
    @FindBy(xpath =  "//input[@tabindex=\"100\"]")
    WebElement addresseeInput;
    @FindBy(xpath = "//input[@tabindex=\"400\"]")
    WebElement subject;
    @FindBy(xpath = "//div[@tabindex=\"505\"]")
    WebElement bodyText;
    @FindBy(xpath = "//span[@tabindex=\"580\"]")
    WebElement saveToDraftsButton;
    @FindBy(xpath = "//button[@tabindex=\"700\"]")
    WebElement closeLetterButton;

    public LetterAbstractPage(WebDriver driver) {
        super(driver);
    }

    public LetterAbstractPage enterAddressee(String addressee) {
        waitForElementPresence(addresseeInput);
        addresseeInput.sendKeys(addressee);
        return this;
    }

    public LetterAbstractPage enterSubject(String letterSubject) {
        subject.sendKeys(letterSubject);
        return this;
    }

    public LetterAbstractPage enterBodyText(String mailText) {
        bodyText.sendKeys(mailText);
        return this;
    }

    public LetterAbstractPage saveToDrafts() {
        saveToDraftsButton.click();
        return this;
    }

    public LetterAbstractPage closeLetterPage() {
        closeLetterButton.click();
        return this;
    }

    public boolean isStillOpen() {
        return isElementPresent(closeLetterButton);
    }
}
