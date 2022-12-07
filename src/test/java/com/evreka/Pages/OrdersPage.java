package com.evreka.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OrdersPage extends BasePage{
    @FindBy(xpath = "//div[contains(text(),'Orders')]")
    public WebElement ordersHeader;

    @FindBy(xpath = "//ul[@role='tablist']//li")
    public List<WebElement> allTabHeaderOrders;

    @FindBy(xpath = "//tr[@role='row']//td[@data-testid='row_0_td_1']")
    public WebElement orderPlansNameTable;

    @FindBy(xpath = "(//button[@role='button'])[1]")
    public WebElement addAdHocOrderButton;

    @FindBy(xpath = "(//button[@type='button'])[1]")
    public WebElement statusButtonOrderDetails;

    @FindBy(xpath = "//div[contains(text(),'Order Details')]")
    public WebElement orderDetailsHeader;

    @FindBy(xpath = "//li[@data-testid='menu-item']")
    public List<WebElement> statusOptionsOrderDetails;

    @FindBy(id = "action-menu-button")
    public WebElement treeDotButtonOrderDetails;

    @FindBy(xpath= "//li[@data-testid='repeat_order']")
    public WebElement treeDotOptionOrderDetails;

    @FindBy(xpath= "//div[@data-testid='content_type']")
    public WebElement linkWorkOrderSelectBox;

    @FindBy(xpath= "//span[@data-testid='content_type_3']")
    public WebElement linkWorkOrderInboundOption;

    @FindBy(xpath= "//div[contains(text(),'Search')]")
    public WebElement linkWorkOrderSearchBox;

    @FindBy(xpath= "(//input[contains(@id,'react-select-')])[6]")
    public WebElement linkWorkOrderSearchInput;

    @FindBy(xpath= "(//div[contains(@id,'react-select-')])[5]")
    public WebElement linkWorkOrderNameFirstOpt;

    @FindBy(xpath= "//div[contains(text(),'Inbound is valid')]")
    public WebElement linkWorkOrderSuccessMessage;

    @FindBy(xpath= "//h3[contains(text(),'Create')]")
    public WebElement createDocumentHeader;

    @FindBy(xpath= "(//div[contains(@class,'Select__indicators')])[5]")
    public WebElement createDocumentSelectInput;

    @FindBy(xpath= "//span[@data-testid='document_type_0']")
    public WebElement documentTypeOrderInvoice;

    @FindBy(xpath= "//p[contains(text(),'Not')]")
    public WebElement createDocumentWarningMessage;

    @FindBy(xpath= "//tr[@role='row']//td[@data-testid='row_0_td_0']")
    public WebElement ordersTableOrderNameRow;

    @FindBy(xpath= "//div[contains(text(),'Repeat Order')]")
    public WebElement repeatOrderHeader;
















































}
