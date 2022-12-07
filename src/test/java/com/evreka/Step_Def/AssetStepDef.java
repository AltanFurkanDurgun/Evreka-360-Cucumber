package com.evreka.Step_Def;

import com.evreka.Pages.AssetPage;
import com.evreka.Pages.ServicePointsPage;
import com.evreka.Utilies.BrowserUtils;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static org.junit.Assert.*;

public class AssetStepDef {

    AssetPage assetPage = new AssetPage();

    ServicePointsPage servicePointsPage = new ServicePointsPage();

    Faker faker = new Faker();

    String name, oldAssetType, expectedDeviceID;

    @Then("Verify that the user should see following options.\\(Asset)")
    public void verifyThatTheUserShouldSeeFollowingOptionsAsset(List<String> menuOptions) {

        for (int i = 0; i < assetPage.assetOptions.size(); i++) {
            BrowserUtils.waitForVisibility(assetPage.assetOptions.get(i), 15);
            System.out.println("allMenuOptions = " + assetPage.assetOptions.get(i).getText());
            assertEquals(menuOptions.get(i), assetPage.assetOptions.get(i).getText());
        }

    }

    @When("User can click add asset button.")
    public void userCanClickAddAssetButton() {
        BrowserUtils.waitForClickability(assetPage.addAssetButton, 15);
        assetPage.addAssetButton.click();

    }

    @Then("Verify that the the user should on the {string} page.")
    public void verifyThatTheTheUserShouldOnThePage(String expectedHeader) {
        assetPage.verifyHeader(expectedHeader, assetPage.addAssetHeader);
    }

    @When("User can enter name.")
    public void userCanEnterName() {
        BrowserUtils.waitForVisibility(assetPage.nameBoxAddAsset, 15);
        name = faker.name().lastName();
        assetPage.nameBoxAddAsset.sendKeys(name);
        BrowserUtils.waitFor(1);


    }

    @Then("Verify that the user should see {string}.")
    public void verifyThatTheUserShouldSee(String expectedMessage) {
        BrowserUtils.waitForVisibility(assetPage.availableNameMessage, 15);
        String actualMessage = assetPage.availableNameMessage.getText();
        System.out.println("actualMessage = " + actualMessage);
        assertEquals(expectedMessage, actualMessage);
    }

    @When("User can select asset type.")
    public void userCanSelectAssetType() {
        BrowserUtils.waitForClickability(assetPage.assetTypeDropDownMenuButton, 15);
        assetPage.assetTypeDropDownMenuButton.click();
        BrowserUtils.waitForClickability(assetPage.assetTypeOptions.get(0), 15);
        assetPage.assetTypeOptions.get(0).click();
    }

    @And("User can click submit button.\\(Asset)")
    public void userCanClickSubmitButtonAsset() {
        BrowserUtils.waitForClickability(servicePointsPage.linkAssetSubmitButton, 15);
        servicePointsPage.linkAssetSubmitButton.click();

    }

    @Then("Verify that the user should see success message.\\(Asset)")
    public void verifyThatTheUserShouldSeeSuccessMessageAsset() {
        BrowserUtils.waitForVisibility(assetPage.successMessageAsset, 15);
        String successMessage = assetPage.successMessageAsset.getText();
        System.out.println("successMessage = " + successMessage);
        assertTrue(assetPage.successMessageAsset.isDisplayed());
    }

    @And("Verify that the user should be see asset name in table.")
    public void verifyThatTheUserShouldBeSeeAssetNameInTable() {
        BrowserUtils.waitForVisibility(assetPage.baseTableFirstRow, 15);
        String actualAssetName = assetPage.baseTableFirstRow.getText();
        System.out.println("actualAssetName = " + actualAssetName);
        assertEquals(name, actualAssetName);
    }

    @And("User can click see more detail.")
    public void userCanClickSeeMoreDetail() {
        BrowserUtils.waitForClickability(assetPage.treeDotMenuOptions.get(0), 15);
        assetPage.treeDotMenuOptions.get(0).click();
    }

    @Then("Verify that the user should on the {string} page.")
    public void verifyThatTheUserShouldOnThePage(String expectedHeader) {
        assetPage.verifyHeader(expectedHeader, assetPage.assetDetailsHeader);
    }

    @Then("Verify that the user should see {string} option.")
    public void verifyThatTheUserShouldSeeOption(String expectedOptionText) {
        BrowserUtils.waitForVisibility(assetPage.assetDetailsTreeDotMenuOption, 15);
        String actualOptionText = assetPage.assetDetailsTreeDotMenuOption.getText();
        assertEquals(expectedOptionText, actualOptionText);

    }

    @And("Verify that the user should see following options.\\(AssetSMD)")
    public void verifyThatTheUserShouldSeeFollowingOptionsAssetSMD(List<String> expectedTabHeader) {
        for (int i = 0; i < assetPage.smdTabList.size(); i++) {
            BrowserUtils.waitForVisibility(assetPage.smdTabList.get(i), 15);
            String actualTabHeader = assetPage.smdTabList.get(i).getText();
            System.out.println("actualTabHeader = " + actualTabHeader);
            assertEquals(expectedTabHeader.get(i), actualTabHeader);

        }

    }

    @And("Verify that the user should see following options.\\(AssetTable)")
    public void verifyThatTheUserShouldSeeFollowingOptionsAssetTable(List<String> expectedTableTabHeader) {
        for (int i = 0; i < assetPage.smdTableTabList.size(); i++) {
            BrowserUtils.waitForVisibility(assetPage.smdTableTabList.get(i), 15);
            String actualTabHeader = assetPage.smdTableTabList.get(i).getText();
            System.out.println("actualTableTabHeader = " + actualTabHeader);
            assertEquals(expectedTableTabHeader.get(i), actualTabHeader);

        }

    }

    @And("User can click edit asset.")
    public void userCanClickEditAsset() {
        BrowserUtils.waitForClickability(assetPage.treeDotMenuOptions.get(1), 15);
        assetPage.treeDotMenuOptions.get(1).click();
    }

    @Then("Verify that the user should on the {string} page.\\(EA)")
    public void verifyThatTheUserShouldOnThePageEA(String expectedHeader) {
        assetPage.verifyHeader(expectedHeader, assetPage.editAssetHeader);

    }

    @When("User can edit asset type.")
    public void userCanEditAssetType() {
        BrowserUtils.waitForVisibility(assetPage.assetTypeInput, 15);
        oldAssetType = assetPage.assetTypeInput.getText();
        System.out.println("OldAssetType = " + oldAssetType);
        BrowserUtils.waitForClickability(assetPage.assetTypeDropDownMenuButton, 15);
        assetPage.assetTypeDropDownMenuButton.click();
        BrowserUtils.waitForClickability(assetPage.assetTypeOptions.get(1), 15);
        assetPage.assetTypeOptions.get(1).click();


    }

    @And("Verify that the user should be see edited asset type in table.")
    public void verifyThatTheUserShouldBeSeeEditedAssetTypeInTable() {
        BrowserUtils.waitForVisibility(assetPage.assetTypeFirstRowTable, 15);
        String actualAssetType = assetPage.assetTypeFirstRowTable.getText();
        System.out.println("actualAssetType = " + actualAssetType);
        assertNotEquals(oldAssetType, actualAssetType);

    }

    @And("User can click attach device.")
    public void userCanClickAttachDevice() {
        BrowserUtils.waitForVisibility(assetPage.treeDotMenuOptions.get(2), 15);
        assetPage.treeDotMenuOptions.get(2).click();

    }

    @Then("Verify that the user should see {string} header.\\(AD)")
    public void verifyThatTheUserShouldSeeHeaderAD(String expectedHeader) {
        assetPage.verifyHeader(expectedHeader, assetPage.attachDeviceHeader);

    }

    @When("User can select device type.")
    public void userCanSelectDeviceType() {
        BrowserUtils.waitForClickability(assetPage.deviceTypeSelectButton, 15);
        assetPage.deviceTypeSelectButton.click();
        BrowserUtils.waitForClickability(assetPage.gsmUG03DeviceType, 15);
        assetPage.gsmUG03DeviceType.click();
    }

    @And("User can enter {string} in device id box")
    public void userCanEnterInDeviceIdBox(String deviceID) {
        expectedDeviceID = deviceID;
        assetPage.deviceIdSearchBox.click();
        assetPage.deviceIdSearchBoxInput.sendKeys(deviceID);
        BrowserUtils.waitFor(2);

    }

    @And("User can select device id.")
    public void userCanSelectDeviceId() {
        BrowserUtils.waitForClickability(assetPage.deviceIdOption, 15);
        assetPage.deviceIdOption.click();

    }

    @Then("Verify that the user should see success message.\\(AD)")
    public void verifyThatTheUserShouldSeeSuccessMessageAD() {
        BrowserUtils.waitForVisibility(assetPage.successMessageAttachDevice, 15);
        System.out.println("Success Message = " + assetPage.successMessageAttachDevice.getText());
        assertTrue(assetPage.successMessageAttachDevice.isDisplayed());

    }

    @And("Verify that the user should see device id in devices table.")
    public void verifyThatTheUserShouldSeeDeviceIdInDevicesTable() {
        BrowserUtils.waitForVisibility(assetPage.baseTableFirstRow, 15);
        String actualDeviceId = assetPage.baseTableFirstRow.getText();
        assertEquals(expectedDeviceID, actualDeviceId);

    }

    @When("User can click delete button.")
    public void userCanClickDeleteButton() {
        BrowserUtils.scrollToElement(assetPage.deleteButtonDeviceTable);
        BrowserUtils.waitForClickability(assetPage.deleteButtonDeviceTable, 15);
        assetPage.deleteButtonDeviceTable.click();
    }

    @Then("Verify that the user should see {string} warning message.")
    public void verifyThatTheUserShouldSeeWarningMessage(String expectedMessage) {
        BrowserUtils.waitForVisibility(assetPage.warningMessageAfterDelete, 15);
        String actualMessage = assetPage.warningMessageAfterDelete.getText();
        System.out.println("actualMessage = " + actualMessage);
        assertEquals(expectedMessage, actualMessage);

    }


}
