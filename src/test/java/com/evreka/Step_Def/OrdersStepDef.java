package com.evreka.Step_Def;

import com.evreka.Pages.DocumentsPage;
import com.evreka.Pages.HomePage;
import com.evreka.Pages.InboundPage;
import com.evreka.Pages.OrdersPage;
import com.evreka.Utilies.BrowserUtils;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static org.junit.Assert.*;

public class OrdersStepDef {

    OrdersPage ordersPage = new OrdersPage();

    InboundPage inboundPage = new InboundPage();

    HomePage homePage = new HomePage();

    DocumentsPage documentsPage = new DocumentsPage();

    Faker faker = new Faker();
    String orderName, inboundName, orderNameForDocuments,actualMessage;

    @When("User can click Orders option.")
    public void userCanClickOrdersOption() {
        BrowserUtils.waitForClickability(ordersPage.engagementOptions.get(2), 15);
        ordersPage.engagementOptions.get(2).click();
    }

    @Then("Verify that the user should see following options.\\(orders)")
    public void verifyThatTheUserShouldSeeFollowingOptionsOrders(List<String> expectedTabHeaders) {
        for (int i = 0; i < ordersPage.allTabHeaderOrders.size(); i++) {
            BrowserUtils.waitForVisibility(ordersPage.allTabHeaderOrders.get(i), 15);
            System.out.println("Actual tab headers = " + ordersPage.allTabHeaderOrders.get(i).getText());
            assertEquals(expectedTabHeaders.get(i), ordersPage.allTabHeaderOrders.get(i).getText());

        }
    }

    @And("User can enter order name in order name box.\\(orders)")
    public void userCanEnterOrderNameInOrderNameBoxOrders() {
        orderName = faker.name().firstName();
        ordersPage.orderNameBox.sendKeys(orderName);
    }

    @When("User can click add ad hoc order button.\\(orders)")
    public void userCanClickAddAdHocOrderButtonOrders() {
        BrowserUtils.waitForClickability(ordersPage.addAdHocOrderButton, 15);
        ordersPage.addAdHocOrderButton.click();
    }

    @Then("Verify that user should be see {string} message.\\(orders)")
    public void verifyThatUserShouldBeSeeMessageOrders(String statusMessage) {
        BrowserUtils.waitForVisibility(ordersPage.successMessage, 15);
        String expectedMessage = "Successfully " + statusMessage + " Order (" + orderName + ")\n" +
                " See More Details ";
        System.out.println("actualSuccessMessage = " + ordersPage.successMessage.getText());
        assertEquals(expectedMessage, ordersPage.successMessage.getText());
    }


    @Then("Verify that the user should be see the created order name appear in the table.\\(orders)")
    public void verifyThatTheUserShouldBeSeeTheCreatedOrderNameAppearInTheTableOrders() {

        BrowserUtils.waitForVisibility(ordersPage.baseTableFirstRow, 15);
        String actualOrderName = ordersPage.baseTableFirstRow.getText();
        System.out.println("actualOrderName = " + actualOrderName);
        String expectedOrderName = orderName;
        assertEquals(expectedOrderName, actualOrderName);
    }

    @Then("Verify that the user should on the order details page.")
    public void verifyThatTheUserShouldOnTheOrderDetailsPage() {
        ordersPage.verifyHeader("Order Details", ordersPage.orderDetailsHeader);
    }

    @When("User can click status button.\\(orders)")
    public void userCanClickStatusButtonOrders() {
        BrowserUtils.waitForClickability(ordersPage.statusButtonOrderDetails, 15);
        ordersPage.statusButtonOrderDetails.click();
    }

    @Then("Verify that the user should see following status options.")
    public void verifyThatTheUserShouldSeeFollowingStatusOptions(List<String> expectedStatusOptions) {
        for (int i = 0; i < ordersPage.statusOptionsOrderDetails.size(); i++) {
            BrowserUtils.waitForVisibility(ordersPage.statusOptionsOrderDetails.get(i), 15);
            System.out.println("All Status Options = " + ordersPage.statusOptionsOrderDetails.get(i).getText());
            String actualStatusOptions = ordersPage.statusOptionsOrderDetails.get(i).getText();
            assertEquals(expectedStatusOptions.get(i), actualStatusOptions);

        }
    }

    @When("User can click tree dot button.\\(orders)")
    public void userCanClickTreeDotButtonOrders() {
        BrowserUtils.waitForClickability(ordersPage.treeDotButtonOrderDetails, 15);
        ordersPage.treeDotButtonOrderDetails.click();

    }

    @Then("Verify that the user should be see {string} option.")
    public void verifyThatTheUserShouldBeSeeOption(String expectedOption) {
        BrowserUtils.waitForVisibility(ordersPage.treeDotOptionOrderDetails, 15);
        String actualOption = ordersPage.treeDotOptionOrderDetails.getText();
        assertEquals(expectedOption, actualOption);
    }

    @When("User can click all tab headers.\\(orders)")
    public void userCanClickAllTabHeadersOrders() {
        for (int i = 0; i < ordersPage.smdTabList.size(); i++) {
            BrowserUtils.waitForClickability(ordersPage.smdTabList.get(i), 15);
            ordersPage.smdTabList.get(i).click();
            BrowserUtils.waitFor(1);

        }
    }

    @And("User can click all table tab headers.\\(orders)")
    public void userCanClickAllTableTabHeadersOrders() {
        for (int i = 0; i < ordersPage.smdTableTabList.size(); i++) {
            BrowserUtils.waitForClickability(ordersPage.smdTableTabList.get(i), 15);
            ordersPage.smdTableTabList.get(i).click();
            BrowserUtils.waitFor(1);

        }

    }

    @When("User can click MRF Management dropdown menu.")
    public void userCanClickMRFManagementDropdownMenu() {
        BrowserUtils.waitForClickability(homePage.mrfManagementIcon, 15);
        homePage.mrfManagementIcon.click();
        BrowserUtils.waitFor(1);

    }

    @And("User can click inbound option.")
    public void userCanClickInboundOption() {
        BrowserUtils.waitForClickability(inboundPage.mrfManagementOptions.get(0), 15);
        inboundPage.mrfManagementOptions.get(0).click();

    }

    @Then("Verify that the user should on the inbound page.")
    public void verifyThatTheUserShouldOnTheInboundPage() {
        ordersPage.verifyHeader("Inbound", inboundPage.inboundHeader);
    }

    @When("User can check inbound name in inbound table.")
    public void userCanCheckInboundNameInInboundTable() {
        BrowserUtils.waitForVisibility(ordersPage.baseTableFirstRow, 15);
        inboundName = ordersPage.baseTableFirstRow.getText();

    }

    @And("User can click link work order.")
    public void userCanClickLinkWorkOrder() {
        BrowserUtils.waitForClickability(ordersPage.treeDotMenuItems.get(1), 15);
        ordersPage.treeDotMenuItems.get(1).click();

    }

    @When("User can select type.")
    public void userCanSelectType() {
        BrowserUtils.waitForClickability(ordersPage.linkWorkOrderSelectBox, 15);
        ordersPage.linkWorkOrderSelectBox.click();
        BrowserUtils.waitFor(1);
        BrowserUtils.waitForClickability(ordersPage.linkWorkOrderInboundOption, 15);
        ordersPage.linkWorkOrderInboundOption.click();
    }

    @And("User can enter name in name search box.")
    public void userCanEnterNameInNameSearchBox() {
        BrowserUtils.waitForClickability(ordersPage.linkWorkOrderSearchBox, 15);
        ordersPage.linkWorkOrderSearchInput.click();
        ordersPage.linkWorkOrderSearchInput.sendKeys(inboundName);
        BrowserUtils.waitFor(1);
        BrowserUtils.waitForClickability(ordersPage.linkWorkOrderNameFirstOpt, 15);
        ordersPage.linkWorkOrderNameFirstOpt.click();
    }

    @Then("Verify that the user should see {string} message.")
    public void verifyThatTheUserShouldSeeMessage(String expectedMessage) {
        BrowserUtils.waitForVisibility(ordersPage.linkWorkOrderSuccessMessage, 15);
        String actualMessage = ordersPage.linkWorkOrderSuccessMessage.getText();
        System.out.println("actualMessage = " + actualMessage);
        assertEquals(expectedMessage, actualMessage);
    }


    @Then("Verify that the user should see {string} success message.\\(LWO)")
    public void verifyThatTheUserShouldSeeSuccessMessageLWO(String expectedMessage) {
        BrowserUtils.waitForVisibility(ordersPage.successMessage, 15);
        String actualMessage = ordersPage.successMessage.getText();
        System.out.println("actualMessage = " + actualMessage);
        assertTrue(actualMessage.contains(expectedMessage));

    }

    @And("User can click work order.")
    public void userCanClickWorkOrder() {
        BrowserUtils.waitForClickability(ordersPage.smdTableTabList.get(1), 15);
        ordersPage.smdTableTabList.get(1).click();

    }

    @Then("Verify that the user should see {string} in work orders table.")
    public void verifyThatTheUserShouldSeeInWorkOrdersTable(String expectedName) {
        BrowserUtils.waitForVisibility(ordersPage.baseTableFirstRow, 15);
        String actualName = ordersPage.baseTableFirstRow.getText();
        assertEquals(expectedName, actualName);
    }

    @When("User can click tree dot button in work orders table.")
    public void userCanClickTreeDotButtonInWorkOrdersTable() {
        BrowserUtils.waitForClickability(ordersPage.inTableTreeDotButton, 15);
        ordersPage.inTableTreeDotButton.click();
    }

    @And("User can click unlink work order option.")
    public void userCanClickUnlinkWorkOrderOption() {
        BrowserUtils.waitForClickability(ordersPage.inTableTreeDotMenuOptions.get(0), 15);
        ordersPage.inTableTreeDotMenuOptions.get(0).click();

    }

    @And("User can click create document option.")
    public void userCanClickCreateDocumentOption() {
        BrowserUtils.waitForClickability(ordersPage.treeDotMenuItems.get(2), 15);
        ordersPage.treeDotMenuItems.get(2).click();
    }

    @Then("Verify that the user should see {string} header.\\(CD)")
    public void verifyThatTheUserShouldSeeHeaderCD(String expectedHeader) {
        ordersPage.verifyHeader(expectedHeader, ordersPage.createDocumentHeader);

    }

    @And("Verify that the user should see {string} warning message.\\(CD)")
    public void verifyThatTheUserShouldSeeWarningMessageCD(String expectedWarningMessage) {
        BrowserUtils.waitForVisibility(ordersPage.createDocumentWarningMessage, 15);
        String actualWarningMessage = ordersPage.createDocumentWarningMessage.getText();
        assertEquals(expectedWarningMessage, actualWarningMessage);
    }

    @When("User can select document type.")
    public void userCanSelectDocumentType() {
        BrowserUtils.waitForClickability(ordersPage.createDocumentSelectInput, 15);
        ordersPage.createDocumentSelectInput.click();
        BrowserUtils.waitForClickability(ordersPage.documentTypeOrderInvoice, 15);
        ordersPage.documentTypeOrderInvoice.click();

    }

    @Then("Verify that the user should see {string} message.\\(CD)")
    public void verifyThatTheUserShouldSeeMessageCD(String expectedMessage) {
        BrowserUtils.waitForVisibility(ordersPage.successMessage, 15);
        String actualMessage = ordersPage.successMessage.getText();
        assertTrue(actualMessage.contains(expectedMessage));
        orderNameForDocuments = ordersPage.ordersTableOrderNameRow.getText();
    }

    @When("User can click Documents.")
    public void userCanClickDocuments() {
        BrowserUtils.waitForClickability(homePage.documentIcon, 15);
        homePage.documentIcon.click();
    }

    @Then("Verify that the user should see on the {string} page.")
    public void verifyThatTheUserShouldSeeOnThePage(String expectedHeader) {
        ordersPage.verifyHeader(expectedHeader, documentsPage.documentsHeader);
    }

    @Then("Verify that the user should see order name in documents table.")
    public void verifyThatTheUserShouldSeeOrderNameInDocumentsTable() {
        BrowserUtils.waitForVisibility(documentsPage.documentsTableOrderNameRow, 15);
        String actualOrderName = documentsPage.documentsTableOrderNameRow.getText();
        System.out.println("actualOrderName = " + actualOrderName);
        String expectedOrderName = orderNameForDocuments;
        System.out.println("expectedOrderName = " + expectedOrderName);
        assertTrue(expectedOrderName.equalsIgnoreCase(actualOrderName));


    }


    @And("User can click repeat order option.")
    public void userCanClickRepeatOrderOption() {
        BrowserUtils.waitForClickability(ordersPage.treeDotMenuItems.get(3), 15);
        ordersPage.treeDotMenuItems.get(3).click();
    }

    @Then("Verify that the user should see {string} header.\\(RO)")
    public void verifyThatTheUserShouldSeeHeaderRO(String expectedHeader) {
        BrowserUtils.waitForVisibility(ordersPage.repeatOrderHeader, 15);
        String actualHeader = ordersPage.repeatOrderHeader.getText();
        assertEquals(expectedHeader, actualHeader);

    }

    @Then("Verify that the user should see {string} message.\\(RO)")
    public void verifyThatTheUserShouldSeeMessageRO(String expectedMessage) {

        BrowserUtils.waitForVisibility(ordersPage.successMessage,15);
        actualMessage = ordersPage.successMessage.getText();
        System.out.println("actualMessage = " + actualMessage);
        assertTrue(actualMessage.contains(expectedMessage));

    }


    @And("Verify that the user should see repeat order name in orders table.")
    public void verifyThatTheUserShouldSeeRepeatOrderNameInOrdersTable() {
        BrowserUtils.waitForVisibility(ordersPage.baseTableFirstRow,15);
        String repeatOrderName = ordersPage.baseTableFirstRow.getText();
        System.out.println("repeatOrderName = " + repeatOrderName);
        assertTrue(actualMessage.contains(repeatOrderName));

    }



}
