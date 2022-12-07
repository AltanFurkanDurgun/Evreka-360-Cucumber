package com.evreka.Step_Def;

import com.evreka.Pages.PricingEnginePage;
import com.evreka.Utilies.BrowserUtils;
import com.evreka.Utilies.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.*;

public class PricingEngineStepDef {

    PricingEnginePage pricingEnginePage = new PricingEnginePage();

    String expectedUnitPrice, entityName;

    @When("User can click Pricing Engine option.")
    public void userCanClickPricingEngineOption() {
        BrowserUtils.waitForClickability(pricingEnginePage.engagementOptions.get(3), 15);
        pricingEnginePage.engagementOptions.get(3).click();
    }

    @Then("Verify that the user should on the pricing engine page.")
    public void verifyThatTheUserShouldOnThePricingEnginePage() {
        pricingEnginePage.verifyHeader("Pricing Engine", pricingEnginePage.pricingEngineHeader);
    }

    @When("User can click add price")
    public void userCanClickAddPrice() {
        BrowserUtils.waitForClickability(pricingEnginePage.addPriceButton, 15);
        pricingEnginePage.addPriceButton.click();
    }

    @Then("Verify that the user should see {string} header.\\(PE)")
    public void verifyThatTheUserShouldSeeHeaderPE(String expectedHeader) {
        pricingEnginePage.verifyHeader(expectedHeader, pricingEnginePage.addPriceHeader);
    }

    @When("User can enter entity name.")
    public void userCanEnterEntityName() {
        BrowserUtils.waitForClickability(pricingEnginePage.entityNameBoxAddPrice, 15);
        pricingEnginePage.entityNameBoxAddPrice.click();
        pricingEnginePage.entityNameBoxAddPrice.sendKeys("test");
        BrowserUtils.waitFor(1);

    }

    @And("User can select entity type.\\(PE)")
    public void userCanSelectEntityTypePE() {
        BrowserUtils.waitForClickability(pricingEnginePage.entityFirstOptionAddPrice, 15);
        pricingEnginePage.entityFirstOptionAddPrice.click();
    }

    @And("User can select order type.\\(PE)")
    public void userCanSelectOrderTypePE() {
        BrowserUtils.waitForClickability(pricingEnginePage.orderTypeAddPrice, 15);
        pricingEnginePage.orderTypeAddPrice.click();
        BrowserUtils.waitForClickability(pricingEnginePage.producerOrderAddPrice, 15);
        pricingEnginePage.producerOrderAddPrice.click();

    }

    @And("User can select order item.")
    public void userCanSelectOrderItem() {
        BrowserUtils.waitForClickability(pricingEnginePage.orderItemAddPrice, 15);
        pricingEnginePage.orderItemAddPrice.click();
        BrowserUtils.waitForClickability(pricingEnginePage.orderItemFirstOptAddPrice, 15);
        pricingEnginePage.orderItemFirstOptAddPrice.click();
    }

    @And("User can enter unit price.")
    public void userCanEnterUnitPrice() {
        String unitPrice = "10.00";
        pricingEnginePage.unitPriceBox.sendKeys(unitPrice);

    }

    @And("User can enter market share.")
    public void userCanEnterMarketShare() {
        pricingEnginePage.marketShareBox.sendKeys("5");
    }


    @Then("Verify that the user should see {string} success message.\\(PE)")
    public void verifyThatTheUserShouldSeeSuccessMessagePE(String expectedMessage) {
        BrowserUtils.waitForVisibility(pricingEnginePage.successMessage, 15);
        String actualMessage = pricingEnginePage.successMessage.getText();
        System.out.println("actualMessage = " + actualMessage);
        assertEquals(expectedMessage, actualMessage);
    }

    @And("Verify that the user should see creation time.")
    public void verifyThatTheUserShouldSeeCreationTime() {
        BrowserUtils.waitForVisibility(pricingEnginePage.creationTimeRow, 15);
        System.out.println("Creation time = " + pricingEnginePage.creationTimeRow.getText());

    }

    @And("User can click edit price.")
    public void userCanClickEditPrice() {
        BrowserUtils.waitForClickability(pricingEnginePage.treeDotMenuItems.get(0), 15);
        pricingEnginePage.treeDotMenuItems.get(0).click();

    }

    @Then("Verify that the user should see {string} header.\\(EP)")
    public void verifyThatTheUserShouldSeeHeaderEP(String expectedHeader) {
        pricingEnginePage.verifyHeader(expectedHeader, pricingEnginePage.editPriceHeader);
    }


    @And("Verify that the entity name ,order type ,order item is not enable.")
    public void verifyThatTheEntityNameOrderTypeOrderItemIsNotEnable() {
        assertFalse(pricingEnginePage.entityNameBoxAddPrice.isEnabled());
        assertFalse(pricingEnginePage.orderTypeInputEditPrice.isEnabled());
        assertFalse(pricingEnginePage.orderItemInputEditPrice.isEnabled());
    }

    @When("User can edit unit price.")
    public void userCanEditUnitPrice() {
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(pricingEnginePage.unitPriceBox).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
        String editPrice = "15.00";
        pricingEnginePage.unitPriceBox.sendKeys(editPrice);
    }

    @Then("Verify that the user should see {string} success message.\\(EP)")
    public void verifyThatTheUserShouldSeeSuccessMessageEP(String expectedMessage) {
        BrowserUtils.waitForVisibility(pricingEnginePage.successMessage, 15);
        String actualMessage = pricingEnginePage.successMessage.getText();
        System.out.println("actualMessage = " + actualMessage);
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @And("Verify that the user should see last update time.")
    public void verifyThatTheUserShouldSeeLastUpdateTime() {
        BrowserUtils.waitForVisibility(pricingEnginePage.lastUpdateTimeRow, 15);
        System.out.println("Last update time = " + pricingEnginePage.lastUpdateTimeRow.getText());

    }

    @When("User can check unit price.")
    public void userCanCheckUnitPrice() {
        BrowserUtils.waitForVisibility(pricingEnginePage.unitPriceRow, 15);
        expectedUnitPrice = pricingEnginePage.unitPriceRow.getText();


    }

    @And("User can click price history.")
    public void userCanClickPriceHistory() {
        BrowserUtils.waitForClickability(pricingEnginePage.treeDotMenuItems.get(1), 15);
        pricingEnginePage.treeDotMenuItems.get(1).click();
    }

    @And("Verify that the user should see unit price.")
    public void verifyThatTheUserShouldSeeUnitPrice() {

        String actualUnitPrice = pricingEnginePage.unitPriceAndEditedPrice.get(0).getText();
        System.out.println("actualUnitPrice = " + actualUnitPrice);
        System.out.println("expectedUnitPrice = " + expectedUnitPrice);
        assertNotEquals(expectedUnitPrice, actualUnitPrice);


    }

    @When("User can click close button.")
    public void userCanClickCloseButton() {
        BrowserUtils.waitForClickability(pricingEnginePage.priceHistoryCloseButton, 15);
        pricingEnginePage.priceHistoryCloseButton.click();
    }


    @And("User can click delete price.")
    public void userCanClickDeletePrice() {
        entityName = pricingEnginePage.baseTableFirstRow.getText();
        BrowserUtils.waitForClickability(pricingEnginePage.treeDotMenuItems.get(2), 15);
        pricingEnginePage.treeDotMenuItems.get(2).click();
    }

    @And("Verify that the deleted entity name should not appear in the price table.")
    public void verifyThatTheDeletedEntityNameShouldNotAppearInThePriceTable() {
        BrowserUtils.waitForVisibility(pricingEnginePage.baseTableFirstRow, 15);
        String actualEntityName = pricingEnginePage.baseTableFirstRow.getText();
        System.out.println("actualEntityName = " + actualEntityName);
        System.out.println("expectedEntityName = " + entityName);
        assertNotEquals(entityName,actualEntityName );

    }
}
