package com.evreka.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InboundPage extends BasePage{

    @FindBy(xpath = "//div[contains(text(),'Inbound')]")
    public WebElement inboundHeader;

    @FindBy(xpath = "//button[@data-testid='add_inbound_button']")
    public WebElement addInboundButton;

    @FindBy(xpath = "//div[contains(text(),'Add Inbound')]")
    public WebElement addInboundHeader;

    @FindBy(xpath = "//input[@data-testid='inbound_name']")
    public WebElement nameBoxAddInbound;

    @FindBy(xpath = "(//div[contains(@class,'Select__indicators')])[2]")
    public WebElement facilitySelectButton;

    @FindBy(xpath = "//span[@data-testid='facility_field_0']")
    public WebElement facilityOption;

    @FindBy(xpath = "(//div[contains(@class,'Select__indicators')])[3]")
    public WebElement materialTypeSelectButton;

    @FindBy(xpath = "//span[@data-testid='material_type_field_0']")
    public WebElement materialTypeOption;

    @FindBy(xpath = "//input[@data-testid='gross_weight']")
    public WebElement grossWeightBox;

    @FindBy(xpath = "//input[@data-testid='tare_weight']")
    public WebElement tareWeightBox;

    @FindBy(xpath = "//p[contains(text(),'Edit')]")
    public WebElement treeDotOptionInbound;

    @FindBy(xpath = "//div[contains(text(),'This')]")
    public WebElement availableMessageEditInbound;

    @FindBy(xpath = "//div[contains(text(),'Edit Inbound')]")
    public WebElement editInboundHeader;

    @FindBy(xpath = "//h3[contains(text(),'Delete Inbound')]")
    public WebElement deleteInboundHeader;

    @FindBy(xpath = "//p[contains(text(),'Are')]")
    public WebElement deleteInboundWarningMessage;

    @FindBy(xpath = "//p[contains(text(),'Inbound(s)')]")
    public WebElement deleteSuccessMessage;



















































}
