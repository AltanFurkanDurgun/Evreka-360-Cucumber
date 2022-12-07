package com.evreka.Step_Def;

import com.evreka.Pages.SettingsPage;
import com.evreka.Utilies.BrowserUtils;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class SettingsStepDef {

    SettingsPage settingsPage = new SettingsPage();

    Faker faker = new Faker();

    String expectedMaterialName,editedMaterialName;

    @When("User can click settings option.")
    public void userCanClickSettingsOption() {
        BrowserUtils.waitForClickability(settingsPage.mrfManagementOptions.get(5), 15);
        settingsPage.mrfManagementOptions.get(5).click();
    }

    @Then("Verify that the user should on the {string} page.\\(settings)")
    public void verifyThatTheUserShouldOnThePageSettings(String expectedHeader) {
        settingsPage.verifyHeader(expectedHeader, settingsPage.settingsHeader);

    }

    @When("User can click add material button.")
    public void userCanClickAddMaterialButton() {
        BrowserUtils.waitForClickability(settingsPage.addMaterialButton, 15);
        settingsPage.addMaterialButton.click();
    }

    @Then("Verify that the user should see {string} header.\\(addMaterial)")
    public void verifyThatTheUserShouldSeeHeaderAddMaterial(String expectedHeader) {
        settingsPage.verifyHeader(expectedHeader, settingsPage.addMaterialHeader);
    }

    @When("User can enter material name.")
    public void userCanEnterMaterialName() {
        expectedMaterialName = faker.name().firstName();
        settingsPage.materialNameNox.sendKeys(expectedMaterialName);

    }

    @When("User can enter weighting percentage.")
    public void userCanEnterWeightingPercentage() {
        settingsPage.weightingPercentageBox.sendKeys("10");
    }

    @Then("Verify that the user should see {string} message.\\(addMaterial)")
    public void verifyThatTheUserShouldSeeMessageAddMaterial(String expectedMessage) {
        BrowserUtils.waitForVisibility(settingsPage.successMessage, 15);
        String actualMessage = settingsPage.successMessage.getText();
        System.out.println("actualMessage = " + actualMessage);
        assertEquals(expectedMessage, actualMessage);
    }

    @And("Verify that the user should be see material name in material table.")
    public void verifyThatTheUserShouldBeSeeMaterialNameInMaterialTable() {
        BrowserUtils.waitForVisibility(settingsPage.baseTableFirstRow, 15);
        String actualMaterialName = settingsPage.baseTableFirstRow.getText();
        System.out.println("actualMaterialName = " + actualMaterialName);
        assertEquals(expectedMaterialName, actualMaterialName);
    }


    @And("User can click edit material.")
    public void userCanClickEditMaterial() {
        BrowserUtils.waitForClickability(settingsPage.treeDotMenuOptions.get(0), 15);
        settingsPage.treeDotMenuOptions.get(0).click();

    }

    @Then("Verify that the user should see {string} header.\\(editMaterial)")
    public void verifyThatTheUserShouldSeeHeaderEditMaterial(String expectedHeader) {

        settingsPage.verifyHeader(expectedHeader, settingsPage.editMaterialHeader);
    }

    @When("User can edit material name.")
    public void userCanEditMaterialName() {
        settingsPage.materialNameNox.sendKeys("_edit");
        editedMaterialName = settingsPage.materialNameNox.getAttribute("value");
        System.out.println("editedMaterialName = " + editedMaterialName);
    }

    @Then("Verify that the user should see {string} message.\\(editMaterial)")
    public void verifyThatTheUserShouldSeeMessageEditMaterial(String expectedMessage) {
        BrowserUtils.waitForVisibility(settingsPage.successMessage, 15);
        String actualMessage = settingsPage.successMessage.getText();
        System.out.println("actualMessage = " + actualMessage);
        assertEquals(expectedMessage, actualMessage);
    }

    @And("Verify that the user should be see edited material in material table.")
    public void verifyThatTheUserShouldBeSeeEditedMaterialInMaterialTable() {
        BrowserUtils.waitForVisibility(settingsPage.baseTableFirstRow,15);
        String actualMaterialName = settingsPage.baseTableFirstRow.getText();
        System.out.println("actualMaterialName = " + actualMaterialName);
        assertEquals(editedMaterialName,actualMaterialName);

    }

    @And("User can click delete material.")
    public void userCanClickDeleteMaterial() {
        BrowserUtils.waitForClickability(settingsPage.treeDotMenuOptions.get(2),15);
        settingsPage.treeDotMenuOptions.get(2).click();

    }

    @Then("Verify that the user should see {string} header.\\(deleteMaterial)")
    public void verifyThatTheUserShouldSeeHeaderDeleteMaterial(String expectedHeader) {

       settingsPage.verifyHeader(expectedHeader,settingsPage.deleteMaterialHeader);

    }

    @And("Verify that the user should see delete warning message.")
    public void verifyThatTheUserShouldSeeDeleteWarningMessage() {
        BrowserUtils.waitForVisibility(settingsPage.warningMessageAfterDelete,15);
        assertTrue(settingsPage.warningMessageAfterDelete.isDisplayed());
    }

    @Then("Verify that the user should be see {string} message.\\(deleteMaterial)")
    public void verifyThatTheUserShouldBeSeeMessageDeleteMaterial(String expectedMessage) {
        BrowserUtils.waitForVisibility(settingsPage.deleteSuccessMessage,15);
        String actualMessage = settingsPage.deleteSuccessMessage.getText();
        System.out.println("actualMessage = " + actualMessage);
        assertEquals(expectedMessage,actualMessage);
    }
}
