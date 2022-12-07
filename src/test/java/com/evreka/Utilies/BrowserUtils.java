package com.evreka.Utilies;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class BrowserUtils {

    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(timeToWaitInSec));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForClickability(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    public static void verifyElementDisplayed(WebElement element) {
        try {
            Assert.assertTrue("Element visible: " + element, element.isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            Assert.fail("Element not found: " + element);

        }
    }


    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].click();", element);
    }

    //Element gorunene kadar asagi indirir
    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static WebElement waitForVisibilityFrame(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.get(),Duration.ofSeconds(timeout));
        return (WebElement) wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
    }




    public static void doubleClick(WebElement element) {
        new Actions(Driver.get()).doubleClick(element).build().perform();
    }


    public static void executeJScommand(WebElement element, String command) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        jse.executeScript(command, element);

    }


    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void cleanBox(WebElement element){
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(element).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
    }

}
