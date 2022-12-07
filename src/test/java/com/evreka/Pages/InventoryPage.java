package com.evreka.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventoryPage extends BasePage {

    @FindBy(xpath = "//div[contains(text(),'Inventory')]")
    public WebElement inventoryHeader;

    @FindBy(xpath = "//button[@data-testid='add_inventory_record_button']")
    public WebElement addInventoryRecordButton;

    @FindBy(xpath = "(//div[contains(@class,'Select__indicators')])[1]")
    public WebElement materialTypeSelectButton;

    @FindBy(xpath = "//span[@data-testid='material_type_field_0']")
    public WebElement materialTypeOption;

    @FindBy(xpath = "//input[@data-testid='amount']")
    public WebElement amountBox;

    @FindBy(xpath = "//input[@data-testid='capacity']")
    public WebElement capacityBox;

    @FindBy(xpath = "//h3[contains(text(),'Increase Amount')]")
    public WebElement increaseAmountHeader;

    @FindBy(name = "amount")
    public WebElement increaseAmountBox;

    @FindBy(xpath = "//span[contains(text(),'Amount')]")
    public WebElement increaseAmountWarningMessage;

    @FindBy(xpath = "//tr[@role='row']//td[@data-testid='row_0_td_1']")
    public WebElement totalAmountRow;

    @FindBy(xpath = "//h3[contains(text(),'Decrease Amount')]")
    public WebElement decreaseAmountHeader;

    @FindBy(xpath = "//tr[@role='row']//td[@data-testid='row_0_td_5']")
    public WebElement capacityAmountRow;

    @FindBy(xpath = "//span[contains(text(),'Faci')]")
    public WebElement changeCapacityWarningMessage;

    @FindBy(name = "capacity")
    public WebElement changeCapacityInput;

    @FindBy(xpath = "//h3[contains(text(),'Delete Inventory')]")
    public WebElement deleteInventoryHeader;

    @FindBy(xpath = "//p[contains(text(),'Inventory items')]")
    public WebElement deleteSuccessMessage;




}
