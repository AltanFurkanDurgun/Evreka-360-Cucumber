package com.evreka.Step_Def;

import com.evreka.Pages.HomePage;
import com.evreka.Pages.LoginPage;
import com.evreka.Utilies.BrowserUtils;
import com.evreka.Utilies.ConfigurationReader;
import com.evreka.Utilies.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class LoginStepDef {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    boolean isEmptyUsername;
    boolean isEmptyPassword;

    @Given("User navigate to login page.")
    public void user_navigate_to_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));


    }


    @Then("Verify that the user on the login page.")
    public void verify_that_the_user_on_the_login_page() {
        BrowserUtils.waitForVisibility(loginPage.usernameBox, 15);
        String expectedUrl = ConfigurationReader.get("url");
        String actualUrl = Driver.get().getCurrentUrl();
        System.out.println("expectedUrl = " + expectedUrl);
        System.out.println("actualUrl = " + actualUrl);
        assertEquals(expectedUrl, actualUrl);
    }

    @And("Verify that the user should be see {string} text.")
    public void verifyThatTheUserShouldBeSeeText(String expectedTestLogin) {
        BrowserUtils.waitForVisibility(loginPage.loginPageText, 15);
        String actualTextLogin = loginPage.loginPageText.getText();
        System.out.println("actualTextLogin = " + actualTextLogin);
        assertEquals(expectedTestLogin, actualTextLogin);
    }

    @And("Verify that the user should be see {string} and {string} labels.")
    public void verifyThatTheUserShouldBeSeeAndLabels(String expoectedUsernameLabel, String expectedPasswordLabel) {
        BrowserUtils.waitForVisibility(loginPage.usernameLabel, 15);
        String actualUsernameLabel = loginPage.usernameLabel.getText();
        String actualPasswordLabel = loginPage.passwordLabel.getText();

        assertEquals(expoectedUsernameLabel, actualUsernameLabel);
        assertEquals(expectedPasswordLabel, actualPasswordLabel);
    }

    @And("Verify that the user should be see empty username and empty password box.")
    public void verifyThatTheUserShouldBeSeeEmptyUsernameAndEmptyPasswordBox() {
        assertTrue(loginPage.usernameBox.getAttribute("value").isEmpty());
        assertTrue(loginPage.passwordBox.getAttribute("value").isEmpty());
    }


    @And("Verify that the user should be see {string} and {string} placeholders.")
    public void verifyThatTheUserShouldBeSeeAndPlaceholders(String expectedUserPlaceholder, String expectedPassPlaceholder) {
        String actualUserPlaceholder = loginPage.usernameBox.getAttribute("placeholder");
        String actualPassPlaceholder = loginPage.passwordBox.getAttribute("placeholder");
        assertEquals(expectedUserPlaceholder, actualUserPlaceholder);
        assertEquals(expectedPassPlaceholder, actualPassPlaceholder);
    }

    @When("User can be enter username in username box.")
    public void userCanBeEnterInUsernameBox() {
        loginPage.usernameBox.sendKeys(ConfigurationReader.get("username"));
    }

    @And("User can be enter password in password box.")
    public void userCanBeEnterInPasswordBox() {
        loginPage.passwordBox.sendKeys(ConfigurationReader.get("password"));
    }

    @Then("Verify that the user should be see {string} checkbox text.")
    public void verifyThatTheUserShouldBeSeeCheckboxText(String expectedRememberMeText) {
        BrowserUtils.waitForVisibility(loginPage.rememberMe, 15);
        String actualRememberMeText = loginPage.rememberMe.getText();
        System.out.println("actualRememberMeText = " + actualRememberMeText);
        assertEquals(expectedRememberMeText, actualRememberMeText);

    }

    @And("Verify that the user should see the login button.")
    public void verifyThatTheUserShouldSeeTheLoginButton() {
        BrowserUtils.waitForVisibility(loginPage.loginButton, 15);
        assertTrue(loginPage.loginButton.isDisplayed());
    }

    @When("User can click on login button.")
    public void userCanClickOnLoginButton() {
        BrowserUtils.waitForClickability(loginPage.loginButton, 20);
        loginPage.loginButton.click();

    }

    @Then("Verify that the user should be on the home page.")
    public void verifyThatTheUserShouldBeOnTheHomePage() {
        BrowserUtils.waitForVisibility(homePage.welcomeText, 30);
        String expectedUrl = ConfigurationReader.get("url");
        String actualUrl = Driver.get().getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);

    }

    @And("Verify that the login username should be match the username on the homepage.")
    public void verifyThatTheLoginUsernameShouldBeMatchTheOnTheHomepage() {
        String expectedUsername = ConfigurationReader.get("username");
        String welcomeText = homePage.welcomeText.getText();
        System.out.println("welcomeText = " + welcomeText);
        assertTrue(welcomeText.contains(expectedUsername));

    }


    @When("User input invalid {string} and invalid {string}.")
    public void userInputInvalidAndInvalid(String username, String password) {
        loginPage.login(username,password);
        isEmptyUsername = loginPage.usernameBox.getAttribute("value").isEmpty();
        System.out.println("isEmptyUsername = " + isEmptyUsername);
        isEmptyPassword = loginPage.passwordBox.getAttribute("value").isEmpty();
        System.out.println("isEmptyPassword = " + isEmptyPassword);


    }


    @Then("Verify that the user should be see {string} error message.")
    public void verifyThatTheUserShouldBeSeeErrorMessage(String expectedErrorMessage) {

        if (!isEmptyUsername && !isEmptyPassword) {
            BrowserUtils.waitForVisibility(loginPage.loginErrorMessage, 15);
            String actualInvalidErrorMessage = loginPage.loginErrorMessage.getText();
            System.out.println("actualInvalidErrorMessage = " + actualInvalidErrorMessage);
            assertEquals(expectedErrorMessage, actualInvalidErrorMessage);
        } else if (!isEmptyUsername && isEmptyPassword) {
            String actualPasswordErrorMessage = loginPage.passwordBox.getAttribute("validationMessage");
            System.out.println("actualPasswordErrorMessage = " + actualPasswordErrorMessage);
            assertEquals(expectedErrorMessage, actualPasswordErrorMessage);
        } else {
            String actualUsernameErrorMessage = loginPage.usernameBox.getAttribute("validationMessage");
            System.out.println("actualUsernameErrorMessage = " + actualUsernameErrorMessage);
            assertEquals(expectedErrorMessage, actualUsernameErrorMessage);
        }


    }


}


