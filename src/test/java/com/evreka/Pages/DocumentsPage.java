package com.evreka.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DocumentsPage extends BasePage{


    @FindBy(xpath = "//div[contains(text(),'Documents')]")
    public WebElement documentsHeader;

    @FindBy(xpath = "//tr[@role='row']//td[@data-testid='row_0_td_5']")
    public WebElement documentsTableOrderNameRow;




}
