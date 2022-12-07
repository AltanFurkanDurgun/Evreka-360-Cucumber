package com.evreka.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PricingEnginePage extends BasePage {

    @FindBy(xpath = "//div[contains(text(),'Pricing')]")
    public WebElement pricingEngineHeader;

    @FindBy(xpath = "//button[@data-testid='add_price_button']")
    public WebElement addPriceButton;

    @FindBy(xpath = "//h3[contains(text(),'Add Price')]")
    public WebElement addPriceHeader;

    @FindBy(xpath = "(//input[contains(@id,'react-select')])[5]")
    public WebElement entityNameBoxAddPrice;

    @FindBy(xpath = "(//div[contains(@class,'Select__indicators')])[5]")
    public WebElement orderTypeAddPrice;

    @FindBy(xpath = "//span[@data-testid='undefined_1']")
    public WebElement producerOrderAddPrice;

    @FindBy(xpath = "(//div[contains(@class,'Select__indicators')])[6]")
    public WebElement orderItemAddPrice;

    @FindBy(xpath = "(//input[contains(@class,'Select__input')])[4]")
    public WebElement orderTypeInputEditPrice;

    @FindBy(xpath = "(//input[contains(@class,'Select__input')])[5]")
    public WebElement orderItemInputEditPrice;

    @FindBy(xpath = "//span[@data-testid='undefined_0']")
    public WebElement orderItemFirstOptAddPrice;

    @FindBy(xpath = "//input[@name='price']")
    public WebElement unitPriceBox;

    @FindBy(xpath = "//input[@name='market_share']")
    public WebElement marketShareBox;

    @FindBy(xpath = "//div[@id='react-select-6-option-0']")
    public WebElement entityFirstOptionAddPrice;

    @FindBy(xpath = "//tr[@role='row']//td[@data-testid='row_0_td_5']")
    public WebElement creationTimeRow;

    @FindBy(xpath = "//h3[contains(text(),'Price')]")
    public WebElement editPriceHeader;

    @FindBy(xpath = "//tr[@role='row']//td[@data-testid='row_0_td_6']")
    public WebElement lastUpdateTimeRow;

    @FindBy(xpath = "//div[contains(@class,'sc-csDkEv')]")
    public WebElement priceHistoryCloseButton;

    @FindBy(xpath = "//div[contains(@class,'sc-gMHJKX')]//span")
    public List<WebElement> unitPriceAndEditedPrice;

    @FindBy(xpath = "//tr[@role='row']//td[@data-testid='row_0_td_3']")
    public WebElement unitPriceRow;











}
