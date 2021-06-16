package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
    @FindBy(xpath = "//input[@name=\"login\"]")
    WebElement loginInputForm;

    @FindBy(xpath = "//button[@data-testid=\"enter-password\"]")
    WebElement loginButton;

    @FindBy(xpath = "//input[@data-testid=\"password-input\"]")
    WebElement passwordInputForm;

    @FindBy(xpath = "//button[@data-testid=\"login-to-mail\"]")
    WebElement enterButton;

    @FindBy(xpath = "//a[@href=\"/compose/\"]")
    WebElement composeLetter;

    Actions actions = new Actions(getDriver());

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage inputUserName(String userName) {
        actions.click(loginInputForm).build().perform();
        actions.sendKeys(userName).build().perform();
        return this;
    }

    public LoginPage enterPasswordButton() {
        actions.click(enterButton).build().perform();
        return this;
    }

    public LoginPage inputPassword(String userPassword) {
        waitForElementPresence(passwordInputForm);
        actions.click(passwordInputForm).build().perform();
        actions.sendKeys(userPassword).build().perform();
        return this;
    }

    public LoginPage clickLoginButton() {
        actions.click(loginButton).build().perform();
        return this;
    }

    public boolean verifyLoginSuccess() {
        waitForElementPresence(composeLetter);
        return isElementPresent(composeLetter);
    }

    @Override
    public LoginPage openPage() {
        return (LoginPage) super.openPage();
    }
}
