package com.evreka.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SettingsPage extends BasePage {


    @FindBy(xpath = "(//button[@type='button'])[1]")
    public WebElement addMaterialButton;

    @FindBy(xpath = "//h3[contains(text(),'Add Material')]")
    public WebElement addMaterialHeader;

    @FindBy(name = "name")
    public WebElement materialNameNox;

    @FindBy(name = "weighing_percentage")
    public WebElement weightingPercentageBox;

    @FindBy(xpath = "//div[contains(text(),'Settings')]")
    public WebElement settingsHeader;

    @FindBy(xpath = "//h3[contains(text(),'Edit Material')]")
    public WebElement editMaterialHeader;

    @FindBy(xpath = "//h3[contains(text(),'Delete Material')]")
    public WebElement deleteMaterialHeader;

    @FindBy(xpath = "//p[contains(text(),'Material(s)')]")
    public WebElement deleteSuccessMessage;


}
