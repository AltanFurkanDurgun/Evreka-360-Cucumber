package com.evreka.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProcessPage extends BasePage {

    @FindBy(xpath = "//p[contains(text(),'has been')]")
    public WebElement processSuccessMessage;

    @FindBy(xpath = "//div[contains(text(),'Process')]")
    public WebElement processHeader;

    @FindBy(xpath = "//button[@data-testid='add_process_button']")
    public WebElement addProcessButton;

    @FindBy(xpath = "//h3[contains(text(),'Add Process')]")
    public WebElement addProcessHeader;

    @FindBy(xpath = "//input[@data-testid='process_name']")
    public WebElement processNameInput;

    @FindBy(xpath = "(//div[contains(@class,'Select__indicators')])[4]")
    public WebElement processTypeSelectButton;

    @FindBy(xpath = "(//div[contains(@class,'Select__menu')])[1]")
    public WebElement processTypeOption;

    @FindBy(xpath = "//li[@data-testid='menu-item']")
    public List<WebElement> allStatusOptions;

    @FindBy(xpath = "(//ul[@role='menu'])[2]//li[@data-testid]")
    public List<WebElement> processDetailsTreeDotOptions;

    @FindBy(xpath = "//h3[contains(text(),'Edit Process')]")
    public WebElement editProcessHeader;

    @FindBy(xpath = "(//input[contains(@class,'Select__input')])[3]")
    public WebElement processTypeInput;

    @FindBy(xpath = "//h3[contains(text(),'Delete Process')]")
    public WebElement deleteProcessHeader;

    @FindBy(xpath = "//p[contains(text(),'Processes')]")
    public WebElement processDeletedMessage;



}
