package com.evreka.Step_Def;

import com.evreka.Pages.AllocationPage;
import com.evreka.Utilies.BrowserUtils;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static org.junit.Assert.*;

public class AllocationStepDef {

    AllocationPage allocationPage = new AllocationPage();

    Faker faker = new Faker();

    String expectedAllocationName, editedAllocationName;

    @And("User can click allocation option.")
    public void userCanClickAllocationOption() {
        BrowserUtils.waitForVisibility(allocationPage.mrfManagementOptions.get(3), 15);
        allocationPage.mrfManagementOptions.get(3).click();

    }

    @Then("Verify that the user should on the {string} page.\\(allocation)")
    public void verifyThatTheUserShouldOnThePageAllocation(String expectedHeader) {

        allocationPage.verifyHeader(expectedHeader, allocationPage.allocationHeader);

    }

    @When("User can click add allocation.")
    public void userCanClickAddAllocation() {

        BrowserUtils.waitForClickability(allocationPage.addAllocationButton, 15);
        allocationPage.addAllocationButton.click();

    }

    @Then("Verify that the user should see {string} header.\\(allocation)")
    public void verifyThatTheUserShouldSeeHeaderAllocation(String expectedHeader) {
        allocationPage.verifyHeader(expectedHeader, allocationPage.addAllocationHeader);
    }

    @When("User can enter allocation name.")
    public void userCanEnterAllocationName() {
        expectedAllocationName = faker.name().firstName();
        allocationPage.allocationNameBox.sendKeys(expectedAllocationName);

    }

    @When("User can select allocation type.")
    public void userCanSelectAllocationType() {
        BrowserUtils.waitForClickability(allocationPage.allocationTypeSelectButton, 15);
        allocationPage.allocationTypeSelectButton.click();
        BrowserUtils.waitForClickability(allocationPage.allocationTypeOption, 15);
        allocationPage.allocationTypeOption.click();
    }

    @And("User can select material type.\\(allocation)")
    public void userCanSelectMaterialTypeAllocation() {
        BrowserUtils.waitForClickability(allocationPage.materialTypeSelectButton, 15);
        allocationPage.materialTypeSelectButton.click();
        BrowserUtils.waitForClickability(allocationPage.materialTypeFirstOption, 15);
        allocationPage.materialTypeFirstOption.click();
    }

    @Then("Verify that the user should see {string} message.\\(allocation)")
    public void verifyThatTheUserShouldSeeMessageAllocation(String expectedMessage) {
        BrowserUtils.waitForVisibility(allocationPage.plannedWeightWarningMessage, 15);
        String actualMessage = allocationPage.plannedWeightWarningMessage.getText();
        System.out.println("actualMessage = " + actualMessage);
        assertEquals(expectedMessage, actualMessage);


    }

    @Then("Verify that the user should see success message.\\(allocation)")
    public void verifyThatTheUserShouldSeeSuccessMessageAllocation() {

        BrowserUtils.waitForVisibility(allocationPage.addedAllocationSuccessMessage, 15);
        String actualMessage = allocationPage.addedAllocationSuccessMessage.getText();
        System.out.println("actualMessage = " + actualMessage);
        assertTrue(allocationPage.addedAllocationSuccessMessage.isDisplayed());


    }

    @And("Verify that the created allocation appears in the allocation table.")
    public void verifyThatTheCreatedAllocationAppearsInTheAllocationTable() {
        BrowserUtils.waitForVisibility(allocationPage.baseTableFirstRow, 15);
        String actualAllocationName = allocationPage.baseTableFirstRow.getText();
        System.out.println("actualAllocationName = " + actualAllocationName);
        assertEquals(expectedAllocationName, actualAllocationName);
    }

    @Then("Verify that the user should on the {string} page.\\(SMDAllocation)")
    public void verifyThatTheUserShouldOnThePageSMDAllocation(String expectedHeader) {

        allocationPage.verifyHeader(expectedHeader, allocationPage.allocationDetailsHeader);
    }


    @And("Verify that the user should see following options.\\(allocationTab)")
    public void verifyThatTheUserShouldSeeFollowingOptionsAllocationTab(List<String> allTabOptions) {
        BrowserUtils.waitForVisibility(allocationPage.smdTabList.get(0), 15);
        for (int i = 0; i < allocationPage.smdTabList.size(); i++) {
            BrowserUtils.waitForVisibility(allocationPage.smdTabList.get(i), 15);
            String actualTabHeader = allocationPage.smdTabList.get(i).getText();
            System.out.println("actualTabHeader = " + actualTabHeader);
            assertEquals(allTabOptions.get(i), actualTabHeader);

        }
    }

    @Then("Verify that the user should see following options.\\(allocationTableTab)")
    public void verifyThatTheUserShouldSeeFollowingOptionsAllocationTableTab(List<String> allTableTabOptions) {

        BrowserUtils.waitForVisibility(allocationPage.smdTableTabList.get(0), 15);
        for (int i = 0; i < allocationPage.smdTableTabList.size(); i++) {
            BrowserUtils.waitForVisibility(allocationPage.smdTableTabList.get(i), 15);
            String actualTabHeader = allocationPage.smdTableTabList.get(i).getText();
            System.out.println("actualTabHeader = " + actualTabHeader);
            assertEquals(allTableTabOptions.get(i), actualTabHeader);

        }
    }

    @And("User can click edit allocation.")
    public void userCanClickEditAllocation() {
        BrowserUtils.waitForClickability(allocationPage.treeDotMenuOptions.get(1), 15);
        allocationPage.treeDotMenuOptions.get(1).click();

    }

    @Then("Verify that the user should see on the {string} page.\\(editAllocation)")
    public void verifyThatTheUserShouldSeeOnThePageEditAllocation(String expectedHeader) {
        allocationPage.verifyHeader(expectedHeader, allocationPage.editAllocationHeader);
    }

    @When("User can edit allocation name.")
    public void userCanEditAllocationName() {
        allocationPage.allocationNameBox.sendKeys("_edit");
        editedAllocationName = allocationPage.allocationNameBox.getAttribute("value");
    }

    @Then("Verify that the user should see success message.\\(editAllocation)")
    public void verifyThatTheUserShouldSeeSuccessMessageEditAllocation() {
        BrowserUtils.waitForVisibility(allocationPage.editedSuccessMessage, 15);
        String actualMessage = allocationPage.editedSuccessMessage.getText();
        System.out.println("actualMessage = " + actualMessage);
        assertTrue(allocationPage.editedSuccessMessage.isDisplayed());
    }

    @And("Verify that the edited allocation appears in the allocation table.")
    public void verifyThatTheEditedAllocationAppearsInTheAllocationTable() {
        BrowserUtils.waitForVisibility(allocationPage.baseTableFirstRow, 15);
        String actualAllocationName = allocationPage.baseTableFirstRow.getText();
        System.out.println("actualAllocationName = " + actualAllocationName);
        assertEquals(editedAllocationName, actualAllocationName);

    }

    @And("User can click delete allocation.")
    public void userCanClickDeleteAllocation() {
        BrowserUtils.waitForClickability(allocationPage.treeDotMenuOptions.get(3), 15);
        allocationPage.treeDotMenuOptions.get(3).click();
    }

    @Then("Verify that the user should see {string} header.\\(deleteAllocation)")
    public void verifyThatTheUserShouldSeeHeaderDeleteAllocation(String expectedHeader) {
        allocationPage.verifyHeader(expectedHeader, allocationPage.deleteHeader);

    }


    @Then("Verify that the user should see {string} deleted message.\\(deleteMessage)")
    public void verifyThatTheUserShouldSeeDeletedMessageDeleteMessage(String expectedSuccessMessage) {
        BrowserUtils.waitFor(1);
        BrowserUtils.waitForVisibility(allocationPage.deletedMessage, 15);
        String actualSuccessMessage = allocationPage.deletedMessage.getText();
        System.out.println("actualSuccessMessage = " + actualSuccessMessage);
        assertEquals(expectedSuccessMessage, actualSuccessMessage);

    }
}
