package com.evreka.Step_Def;

import com.evreka.Pages.InventoryPage;
import com.evreka.Utilies.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class InventoryStepDef {

    InventoryPage inventoryPage = new InventoryPage();

    int amount = 10, capacity = 10;
    double totalAmount, lastAmountCount, totalDecreaseAmount, lastCapacityAmount ,totalCapacityAmount;

    @When("User can click inventory option.")
    public void userCanClickInventoryOption() {
        BrowserUtils.waitForClickability(inventoryPage.mrfManagementOptions.get(4), 15);
        inventoryPage.mrfManagementOptions.get(4).click();

    }

    @Then("Verify that the user should on the {string} page.\\(inventory)")
    public void verifyThatTheUserShouldOnThePageInventory(String expectedHeader) {
        inventoryPage.verifyHeader(expectedHeader, inventoryPage.inventoryHeader);

    }

    @When("User can click add inventory record button.")
    public void userCanClickAddInventoryRecordButton() {
        BrowserUtils.waitForClickability(inventoryPage.addInventoryRecordButton, 15);
        inventoryPage.addInventoryRecordButton.click();
    }

    @When("User can select material type.\\(inventory)")
    public void userCanSelectMaterialTypeInventory() {
        BrowserUtils.waitForVisibility(inventoryPage.materialTypeSelectButton, 15);
        inventoryPage.materialTypeSelectButton.click();
        BrowserUtils.waitForClickability(inventoryPage.materialTypeOption, 15);
        inventoryPage.materialTypeOption.click();
    }

    @And("User can enter amount.")
    public void userCanEnterAmount() {

        inventoryPage.amountBox.sendKeys(String.valueOf(amount));

    }

    @And("User can enter capacity.")
    public void userCanEnterCapacity() {

        inventoryPage.capacityBox.sendKeys(String.valueOf(capacity));

    }

    @Then("Verify that the user should see success message.\\(inventory)")
    public void verifyThatTheUserShouldSeeSuccessMessageInventory() {
        BrowserUtils.waitForVisibility(inventoryPage.successMessage, 15);
        String successMessage = inventoryPage.successMessage.getText();
        System.out.println("successMessage = " + successMessage);
        assertTrue(inventoryPage.successMessage.isDisplayed());

    }

    @And("User can click increase amount.")
    public void userCanClickIncreaseAmount() {
        BrowserUtils.waitForClickability(inventoryPage.treeDotMenuOptions.get(0), 15);
        inventoryPage.treeDotMenuOptions.get(0).click();

    }

    @Then("Verify that the user should see {string} header.\\(increase)")
    public void verifyThatTheUserShouldSeeHeaderIncrease(String expectedHeader) {
        inventoryPage.verifyHeader(expectedHeader, inventoryPage.increaseAmountHeader);

    }

    @When("User can enter amount.\\(increase)")
    public void userCanEnterAmountIncrease() {
        int increaseAmount = 5;
        inventoryPage.increaseAmountBox.sendKeys(String.valueOf(increaseAmount));
        totalAmount = amount + increaseAmount;
        System.out.println("totalAmount = " + totalAmount);

    }

    @Then("Verify that the user should see warning message.")
    public void verifyThatTheUserShouldSeeWarningMessage() {
        BrowserUtils.waitForVisibility(inventoryPage.increaseAmountWarningMessage, 15);
        String actualWarningMessage = inventoryPage.increaseAmountWarningMessage.getText();
        System.out.println("actualWarningMessage = " + actualWarningMessage);
        String expectedWarningMessage = "Amount exceeds facility's capacity. Current capacity is " + capacity + ". Are you sure you want to continue?";
        assertEquals(expectedWarningMessage, actualWarningMessage);
    }

    @And("Verify that the user should be see total amount in inventory table.")
    public void verifyThatTheUserShouldBeSeeTotalAmountInInventoryTable() {
        BrowserUtils.waitForVisibility(inventoryPage.totalAmountRow, 15);
        String actualAmount = inventoryPage.totalAmountRow.getText().replace("kg", "").trim();
        System.out.println("actualAmount = " + actualAmount);
        String expectedAmount = String.valueOf(totalAmount);
        System.out.println("expectedAmount = " + expectedAmount);
        assertEquals(expectedAmount, actualAmount);
    }

    @And("User can click decrease amount.")
    public void userCanClickDecreaseAmount() {
        BrowserUtils.waitForVisibility(inventoryPage.totalAmountRow, 15);
        lastAmountCount = Double.parseDouble(inventoryPage.totalAmountRow.getText().replace("kg", "").trim());
        BrowserUtils.waitForClickability(inventoryPage.treeDotMenuOptions.get(1), 15);
        inventoryPage.treeDotMenuOptions.get(1).click();
    }

    @Then("Verify that the user should see {string} header.\\(decrease)")
    public void verifyThatTheUserShouldSeeHeaderDecrease(String expectedHeader) {
        inventoryPage.verifyHeader(expectedHeader, inventoryPage.decreaseAmountHeader);
    }

    @When("User can enter amount.\\(decrease)")
    public void userCanEnterAmountDecrease() {
        int decreaseAmount = 5;
        inventoryPage.increaseAmountBox.click();
        inventoryPage.increaseAmountBox.sendKeys(String.valueOf(decreaseAmount));
        totalDecreaseAmount = lastAmountCount - decreaseAmount;
        System.out.println("totalDecreaseAmount = " + totalDecreaseAmount);

    }

    @And("Verify that the user should be see total decrease amount in inventory table.")
    public void verifyThatTheUserShouldBeSeeTotalDecreaseAmountInInventoryTable() {
        BrowserUtils.waitForVisibility(inventoryPage.totalAmountRow, 15);
        String actualAmount = inventoryPage.totalAmountRow.getText().replace("kg", "").trim();
        System.out.println("actualAmount = " + actualAmount);
        String expectedAmount = String.valueOf(totalDecreaseAmount);
        System.out.println("expectedAmount = " + expectedAmount);
        assertEquals(expectedAmount, actualAmount);

    }

    @And("User can click change capacity.")
    public void userCanClickChangeCapacity() {
        BrowserUtils.waitForVisibility(inventoryPage.capacityAmountRow, 15);
        System.out.println("inventoryPage.capacityAmountRow.getText() = " + inventoryPage.capacityAmountRow.getText());
        lastCapacityAmount = Double.parseDouble(inventoryPage.capacityAmountRow.getText().replace("kg", "").trim());
        System.out.println("lastCapacityAmount = " + lastCapacityAmount);
        BrowserUtils.waitForClickability(inventoryPage.treeDotMenuOptions.get(2), 15);
        inventoryPage.treeDotMenuOptions.get(2).click();
    }

    @Then("Verify that the user should see warning message.\\(change)")
    public void verifyThatTheUserShouldSeeWarningMessageChange() {
        double convertCapacityCount = Double.parseDouble(inventoryPage.totalAmountRow.getText().replace("kg","").trim());
        int capacityCount = (int) convertCapacityCount;
        BrowserUtils.waitForVisibility(inventoryPage.changeCapacityWarningMessage, 15);
        String actualWarningMessage = inventoryPage.changeCapacityWarningMessage.getText();
        System.out.println("actualWarningMessage = " + actualWarningMessage);
        String expectedWarningMessage = "Facility's capacity is below the amount. Current amount is " + capacityCount + ". Are you sure you want to continue?";
        System.out.println("expectedWarningMessage = " + expectedWarningMessage);
        assertEquals(expectedWarningMessage, actualWarningMessage);
    }

    @And("User can enter capacity.\\(change)")
    public void userCanEnterCapacityChange() {
        int decreaseCapacity = 5;
        BrowserUtils.cleanBox(inventoryPage.changeCapacityInput);
        BrowserUtils.waitForClickability(inventoryPage.changeCapacityInput, 15);
        inventoryPage.changeCapacityInput.click();
        inventoryPage.changeCapacityInput.sendKeys(String.valueOf(decreaseCapacity));
        totalCapacityAmount = lastCapacityAmount-decreaseCapacity;

    }

    @And("Verify that the user should be see total capacity amount in inventory table.")
    public void verifyThatTheUserShouldBeSeeTotalCapacityAmountInInventoryTable() {
        BrowserUtils.waitForVisibility(inventoryPage.capacityAmountRow,15);
        String actualCapacityAmount = inventoryPage.capacityAmountRow.getText().replace("kg","").trim();
        System.out.println("actualCapacityAmount = " + actualCapacityAmount);
        String expectedCapacityAmount = String.valueOf(totalCapacityAmount);
        System.out.println("expectedCapacityAmount = " + expectedCapacityAmount);
        assertEquals(expectedCapacityAmount,actualCapacityAmount);

    }

    @And("User can click delete.")
    public void userCanClickDelete() {
        BrowserUtils.waitForClickability(inventoryPage.treeDotMenuOptions.get(4),15);
        inventoryPage.treeDotMenuOptions.get(4).click();
    }

    @Then("Verify that the user should see {string}")
    public void verifyThatTheUserShouldSee(String expectedHeader) {
        inventoryPage.verifyHeader(expectedHeader,inventoryPage.deleteInventoryHeader);

    }

    @Then("Verify that the user should see {string} message.\\(inventory)")
    public void verifyThatTheUserShouldSeeMessageInventory(String expectedMessage) {

        BrowserUtils.waitForVisibility(inventoryPage.deleteSuccessMessage,15);
        String actualMessage = inventoryPage.deleteSuccessMessage.getText();
        System.out.println("actualMessage = " + actualMessage);
        System.out.println("expectedMessage = " + expectedMessage);
        assertEquals(expectedMessage,actualMessage);

    }
}
