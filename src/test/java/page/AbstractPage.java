package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public abstract class AbstractPage {
    private final WebDriver driver;
    private static final long TIMEOUT_IN_SECONDS = 10;
    private static final long MILLIS = 500;
    private static final String MAIL_URL = "https://mail.ru/";

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public boolean isElementPresent(WebElement element) {
        return element.isDisplayed();
    }

    public void waitForElementPresence(WebElement element) {
        new WebDriverWait(driver, TIMEOUT_IN_SECONDS).pollingEvery(Duration.ofMillis(MILLIS)).until(ExpectedConditions.visibilityOfAllElements(element));
    }

    protected AbstractPage openPage() {
        driver.get(MAIL_URL);
        driver.manage().window().maximize();
        return this;
    }
}
