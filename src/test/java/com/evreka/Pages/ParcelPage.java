package com.evreka.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ParcelPage extends BasePage {

    @FindBy(xpath = "//div[contains(text(),'Parcel')]")
    public WebElement parcelHeader;

    @FindBy(xpath = "//button[@data-testid='add_parcel_button']")
    public WebElement addParcelButton;

    @FindBy(xpath = "//input[@data-testid='parcel_name']")
    public WebElement parcelNameBox;

    @FindBy(xpath = "(//div[contains(@class,'Select__indicators')])[1]")
    public WebElement parcelTypeSelectButton;

    @FindBy(xpath = "//div[contains(@class,'Select__option')]")
    public List<WebElement> parcelTypeOptions;

    @FindBy(xpath = "(//div[contains(@class,'Select__indicators')])[2]")
    public WebElement collectionSchemeSelectButton;

    @FindBy(xpath = "//span[@data-testid='undefined_0']")
    public WebElement typeOption;

    @FindBy(xpath = "(//div[contains(@class,'Select__indicators')])[4]")
    public WebElement assetTypeSelectButton;

    @FindBy(xpath = "//p[contains(text(),'has been')]")
    public WebElement successMessageParcel;

    @FindBy(xpath = "//div[contains(text(),'Add Parcel')]")
    public WebElement addParcelHeader;

    @FindBy(xpath = "//li[@data-testid]")
    public List<WebElement> seeMoreDetailPageTreeDotOptions;

    @FindBy(xpath = "//div[contains(text(),'Edit Parcel')]")
    public WebElement editParcelHeader;

    @FindBy(xpath = "//input[@data-testid='tare_weight']")
    public WebElement tareWeightBox;

    @FindBy(xpath = "//h3[contains(text(),'Update')]")
    public WebElement updateWeightHeader;

    @FindBy(xpath = "//input[@data-testid='gross_weight']")
    public WebElement grossWeight;

    @FindBy(xpath = "(//p[contains(@class,'sc-dkrF')])[9]")
    public WebElement netWeight;

    @FindBy(xpath = "//h3[contains(text(),'Delete Parcel')]")
    public WebElement deleteParcelHeader;

    @FindBy(xpath = "//p[contains(text(),'Parcel')]")
    public WebElement deleteSuccessMessage;





























}
