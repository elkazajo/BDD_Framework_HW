package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import page.LoginPage;
import utils.WebDriverCreator;

public class MailLoginStep {
    WebDriver driver = WebDriverCreator.getDriver();

    @Given("user navigates to the mail page")
    public void navigateToMailPage() {
        new LoginPage(driver).openPage();
    }

    @When("page opens enters username")
    public void enterUserName(String userName) {
        new LoginPage(driver).inputUserName(userName);
    }

    @And("presses enter button")
    public void pressEnterPasswordButton() {
        new LoginPage(driver).enterPasswordButton();
    }

    @And("when the password form appears enters password")
    public void enterPassword(String password) {
        new LoginPage(driver).inputPassword(password);
    }

    @Then("presses login button to enter mail's main page")
    public void login() {
        new LoginPage(driver).clickLoginButton();
    }
}
