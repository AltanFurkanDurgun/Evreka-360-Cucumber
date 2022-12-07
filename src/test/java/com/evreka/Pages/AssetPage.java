package com.evreka.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AssetPage extends BasePage {


    @FindBy(xpath = "//div[@id='asset']/..//li")
    public List<WebElement> assetManagementOptions;

    @FindBy(xpath = "//div[contains(text(),'Assets')]")
    public WebElement assetsHeader;

    @FindBy(xpath = "(//button[contains(@class,'sc-ftTHYK')])[1]")
    public WebElement addAssetButton;

    @FindBy(xpath = "//div[contains(text(),'Add Asset')]")
    public WebElement addAssetHeader;

    @FindBy(name = "name")
    public WebElement nameBoxAddAsset;

    @FindBy(xpath = "(//div[contains(@class,'Select__indicators')])[1]")
    public WebElement assetTypeDropDownMenuButton;

    @FindBy(xpath = "//span[contains(@data-testid,'undefined')]")
    public List<WebElement> assetTypeOptions;

    @FindBy(xpath = "//p[contains(text(),'Asset ')]")
    public WebElement successMessageAsset;

    @FindBy(xpath = "//div[contains(text(),'Asset Details')]")
    public WebElement assetDetailsHeader;

    @FindBy(xpath = "//li[@role='menuitem']")
    public WebElement assetDetailsTreeDotMenuOption;

    @FindBy(xpath = "//div[contains(text(),'Edit Asset')]")
    public WebElement editAssetHeader;

    @FindBy(xpath = "(//div[contains(@class,'Select__single')])[1]")
    public WebElement assetTypeInput;

    @FindBy(xpath = "//tr[@role='row']//td[@data-testid='row_0_td_3']")
    public WebElement assetTypeFirstRowTable;

    @FindBy(xpath = "//h3[contains(text(),'Attach Device')]")
    public WebElement attachDeviceHeader;

    @FindBy(xpath = "//span[@data-testid='undefined_7']")
    public WebElement gsmUG03DeviceType;

    @FindBy(xpath = "(//div[contains(@class,'Select__indicators')])[7]")
    public WebElement deviceTypeSelectButton;

    @FindBy(xpath = "//div[contains(@class,'css-ui')]")
    public WebElement deviceIdSearchBox;


    @FindBy(xpath = "(//input[contains(@id,'react-select')])[8]")
    public WebElement deviceIdSearchBoxInput;

    @FindBy(xpath = "(//div[contains(@id,'react-select')])[6]")
    public WebElement deviceIdOption;

    @FindBy(xpath = "//p[contains(text(),'Device')]")
    public WebElement successMessageAttachDevice;

    @FindBy(xpath = "(//div[contains(@class,'sc-jrcTuL')])[5]")
    public WebElement deleteButtonDeviceTable;




























}
