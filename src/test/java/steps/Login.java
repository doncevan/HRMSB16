package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.core.config.Configurator;
import org.junit.Assert;
import utils.CommonMethods;
import utils.ConfigReader;
import utils.Log;

public class Login extends CommonMethods {

    @Given("user is navigated to HRMS application")
    public void user_is_navigated_to_hrms_application() {
        //to launch Chrome browser
        openBrowserAndNavigateToURL();
        Configurator.initialize(null, "log4j2.xml");
        Log.startTestCase("My batch 16 test case starts here");
    }

    @When("user enters valid admin username and password")
    public void user_enters_valid_admin_username_and_password() {
        sendText(ConfigReader.getPropertyValue("username"), loginPage.usernameField);
        Log.info("my username has been entered");
        sendText(ConfigReader.getPropertyValue("password"), loginPage.passwordField);
        Log.info("My password has been entered");
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        click(loginPage.loginButton);
    }

    @Then("user is successfully logged in the application")
    public void user_is_successfully_logged_in_the_application() {
        System.out.println("The user successfully logged in");
    }

    @When("user enters ess username and password")
    public void user_enters_ess_username_and_password() {
        sendText("dalima123", loginPage.usernameField);
        sendText("Hum@nhrm123", loginPage.passwordField);
    }

    @When("user enters invalid admin username and password")
    public void user_enters_invalid_admin_username_and_password() {
        sendText("admin123", loginPage.usernameField);
        sendText("Hum#n", loginPage.passwordField);
    }

    @Then("error message is displayed")
    public void error_message_is_displayed() {
        System.out.println("Error message is displayed");
    }

    @When("user enters {string} and {string} and verifying the {string} for the combinations")
    public void user_enters_and_and_verifying_the_for_the_combinations
            (String username, String password, String errorMessageExpected) {
        sendText(username, loginPage.usernameField);
        sendText(password, loginPage.passwordField);
        click(loginPage.loginButton);
        //fetching the error message from the web element
        String errorMessageActual = loginPage.errorMessageField.getText();
        //error message coming from feature file too which we can compare
        Assert.assertEquals("value does not match", errorMessageExpected, errorMessageActual);
        Log.endTestCase("This test case ends here");
    }
}