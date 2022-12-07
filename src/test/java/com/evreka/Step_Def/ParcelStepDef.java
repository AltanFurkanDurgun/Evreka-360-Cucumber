package com.evreka.Step_Def;

import com.evreka.Pages.ParcelPage;
import com.evreka.Utilies.BrowserUtils;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static org.junit.Assert.*;

public class ParcelStepDef {

    ParcelPage parcelPage = new ParcelPage();

    Faker faker = new Faker();

    String expectedParcelName, editedParcelName, updateTareWeight;
    int grossWeight;

    @And("User can click parcel option.")
    public void userCanClickParcelOption() {
        BrowserUtils.waitForClickability(parcelPage.mrfManagementOptions.get(1), 15);
        parcelPage.mrfManagementOptions.get(1).click();
    }

    @Then("Verify that the user should on the parcel page.")
    public void verifyThatTheUserShouldOnTheParcelPage() {
        parcelPage.verifyHeader("Parcel", parcelPage.parcelHeader);
    }

    @When("User can click add parcel button.")
    public void userCanClickAddParcelButton() {
        BrowserUtils.waitForClickability(parcelPage.addParcelButton, 15);
        parcelPage.addParcelButton.click();
    }

    @Then("Verify that the user should on the {string} page.\\(addParcel)")
    public void verifyThatTheUserShouldOnThePageAddParcel(String expectedHeader) {
        parcelPage.verifyHeader(expectedHeader, parcelPage.addParcelHeader);

    }

    @When("User can enter name.\\(addParcel)")
    public void userCanEnterNameAddParcel() {
        expectedParcelName = faker.country().name();
        parcelPage.parcelNameBox.sendKeys(expectedParcelName);

    }

    @And("User can select parcel type.")
    public void userCanSelectParcelType() {
        BrowserUtils.waitForClickability(parcelPage.parcelTypeSelectButton, 15);
        parcelPage.parcelTypeSelectButton.click();
        BrowserUtils.waitFor(1);
        BrowserUtils.waitForClickability(parcelPage.parcelTypeOptions.get(0), 15);
        parcelPage.parcelTypeOptions.get(0).click();
    }

    @And("User can select collection scheme type.")
    public void userCanSelectCollectionSchemeType() {
        BrowserUtils.waitForClickability(parcelPage.collectionSchemeSelectButton, 15);
        parcelPage.collectionSchemeSelectButton.click();
        BrowserUtils.waitFor(1);
        BrowserUtils.waitForClickability(parcelPage.typeOption, 15);
        parcelPage.typeOption.click();
    }

    @And("User can select asset type.\\(addParcel)")
    public void userCanSelectAssetTypeAddParcel() {

        BrowserUtils.waitForClickability(parcelPage.assetTypeSelectButton, 15);
        parcelPage.assetTypeSelectButton.click();
        BrowserUtils.waitFor(1);
        BrowserUtils.waitForClickability(parcelPage.typeOption, 15);
        parcelPage.typeOption.click();
    }

    @Then("Verify that the user should see success message.\\(addParcel)")
    public void verifyThatTheUserShouldSeeSuccessMessageAddParcel() {

        BrowserUtils.waitForVisibility(parcelPage.successMessageParcel, 15);
        String successMessage = parcelPage.successMessageParcel.getText();
        System.out.println("successMessage = " + successMessage);
        assertTrue(parcelPage.successMessageParcel.isDisplayed());


    }

    @And("Verify that the user should be see parcel name in table.")
    public void verifyThatTheUserShouldBeSeeParcelNameInTable() {
        BrowserUtils.waitForVisibility(parcelPage.baseTableFirstRow, 15);
        String actualParcelName = parcelPage.baseTableFirstRow.getText();
        System.out.println("actualParcelName = " + actualParcelName);
        assertEquals(expectedParcelName, actualParcelName);
    }


    @Then("Verify that the user should see {string} header.\\(SMDParcel)")
    public void verifyThatTheUserShouldSeeHeaderSMDParcel(String expectedHeader) {
        parcelPage.verifyHeader(expectedHeader, parcelPage.parcelHeader);
    }

    @Then("Verify that the user should see following options.\\(smdParcel)")
    public void verifyThatTheUserShouldSeeFollowingOptionsSmdParcel(List<String> expectedAllOptions) {
        for (int i = 0; i < parcelPage.seeMoreDetailPageTreeDotOptions.size(); i++) {
            BrowserUtils.waitForVisibility(parcelPage.seeMoreDetailPageTreeDotOptions.get(i), 15);
            String actualOptions = parcelPage.seeMoreDetailPageTreeDotOptions.get(i).getText();
            System.out.println("actualTabHeader = " + actualOptions);
            assertEquals(expectedAllOptions.get(i), actualOptions);
        }

    }

    @And("Verify that the user should see following options.\\(tabHeader)")
    public void verifyThatTheUserShouldSeeFollowingOptionsTabHeader(List<String> expectedAllTabHeaders) {
        for (int i = 0; i < parcelPage.smdTabList.size(); i++) {
            BrowserUtils.waitForVisibility(parcelPage.smdTabList.get(i), 15);
            String actualTabHeader = parcelPage.smdTabList.get(i).getText();
            System.out.println("actualTabHeader = " + actualTabHeader);
            assertEquals(expectedAllTabHeaders.get(i), actualTabHeader);
        }

    }

    @And("Verify that the user should see following options.\\(tableTabHeader)")
    public void verifyThatTheUserShouldSeeFollowingOptionsTableTabHeader(List<String> expectedAllTableTabHeaders) {
        for (int i = 0; i < parcelPage.smdTableTabList.size(); i++) {
            BrowserUtils.waitForVisibility(parcelPage.smdTableTabList.get(i), 15);
            String actualTableTabHeader = parcelPage.smdTableTabList.get(i).getText();
            System.out.println("actualTabHeader = " + actualTableTabHeader);
            assertEquals(expectedAllTableTabHeaders.get(i), actualTableTabHeader);
        }

    }

    @And("User can click edit parcel.")
    public void userCanClickEditParcel() {
        BrowserUtils.waitForClickability(parcelPage.treeDotMenuOptions.get(1), 15);
        parcelPage.treeDotMenuOptions.get(1).click();
    }

    @Then("Verify that the user should on the {string} page.\\(editParcel)")
    public void verifyThatTheUserShouldOnThePageEditParcel(String expectedHeader) {
        parcelPage.verifyHeader(expectedHeader, parcelPage.editParcelHeader);
    }

    @When("User can edit parcel name.")
    public void userCanEditParcelName() {
        parcelPage.parcelNameBox.sendKeys("_edit");
        editedParcelName = parcelPage.parcelNameBox.getAttribute("value");
        System.out.println("editedParcelName = " + editedParcelName);
    }

    @And("Verify that the user should be see edited parcel name in table.")
    public void verifyThatTheUserShouldBeSeeEditedParcelNameInTable() {

        BrowserUtils.waitForVisibility(parcelPage.baseTableFirstRow, 15);
        String actualEditedParcelName = parcelPage.baseTableFirstRow.getText();
        assertEquals(editedParcelName, actualEditedParcelName);


    }

    @And("User can click update weight.")
    public void userCanClickUpdateWeight() {
        BrowserUtils.waitForClickability(parcelPage.treeDotMenuOptions.get(3), 15);
        parcelPage.treeDotMenuOptions.get(3).click();
    }

    @Then("Verify that the user should see {string} header\\(updateWeight).")
    public void verifyThatTheUserShouldSeeHeaderUpdateWeight(String expectedHeader) {
        parcelPage.verifyHeader(expectedHeader, parcelPage.updateWeightHeader);
    }

    @When("User can edit tare weight.")
    public void userCanEditTareWeight() {
        grossWeight = Integer.parseInt(parcelPage.grossWeight.getAttribute("value"));
        System.out.println("grossWeight = " + grossWeight);
        int tareWeight = Integer.parseInt(parcelPage.tareWeightBox.getAttribute("value"));
        System.out.println("tareWeight = " + tareWeight);
        BrowserUtils.cleanBox(parcelPage.tareWeightBox);
        updateTareWeight = String.valueOf(tareWeight - 1);
        parcelPage.tareWeightBox.sendKeys(updateTareWeight);

    }

    @Then("Verify that the user should see net weight count.")
    public void verifyThatTheUserShouldSeeNetWeightCount() {
        BrowserUtils.waitForVisibility(parcelPage.netWeight, 15);
        int totalNetWeight = grossWeight - Integer.parseInt(updateTareWeight);
        System.out.println("totalNetWeight = " + totalNetWeight);
        String actualNetWeight = parcelPage.netWeight.getText().replace("kg", "").trim();
        System.out.println("actualNetWeight = " + actualNetWeight);
        String expectedNetWeight = String.valueOf(totalNetWeight);
        assertEquals(expectedNetWeight, actualNetWeight);

    }

    @And("User can click delete parcel.")
    public void userCanClickDeleteParcel() {
        BrowserUtils.waitForClickability(parcelPage.treeDotMenuOptions.get(5), 15);
        parcelPage.treeDotMenuOptions.get(5).click();
    }

    @Then("Verify that the user should see {string} header.\\(deleteParcel)")
    public void verifyThatTheUserShouldSeeHeaderDeleteParcel(String expectedHeader) {
        parcelPage.verifyHeader(expectedHeader, parcelPage.deleteParcelHeader);

    }

    @Then("Verify that the user should see {string} deleted message.")
    public void verifyThatTheUserShouldSeeDeletedMessage(String expectedMessage) {

        BrowserUtils.waitForVisibility(parcelPage.deleteSuccessMessage, 15);
        String actualMessage = parcelPage.deleteSuccessMessage.getText();
        System.out.println("actualMessage = " + actualMessage);
        assertEquals(expectedMessage, actualMessage);

    }
}
