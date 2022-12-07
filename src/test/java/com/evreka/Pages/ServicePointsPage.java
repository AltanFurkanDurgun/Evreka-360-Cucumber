package com.evreka.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ServicePointsPage extends BasePage {

    @FindBy(xpath = "//div[contains(text(),'Service Points')]")
    public WebElement servicePointsHeader;

    @FindBy(xpath = "//button[@data-testid='add_sp_button']")
    public WebElement addServicePointButton;

    @FindBy(xpath = "//div[contains(text(),'Add Service Point')]")
    public WebElement addServicePointHeader;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement servicePointNameBox;

    @FindBy(xpath = "//div[@placeholder='Select']")
    public List<WebElement> allSelectDropdownMenu;

    @FindBy(xpath = "//span[@data-testid='undefined_1' or @data-testid='order_type_1' or @data-testid='order_type_field_1']")
    public WebElement producerOrderOption;

    @FindBy(xpath = "//div[contains(@class,'Select__menu-list')]")
    public WebElement standardServicePointType;

    @FindBy(xpath = "//span[@data-testid='undefined_0']")
    public WebElement producerEntityType;

    @FindBy(xpath = "(//div[contains(@class,'Async-Select')]//input[@role='combobox'])[1]")
    public WebElement entitySearchBoxAddServicePoint;

    @FindBy(xpath = "//input[@id='react-select-10-input']")
    public WebElement operationServicePointBox;

    @FindBy(xpath = "//div[@class=' css-uqxu9s']//div")
    public List<WebElement> allEntityOptions;
    @FindBy(xpath = "//div[contains(text(),'Service Point')]")
    public WebElement servicePointDetailsHeader;

    @FindBy(xpath = "(//ul[@role='tablist'])[1]//li")
    public List<WebElement> servicePointDetailTabHeaders;

    @FindBy(xpath = "//button[@data-testid='sp.add_ad_hoc_order']")
    public WebElement spdAddAdHocOrderButton;

    @FindBy(xpath = "//div[@data-testid='entity_name']")
    public WebElement servicePointEntityNameBox;

    @FindBy(xpath = "//div[@class=' css-uqxu9s']//div")
    public WebElement operationsServicePointOption;

    @FindBy(xpath = "//div[contains(text(),'Edit Service')]")
    public WebElement editServicePointHeader;

    @FindBy(xpath = "//div[contains(text(),'Add Order')]")
    public WebElement addOrderPlanHeader;

    @FindBy(xpath = "//ul[@role='tablist']//li")
    public List<WebElement> addOrderPlanTabAllHeader;

    @FindBy(xpath = "//p[contains(text(),'Only orders')]")
    public WebElement warningMessageAddOrderPlan;

    @FindBy(xpath = "//input[@data-testid='order_plan_name']")
    public WebElement orderPlanNameBox;

    @FindBy(xpath = "//input[@name='plan_start_date']")
    public WebElement planStartDateBox;

    @FindBy(xpath = "//input[@name='plan_end_date']")
    public WebElement planEndDateBox;

    @FindBy(xpath = "//input[@data-testid='entity_name']")
    public WebElement entityNameBoxAddOrderPlan;

    @FindBy(xpath = "//div[@data-testid='schedule_type']")
    public WebElement scheduleBoxAddOrderPlan;

    @FindBy(xpath = "//span[@data-testid='schedule_type_0']")
    public WebElement dailyOptionAddOrderPlan;

    @FindBy(xpath = "//input[@name='schedule_daily']")
    public WebElement daysCountBox;

    @FindBy(xpath = "(//tbody[@role='rowgroup']//td)[1]")
    public WebElement servicePointNameTable;

    @FindBy(xpath = "//h3[contains(text(),'Link')]")
    public WebElement linkAssetHeader;

    @FindBy(xpath = "//label[contains(text(),'Asset')]")
    public WebElement linkAssetSubHeader;

    @FindBy(xpath = "//input[@data-testid='asset_id']")
    public WebElement linkAssetSearchBox;

    @FindBy(xpath = "//h3[contains(text(),'Confirm')]")
    public WebElement unlinkConfirmHeader;

    @FindBy(xpath = "//div[contains(@class,'css-uq')]//div")
    public List<WebElement> linkAssetSearchOptions;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement linkAssetSubmitButton;

    @FindBy(xpath = "(//input[contains(@id,'react-select')])[4]")
    public WebElement linkToOperationsSearchBox;

    @FindBy(xpath = "//h3[contains(text(),'Link')]")
    public WebElement linkToOperationsHeader;

    @FindBy(xpath = "//label[contains(text(),'Operations')]")
    public WebElement linkToOperationsSubHeader;

    @FindBy(xpath = "//tr[@role='row']//td[@data-testid='row_0_td_3']")
    public WebElement operationManagementServicePointTableRow;

    @FindBy(xpath = "(//div[contains(@id,'react-select')])[4]")
    public WebElement operationManagementServicePointOption;































}
