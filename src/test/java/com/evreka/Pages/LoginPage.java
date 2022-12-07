package com.evreka.Pages;

import com.evreka.Utilies.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {


    @FindBy(name = "username")
    public WebElement usernameBox;

    @FindBy(name = "password")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@class='login-logo']//p")
    public WebElement loginPageText;

    @FindBy(xpath = "(//label[@class='control-label'])[1]")
    public WebElement usernameLabel;

    @FindBy(xpath = "(//label[@class='control-label'])[2]")
    public WebElement passwordLabel;

    @FindBy(xpath = "//div[@class='icheckbox_square-blue']/..")
    public WebElement rememberMe;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissable alert-link']")
    public WebElement loginErrorMessage;

    public void login(String username, String password) {
        BrowserUtils.waitForVisibility(usernameBox, 15);
        if (usernameBox.getAttribute("value").isEmpty() && passwordBox.getAttribute("value").isEmpty()) {
            usernameBox.sendKeys(username);
            passwordBox.sendKeys(password);
        }else{
            usernameBox.clear();
            usernameBox.sendKeys(username);
            passwordBox.clear();
            passwordBox.sendKeys(password);
        }


    }


}
