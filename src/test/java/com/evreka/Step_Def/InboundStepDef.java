package com.evreka.Step_Def;

import com.evreka.Pages.InboundPage;
import com.evreka.Utilies.BrowserUtils;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static org.junit.Assert.*;


public class InboundStepDef {
    InboundPage inboundPage = new InboundPage();

    Faker faker = new Faker();

    String expectedInboundName,expectedEditedInboundName;

    @Then("Verify that the user should see following options.\\(mrf)")
    public void verifyThatTheUserShouldSeeFollowingOptionsMrf(List<String> allMenuOptions) {
        BrowserUtils.waitForVisibility(inboundPage.mrfManagementOptions.get(0),15);
        for (int i = 0; i < inboundPage.mrfManagementOptions.size(); i++) {
            BrowserUtils.waitForVisibility(inboundPage.mrfManagementOptions.get(i), 15);
            String actualMenuOptions = inboundPage.mrfManagementOptions.get(i).getText();
            System.out.println("actualMenuOpions = " + actualMenuOptions);
            assertEquals(allMenuOptions.get(i), actualMenuOptions);

        }

    }

    @When("User can click add inbound button.")
    public void userCanClickAddInboundButton() {
        BrowserUtils.waitForClickability(inboundPage.addInboundButton, 15);
        inboundPage.addInboundButton.click();
    }

    @Then("Verify that the user on the {string} page.\\(inbound)")
    public void verifyThatTheUserOnThePageInbound(String expectedHeader) {
        inboundPage.verifyHeader(expectedHeader, inboundPage.addInboundHeader);

    }

    @When("User can enter name.\\(inbound)")
    public void userCanEnterNameInbound() {
        BrowserUtils.waitForVisibility(inboundPage.nameBoxAddInbound, 15);
        expectedInboundName = faker.name().firstName();
        inboundPage.nameBoxAddInbound.sendKeys(expectedInboundName);

    }

    @And("User can select facility.")
    public void userCanSelectFacility() {
        BrowserUtils.waitForClickability(inboundPage.facilitySelectButton, 15);
        inboundPage.facilitySelectButton.click();
        BrowserUtils.waitFor(1);
        BrowserUtils.waitForClickability(inboundPage.facilityOption, 15);
        inboundPage.facilityOption.click();
    }

    @And("User can select material type.")
    public void userCanSelectMaterialType() {
        BrowserUtils.waitForClickability(inboundPage.materialTypeSelectButton, 15);
        inboundPage.materialTypeSelectButton.click();
        BrowserUtils.waitForClickability(inboundPage.materialTypeOption, 15);
        inboundPage.materialTypeOption.click();
    }

    @And("User can enter gross weight.")
    public void userCanEnterGrossWeight() {
        inboundPage.grossWeightBox.sendKeys("12");

    }

    @And("User can enter tare weight.")
    public void userCanEnterTareWeight() {
        inboundPage.tareWeightBox.sendKeys("4");
    }

    @Then("Verify that the user should see {string} success message.\\(inbound)")
    public void verifyThatTheUserShouldSeeSuccessMessageInbound(String expectedMessage) {
        BrowserUtils.waitForVisibility(inboundPage.successMessage, 15);
        String actualMessage = inboundPage.successMessage.getText();
        System.out.println("actualMessage = " + actualMessage);
        assertEquals(expectedMessage, actualMessage);


    }

    @And("Verify that the user should see inbound name in inbound table.")
    public void verifyThatTheUserShouldSeeInboundNameInInboundTable() {
        BrowserUtils.waitForVisibility(inboundPage.baseTableFirstRow, 15);
        String actualInboundName = inboundPage.baseTableFirstRow.getText();
        System.out.println("actualInboundName = " + actualInboundName);
        assertEquals(expectedInboundName, actualInboundName);

    }

    @Then("Verify that the user should on the {string} page.\\(SMDInbound)")
    public void verifyThatTheUserShouldOnThePageSMDInbound(String expectedHeader) {
        inboundPage.verifyHeader(expectedHeader, inboundPage.inboundHeader);
    }

    @When("User can click status button.\\(inbound)")
    public void userCanClickStatusButtonInbound() {
        BrowserUtils.waitForClickability(inboundPage.statusButton, 15);
        inboundPage.statusButton.click();
    }

    @Then("Verify that the user should see following options.\\(inbound)")
    public void verifyThatTheUserShouldSeeFollowingOptionsInbound(List<String> expectedAllStatus) {
        BrowserUtils.waitForVisibility(inboundPage.allStatus.get(0), 15);
        for (int i = 0; i < inboundPage.allStatus.size(); i++) {
            System.out.println("Status = " + inboundPage.allStatus.get(i).getText());
            assertEquals(expectedAllStatus.get(i), inboundPage.allStatus.get(i).getText());

        }

    }

    @When("User can click inbound tree dot button.")
    public void userCanClickInboundTreeDotButton() {
        BrowserUtils.waitForClickability(inboundPage.treeDotButton, 15);
        inboundPage.treeDotButton.click();
    }

    @Then("Verify that the user should see {string} option.\\(inbound)")
    public void verifyThatTheUserShouldSeeOptionInbound(String expectedOption) {
        BrowserUtils.waitForVisibility(inboundPage.treeDotOptionInbound, 15);
        String actualOption = inboundPage.treeDotOptionInbound.getText();
        System.out.println("actualOption = " + actualOption);
        assertEquals(expectedOption, actualOption);

    }

    @And("Verify that the user should see following options.\\(inboundTab)")
    public void verifyThatTheUserShouldSeeFollowingOptionsInboundTab(List<String> expectedTabHeader) {
        BrowserUtils.waitForVisibility(inboundPage.smdTabList.get(0), 15);
        for (int i = 0; i < inboundPage.smdTabList.size(); i++) {
            String actualTabHeader = inboundPage.smdTabList.get(i).getText();
            System.out.println("actualTabHeader = " + actualTabHeader);
            assertEquals(expectedTabHeader.get(i), actualTabHeader);
        }


    }

    @When("User can click all tab headers.\\(inbound)")
    public void userCanClickAllTabHeadersInbound() {
        for (int i = 0; i < inboundPage.smdTabList.size(); i++) {
            BrowserUtils.waitForClickability(inboundPage.smdTabList.get(i), 15);
            inboundPage.smdTabList.get(i).click();

        }


    }

    @And("Verify that the user should see following options.\\(inboundTable)")
    public void verifyThatTheUserShouldSeeFollowingOptionsInboundTable(List<String> expectedTableTabHeader) {

        BrowserUtils.waitForVisibility(inboundPage.smdTableTabList.get(0), 15);
        for (int i = 0; i < inboundPage.smdTableTabList.size(); i++) {
            BrowserUtils.waitForVisibility(inboundPage.smdTableTabList.get(i), 15);
            String actualTableTabHeader = inboundPage.smdTableTabList.get(i).getText();
            System.out.println("actualTableTabHeader = " + actualTableTabHeader);
            assertEquals(expectedTableTabHeader.get(i), actualTableTabHeader);

        }
    }

    @When("User can click all table tab headers.\\(inbound)")
    public void userCanClickAllTableTabHeadersInbound() {

        BrowserUtils.waitForVisibility(inboundPage.smdTableTabList.get(0), 15);
        for (int i = 0; i < inboundPage.smdTableTabList.size(); i++) {
            BrowserUtils.waitForClickability(inboundPage.smdTableTabList.get(i), 15);
            inboundPage.smdTableTabList.get(i).click();

        }
    }

    @Then("Verify that the user should see {string} message.\\(inbound)")
    public void verifyThatTheUserShouldSeeMessageInbound(String expectedMessage) {
        BrowserUtils.waitForVisibility(inboundPage.availableMessageEditInbound,15);
        String actualMessage = inboundPage.availableMessageEditInbound.getText();
        System.out.println("actualMessage = " + actualMessage);
        assertEquals(expectedMessage,actualMessage);
    }

    @And("User can click edit inbound.")
    public void userCanClickEditInbound() {
        BrowserUtils.waitForClickability(inboundPage.treeDotMenuOptions.get(1),15);
        inboundPage.treeDotMenuOptions.get(1).click();
    }

    @Then("Verify that the user should on the {string} page.\\(inbound)")
    public void verifyThatTheUserShouldOnThePageInbound(String expectedHeader) {

        BrowserUtils.waitForVisibility(inboundPage.editInboundHeader,15);
        String actualHeader = inboundPage.editInboundHeader.getText();
        System.out.println("actualHeader = " + actualHeader);
        assertEquals(expectedHeader,actualHeader);

    }

    @When("User can edit name.")
    public void userCanEditName() {
        inboundPage.nameBoxAddInbound.sendKeys("_edit");
        expectedEditedInboundName = inboundPage.nameBoxAddInbound.getAttribute("value");
        System.out.println("expectedEditedInboundName = " + expectedEditedInboundName);

    }

    @Then("Verify that the edited inbound appears in the inbound table.")
    public void verifyThatTheEditedInboundAppearsInTheInboundTable() {
        BrowserUtils.waitForVisibility(inboundPage.baseTableFirstRow,15);
        String actualEditedInboundName=inboundPage.baseTableFirstRow.getText();
        System.out.println("actualEditedInboundName = " + actualEditedInboundName);
        assertEquals(expectedEditedInboundName,actualEditedInboundName);

    }

    @And("User can click delete inbound.")
    public void userCanClickDeleteInbound() {
        BrowserUtils.waitForClickability(inboundPage.treeDotMenuOptions.get(3),15);
        inboundPage.treeDotMenuOptions.get(3).click();
    }

    @Then("Verify that the user should see {string} header.\\(inbound)")
    public void verifyThatTheUserShouldSeeHeaderInbound(String expectedHeader) {
        BrowserUtils.waitForVisibility(inboundPage.deleteInboundHeader,15);
        String actualHeader = inboundPage.deleteInboundHeader.getText();
        System.out.println("actualHeader = " + actualHeader);
        assertEquals(expectedHeader,actualHeader);
    }

    @And("Verify that the user should see {string} warning message.\\(inbound)")
    public void verifyThatTheUserShouldSeeWarningMessageInbound(String expectedMessage) {
        BrowserUtils.waitForVisibility(inboundPage.deleteInboundWarningMessage,15);
        String actualMessage = inboundPage.deleteInboundWarningMessage.getText();
        System.out.println("actualMessage = " + actualMessage);
        assertEquals(expectedMessage,actualMessage);
    }

    @Then("Verify that the user should see {string} message.\\(inboundDelete)")
    public void verifyThatTheUserShouldSeeMessageInboundDelete(String expectedMessage) {
        BrowserUtils.waitForVisibility(inboundPage.deleteSuccessMessage,15);
        String actualMessage = inboundPage.deleteSuccessMessage.getText();
        System.out.println("actualMessage = " + actualMessage);
        assertEquals(expectedMessage,actualMessage);
    }
}
