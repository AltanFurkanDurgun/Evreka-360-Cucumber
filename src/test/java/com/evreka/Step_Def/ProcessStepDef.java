package com.evreka.Step_Def;

import com.evreka.Pages.ProcessPage;
import com.evreka.Utilies.BrowserUtils;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static org.junit.Assert.*;


public class ProcessStepDef {

    ProcessPage processPage = new ProcessPage();

    Faker faker = new Faker();

    String processName, expectedEditedName;

    @And("User can click process option.")
    public void userCanClickProcessOption() {
        BrowserUtils.waitForClickability(processPage.mrfManagementOptions.get(2), 15);
        processPage.mrfManagementOptions.get(2).click();

    }

    @Then("Verify that the user should on the process page.")
    public void verifyThatTheUserShouldOnTheProcessPage() {
        processPage.verifyHeader("Process", processPage.processHeader);
    }

    @When("User can click add process.")
    public void userCanClickAddProcess() {
        BrowserUtils.waitForClickability(processPage.addProcessButton, 15);
        processPage.addProcessButton.click();
    }

    @Then("Verify that the user should see {string} header.\\(addProcess)")
    public void verifyThatTheUserShouldSeeHeaderAddProcess(String expectedHeader) {
        processPage.verifyHeader(expectedHeader, processPage.addProcessHeader);
    }

    @When("User can enter process name.")
    public void userCanEnterProcessName() {
        processName = faker.name().firstName();
        processPage.processNameInput.sendKeys(processName);

    }

    @When("User can select process type.")
    public void userCanSelectProcessType() {
        BrowserUtils.waitForClickability(processPage.processTypeSelectButton, 15);
        processPage.processTypeSelectButton.click();
        BrowserUtils.waitFor(1);
        BrowserUtils.waitForClickability(processPage.processTypeOption, 15);
        processPage.processTypeOption.click();
    }

    @Then("Verify that the added process appears in the process table.")
    public void verifyThatTheAddedProcessAppearsInTheProcessTable() {
        BrowserUtils.waitForVisibility(processPage.baseTableFirstRow, 15);
        String expectedProcessName = processName;
        System.out.println("expectedProcessName = " + expectedProcessName);
        String actualProcessName = processPage.baseTableFirstRow.getText();
        System.out.println("actualProcessName = " + actualProcessName);
        assertEquals(expectedProcessName, actualProcessName);


    }

    @And("User can click see more detail.\\(process)")
    public void userCanClickSeeMoreDetailProcess() {
        BrowserUtils.waitForClickability(processPage.treeDotMenuOptions.get(0), 15);
        processPage.treeDotMenuOptions.get(0).click();
    }

    @Then("Verify that the user should on the {string} page.\\(process)")
    public void verifyThatTheUserShouldOnThePageProcess(String expectedHeader) {
        processPage.verifyHeader(expectedHeader, processPage.processHeader);
    }

    @Then("Verify that the user should see following options.\\(processStatus)")
    public void verifyThatTheUserShouldSeeFollowingOptionsProcessStatus(List<String> expectedAllStatusOptions) {
        BrowserUtils.waitForVisibility(processPage.allStatusOptions.get(0), 15);
        for (int i = 0; i < processPage.allStatusOptions.size(); i++) {
            String actualStatus = processPage.allStatusOptions.get(i).getText();
            System.out.println("actualStatus = " + actualStatus);
            assertEquals(expectedAllStatusOptions.get(i), actualStatus);

        }

    }

    @Then("Verify that the user should see following options.\\(process)")
    public void verifyThatTheUserShouldSeeFollowingOptionsProcess(List<String> expectedAllOptions) {

        BrowserUtils.waitForVisibility(processPage.processDetailsTreeDotOptions.get(0), 15);
        for (int i = 0; i < processPage.processDetailsTreeDotOptions.size(); i++) {
            String actualOptions = processPage.processDetailsTreeDotOptions.get(i).getText();
            System.out.println("actualOptions = " + actualOptions);
            assertEquals(expectedAllOptions.get(i), actualOptions);

        }


    }

    @And("Verify that the user should see {string} tab.")
    public void verifyThatTheUserShouldSeeTab(String expectedTabHeader) {

        processPage.verifyHeader(expectedTabHeader, processPage.smdTabList.get(0));

    }

    @And("Verify that the user should see following options.\\(processTableTab)")
    public void verifyThatTheUserShouldSeeFollowingOptionsProcessTableTab(List<String> allTableTabHeader) {
        BrowserUtils.waitForVisibility(processPage.smdTableTabList.get(0), 15);
        for (int i = 0; i < processPage.smdTableTabList.size(); i++) {
            String actualOptions = processPage.smdTableTabList.get(i).getText();
            System.out.println("actualOptions = " + actualOptions);
            assertEquals(allTableTabHeader.get(i), actualOptions);

        }


    }

    @Then("Verify that the user should see success message.\\(process)")
    public void verifyThatTheUserShouldSeeSuccessMessageProcess() {
        BrowserUtils.waitForVisibility(processPage.processSuccessMessage, 15);
        String actualMessage = processPage.processSuccessMessage.getText();
        System.out.println("actualMessage = " + actualMessage);
        assertTrue(processPage.processSuccessMessage.isDisplayed());
    }

    @And("User can click edit process.")
    public void userCanClickEditProcess() {
        BrowserUtils.waitForClickability(processPage.treeDotMenuOptions.get(1), 15);
        processPage.treeDotMenuOptions.get(1).click();
    }

    @Then("Verify that the user should see {string} header.\\(process)")
    public void verifyThatTheUserShouldSeeHeaderProcess(String expectedHeader) {
        processPage.verifyHeader(expectedHeader, processPage.editProcessHeader);

    }

    @When("User can edit process name.")
    public void userCanEditProcessName() {
        processPage.processNameInput.sendKeys("_edit");
        expectedEditedName = processPage.processNameInput.getAttribute("value");
        System.out.println("expectedEditedName = " + expectedEditedName);
    }

    @And("Verify that the user should see not enable process type.")
    public void verifyThatTheUserShouldSeeNotEnableProcessType() {

        assertFalse(processPage.processTypeInput.isEnabled());

    }

    @And("Verify that the user should be see edited process name in table.")
    public void verifyThatTheUserShouldBeSeeEditedProcessNameInTable() {
        BrowserUtils.waitForVisibility(processPage.baseTableFirstRow, 15);
        String actualEditedProcessName = processPage.baseTableFirstRow.getText();
        System.out.println("actualEditedProcessName = " + actualEditedProcessName);
        assertEquals(expectedEditedName, actualEditedProcessName);
    }

    @And("User can click delete process.")
    public void userCanClickDeleteProcess() {
        BrowserUtils.waitForClickability(processPage.treeDotMenuOptions.get(3), 15);
        processPage.treeDotMenuOptions.get(3).click();
    }

    @Then("Verify that the user should see {string} header.\\(deleteProcess)")
    public void verifyThatTheUserShouldSeeHeaderDeleteProcess(String expectedHeader) {

        processPage.verifyHeader(expectedHeader, processPage.deleteProcessHeader);
    }


    @Then("Verify that the user should see {string} deleted message.\\(deleteProcess)")
    public void verifyThatTheUserShouldSeeDeletedMessageDeleteProcess(String expectedMessage) {
        BrowserUtils.waitForVisibility(processPage.processDeletedMessage,15);
        String actualMessage = processPage.processDeletedMessage.getText();
        System.out.println("actualMessage = " + actualMessage);
        assertEquals(expectedMessage,actualMessage);
    }
}
