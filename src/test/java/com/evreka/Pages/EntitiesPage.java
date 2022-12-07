package com.evreka.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EntitiesPage extends BasePage {

    @FindBy(xpath = "//div[contains(text(),'Entities')]")
    public WebElement entitiesHeader;

    @FindBy(xpath = "//button[@data-testid='add_entity_button']")
    public WebElement addEntityButton;

    @FindBy(name = "name")
    public WebElement entityNameBox;



    @FindBy(xpath = "(//tbody[@role='rowgroup']//td)[2]")
    public WebElement entityNameTable;

    @FindBy(xpath = "//p[contains(text(),'Edit')]")
    public WebElement editEntityItem;

    @FindBy(xpath = "//h3[contains(text(),'Con')]")
    public WebElement confirmText;

    @FindBy(xpath = "//li[@data-testid='0_delete_entity']")
    public WebElement deleteEntityItems;

    @FindBy(xpath = "//button[@data-testid='cancel_button']")
    public WebElement cancelButton;

    @FindBy(xpath = "//h2[contains(text(),'There')]")
    public WebElement noEntitiesMessage;

    @FindBy(xpath = "//div[contains(text(),'Entity')]")
    public WebElement addEntityHeader;

    @FindBy(xpath = "//div[contains(text(),'Edit')]")
    public WebElement editEntityHeader;

    @FindBy(xpath = "//div[contains(text(),'Entity')]")
    public WebElement entityDetailsHeader;

    @FindBy(xpath = "//li[contains(@data-testid,'menu')]")
    public List<WebElement> entityDetailsTreeDotMenuItems;

    @FindBy(xpath = "(//p[@font-size='header3'])[1]")
    public WebElement smdTableHeaderEntities;

    @FindBy(xpath = "//p[@font-size='header3']")
    public WebElement smdTableHeaderOrders;

    @FindBy(xpath = "//button[@data-testid='entity_detail_add_ad_hoc_order']")
    public WebElement addAdHocOrderButton;

    @FindBy(xpath = "//div[contains(text(),'Add Ad Hoc')]")
    public WebElement addAdHocOrderHeader;

    @FindBy(xpath = "//li[contains(@id,'tab:re')]")
    public List<WebElement> addAdHocTabList;

    @FindBy(xpath = "//div[contains(text(),'Add marker')]")
    public WebElement locationBoxText;
    @FindBy(xpath = "//input[@class='map_search__input']")
    public WebElement locationSearchBox;

    @FindBy(xpath = "//div[contains(@class,'map_search__option')][1]")
    public WebElement firstLocation;

    @FindBy(name = "location")
    public WebElement locationBox;

    @FindBy(xpath = "//div[@data-testid='order_type_field']")
    public WebElement orderTypeBox;

    @FindBy(xpath = "//span[@data-testid='order_type_field_1']")
    public WebElement producerOrder;

    @FindBy(name = "due_date")
    public WebElement dueDateBox;

    @FindBy(xpath = "//div[contains(@class,'map_search__clear-indicator')]")
    public WebElement crossButton;





}
