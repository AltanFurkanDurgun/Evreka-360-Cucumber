package com.evreka.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllocationPage extends BasePage {

    @FindBy(xpath = "(//div[contains(text(),'Allocation')])[1]")
    public WebElement allocationHeader;

    @FindBy(xpath = "//button[@data-testid='add_consignment_button']")
    public WebElement addAllocationButton;

    @FindBy(xpath = "(//div[contains(text(),'Add Allocation')])[1]")
    public WebElement addAllocationHeader;

    @FindBy(xpath = "//input[@data-testid='consignment_name']")
    public WebElement allocationNameBox;

    @FindBy(xpath = "(//div[contains(@class,'Select__indicators')])[1]")
    public WebElement allocationTypeSelectButton;

    @FindBy(xpath = "//span[@data-testid='consignment_type_field_0']")
    public WebElement allocationTypeOption;

    @FindBy(xpath = "(//div[contains(@class,'Select__indicators')])[3]")
    public WebElement materialTypeSelectButton;

    @FindBy(xpath = "//span[@data-testid='undefined_0']")
    public WebElement materialTypeFirstOption;

    @FindBy(xpath = "//div[contains(text(),'If left')]")
    public WebElement plannedWeightWarningMessage;

    @FindBy(xpath = "//p[contains(text(),'Consignment')]")
    public WebElement addedAllocationSuccessMessage;

    @FindBy(xpath = "//div[contains(text(),'Allocation Details')]")
    public WebElement allocationDetailsHeader;

    @FindBy(xpath = "//div[contains(text(),'Edit Allocation')]")
    public WebElement editAllocationHeader;

    @FindBy(xpath = "//p[contains(text(),'updated successfully')]")
    public WebElement editedSuccessMessage;

    @FindBy(xpath = "//h3[contains(text(),'Delete')]")
    public WebElement deleteHeader;

    @FindBy(xpath = "(//p[contains(text(),'Allocation')])[1]")
    public WebElement deletedMessage;







}
