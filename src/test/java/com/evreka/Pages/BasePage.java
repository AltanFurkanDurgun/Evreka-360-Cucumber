package com.evreka.Pages;

import com.evreka.Utilies.BrowserUtils;
import com.evreka.Utilies.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BasePage {

    @FindBy(xpath = "//div[@data-testid='bar-icon']")
    public WebElement hamburgerMenuIcon;

    @FindBy(xpath = "//div[@id='engagement']/..//li")
    public List<WebElement> engagementOptions;

    @FindBy(xpath = "//select[*=*]")
    public WebElement changeUser;

    @FindBy(xpath = "//p[contains(text(),'Account')][2]")
    public WebElement selectedUserText;

    @FindBy(xpath = "//p[contains(text(),'Suc')]")
    public WebElement successMessage;

    @FindBy(xpath = "//button[@data-testid='submit_button']")
    public WebElement submitButton;

    @FindBy(xpath = "//input[@data-testid='filter-field-name']")
    public WebElement tableSearchInputBox;

    @FindBy(xpath = "//p[contains(text(),'items')]")
    public WebElement itemsCount;

    @FindBy(xpath = "//li[@data-testid='menu-item']")
    public List<WebElement> allStatus;

    @FindBy(xpath = "(//ul[@role='tablist'])[1]//li")
    public List<WebElement> smdTabList;

    @FindBy(xpath = "(//ul[@role='tablist'])[2]//li")
    public List<WebElement> smdTableTabList;

    @FindBy(xpath = "//li[contains(@data-testid,'0_')]")
    public List<WebElement> treeDotMenuItems;

    @FindBy(xpath = "//tr[@role='row']//td[@data-testid='row_0_td_0']")
    public WebElement baseTableFirstRow;

    @FindBy(xpath = "//input[@data-testid='order_name']")
    public WebElement orderNameBox;

    @FindBy(xpath = "(//div[@id='action-menu-button']//button)[2]")
    public WebElement inTableTreeDotButton;

    @FindBy(xpath = "//ul[@role='menu']//li")
    public List<WebElement> inTableTreeDotMenuOptions;

    @FindBy(xpath = "(//div[@id='action-menu-button']//button)[1]")
    public WebElement treeDotButton;

    @FindBy(xpath = "//div[contains(text(),'If left')]")
    public WebElement addAdHocOrderMessageText;

    @FindBy(xpath = "//div[@id='asset']/..//li")
    public List<WebElement> assetOptions;

    @FindBy(xpath = "//div[contains(text(),'This')]")
    public WebElement availableNameMessage;

    @FindBy(xpath = "(//button[@type='button'])[1]")
    public WebElement statusButton;

    @FindBy(xpath = "//ul[@role='menu']//li")
    public List<WebElement> treeDotMenuOptions;

    @FindBy(xpath = "//div[@id='mrf']/..//li")
    public List<WebElement> mrfManagementOptions;

    @FindBy(xpath = "//p[contains(text(),'Are you')]")
    public WebElement warningMessageAfterDelete;





    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }


    public void verifyHeader(String expectedHeader, WebElement element) {
        BrowserUtils.waitForVisibility(element, 15);
        String actualHeader = element.getText();
        System.out.println("actualHeader = " + actualHeader);
        assertEquals(expectedHeader, actualHeader);
    }

    public void selectDate(WebElement element,int dateCount) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, dateCount);
        cal.add(Calendar.MONTH, 0);
        String date = dateFormat.format(cal.getTime());
        jse.executeScript("arguments[0].removeAttribute('readonly'," + "'readonly')", element);
        element.sendKeys(date);
    }


}
