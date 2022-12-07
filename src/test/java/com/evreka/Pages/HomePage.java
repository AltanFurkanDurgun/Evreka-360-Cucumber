package com.evreka.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "//p[contains(text(),'Welcome')]")
    public WebElement welcomeText;

    @FindBy(id = "engagement")
    public WebElement engagementIcon;

    @FindBy(id = "asset")
    public WebElement assetIcon;

    @FindBy(id = "mrf")
    public WebElement mrfManagementIcon;

    @FindBy(id = "document")
    public WebElement documentIcon;




}
