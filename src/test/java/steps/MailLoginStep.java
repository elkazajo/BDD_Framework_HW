package steps;

import business_object.User;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import page.LoginPage;
import utils.WebDriverCreator;

public class MailLoginStep {
    WebDriver driver;
    LoginPage loginPage;
    User user;

    @Before
    public void setUp() {
        driver = WebDriverCreator.getDriver();
        loginPage = new LoginPage(driver);
        user = new User();
    }

    @Given("user navigates to the mail page")
    public void user_navigates_to_the_mail_page() {
        try {
            loginPage.openPage();
        } catch (io.cucumber.java.PendingException ignored) {

        }
    }

    @When("page opens enters username")
    public void page_opens_enters_username() {
        try {
            loginPage.inputUserName(user.getName());
        } catch (io.cucumber.java.PendingException ignored) {

        }

    }

    @And("presses enter button")
    public void presses_enter_button() {
        try {
            loginPage.enterPasswordButton();
        } catch (io.cucumber.java.PendingException ignored) {

        }
    }

    @And("when the password form appears enters password")
    public void when_the_password_form_appears_enters_password(String password) {
        try {
            loginPage.inputPassword(user.getPassword());
        } catch (io.cucumber.java.PendingException ignored) {

        }
    }

    @Then("presses login button to enter mail's main page")
    public void presses_login_button_to_enter_mail_s_main_page() {
        try {
            loginPage.clickLoginButton();
        } catch (io.cucumber.java.PendingException ignored) {

        }
    }
}
