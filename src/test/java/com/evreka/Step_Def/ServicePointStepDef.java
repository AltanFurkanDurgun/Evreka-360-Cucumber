package com.evreka.Step_Def;

import com.evreka.Pages.AssetPage;
import com.evreka.Pages.HomePage;
import com.evreka.Pages.OrdersPage;
import com.evreka.Pages.ServicePointsPage;
import com.evreka.Utilies.BrowserUtils;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static org.junit.Assert.*;

public class ServicePointStepDef {
    HomePage homePage = new HomePage();
    ServicePointsPage servicePointsPage = new ServicePointsPage();

    OrdersPage ordersPage = new OrdersPage();

    AssetPage assetPage = new AssetPage();
    Faker faker = new Faker();

    String servicePoint, editedServicePointName, orderPlanName, orderName, assetsName, operationalServicePointName,operationManagementServicePoint;

    @When("User can click Service Points option.")
    public void userCanClickServicePointsOption() {
        BrowserUtils.waitForClickability(homePage.engagementOptions.get(1), 15);
        homePage.engagementOptions.get(1).click();
    }

    @Then("Verify that the user should be on the service points page.")
    public void verifyThatTheUserShouldBeOnTheServicePointsPage() {
        servicePointsPage.verifyHeader("Service Points", servicePointsPage.servicePointsHeader);

    }

    @When("User can click add service point button.")
    public void userCanClickAddServicePointButton() {
        BrowserUtils.waitForClickability(servicePointsPage.addServicePointButton, 15);
        servicePointsPage.addServicePointButton.click();

    }

    @Then("Verify that user should be on the add service point page.")
    public void verifyThatUserShouldBeOnTheAddServicePointPage() {
        servicePointsPage.verifyHeader("Add Service Point", servicePointsPage.addServicePointHeader);

    }

    @When("User can enter service point name.")
    public void userCanEnterServicePointName() {
        servicePoint = faker.nation().capitalCity();
        servicePointsPage.servicePointNameBox.sendKeys(servicePoint);

    }

    @When("User can select order type.")
    public void userCanSelectOrderType() {
        BrowserUtils.waitForClickability(servicePointsPage.allSelectDropdownMenu.get(0), 15);
        servicePointsPage.allSelectDropdownMenu.get(0).click();
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(servicePointsPage.producerOrderOption);
    }

    @And("User can select service point type.")
    public void userCanSelectServicePointType() {
        BrowserUtils.waitForClickability(servicePointsPage.allSelectDropdownMenu.get(1), 15);
        servicePointsPage.allSelectDropdownMenu.get(1).click();
        BrowserUtils.waitForClickability(servicePointsPage.standardServicePointType, 15);
        servicePointsPage.standardServicePointType.click();
    }

    @And("User can select entity type.")
    public void userCanSelectEntityType() {
        BrowserUtils.waitForClickability(servicePointsPage.allSelectDropdownMenu.get(2), 15);
        servicePointsPage.allSelectDropdownMenu.get(2).click();
        BrowserUtils.waitForClickability(servicePointsPage.producerEntityType, 15);
        servicePointsPage.producerEntityType.click();
        BrowserUtils.waitFor(2);
    }

    @And("User can enter {string} in entity search box.")
    public void userCanEnterInEntitySearchBox(String entity) {
        servicePointsPage.entitySearchBoxAddServicePoint.click();
        servicePointsPage.entitySearchBoxAddServicePoint.sendKeys(entity);
        BrowserUtils.waitFor(2);
    }

    @And("User can select test option.")
    public void userCanSelectTestOption() {
        BrowserUtils.waitForClickability(servicePointsPage.allEntityOptions.get(1), 15);
        servicePointsPage.allEntityOptions.get(1).click();
    }

    @And("User can enter {string} in operations service point search box.")
    public void userCanEnterInOperationsServicePointSearchBox(String operationServicePoint) {
        BrowserUtils.waitForClickability(servicePointsPage.operationServicePointBox, 15);
        servicePointsPage.operationServicePointBox.click();
        servicePointsPage.operationServicePointBox.sendKeys(operationServicePoint);
        BrowserUtils.waitFor(2);

    }

    @And("User can select operations service point.")
    public void userCanSelectOperationsServicePoint() {
        BrowserUtils.waitForClickability(servicePointsPage.operationsServicePointOption, 15);
        servicePointsPage.operationsServicePointOption.click();
    }


    @Then("Verify that user should be see {string} message.\\(SP)")
    public void verifyThatUserShouldBeSeeMessageSP(String statusMessage) {
        BrowserUtils.waitForVisibility(servicePointsPage.successMessage, 15);
        System.out.println("Actual success message = " + servicePointsPage.successMessage.getText());
        String expectedSuccessMessage = "Successfully " + statusMessage + " Service Point (" + servicePoint + ")\n" +
                " See More Details";
        String actualSuccessMessage = servicePointsPage.successMessage.getText().trim();
        assertEquals(expectedSuccessMessage, actualSuccessMessage);
    }

    @And("Verify that the user should be see the created service point name appear in the table.")
    public void verifyThatTheUserShouldBeSeeTheCreatedServicePointNameAppearInTheTable() {
        BrowserUtils.waitForVisibility(servicePointsPage.servicePointNameTable, 15);
        String actualServicePointName = servicePointsPage.servicePointNameTable.getText();
        assertEquals(servicePoint, actualServicePointName);
    }

    @When("User can enter service point name in search input box.")
    public void userCanEnterServicePointNameInSearchInputBox() {
        servicePointsPage.tableSearchInputBox.sendKeys(servicePoint);

    }

    @Then("Verify that the user should be see service point name in table.")
    public void verifyThatTheUserShouldBeSeeServicePointNameInTable() {

        BrowserUtils.waitForVisibility(servicePointsPage.itemsCount, 15);
        assertEquals(servicePoint, servicePointsPage.servicePointNameTable.getText());

    }

    @Then("Verify that the user on the {string} page.\\(SP)")
    public void verifyThatTheUserOnThePageSP(String expectedHeader) {
        servicePointsPage.verifyHeader(expectedHeader, servicePointsPage.servicePointDetailsHeader);
    }

    @And("Verify that the user should be see following tab headers.\\(SPD)")
    public void verifyThatTheUserShouldBeSeeFollowingTabHeadersSPD(List<String> expectedTabHeaders) {
        System.out.println("servicePointsPage = " + servicePointsPage.servicePointDetailTabHeaders.size());
        for (int i = 0; i < servicePointsPage.servicePointDetailTabHeaders.size(); i++) {
            BrowserUtils.waitForVisibility(servicePointsPage.servicePointDetailTabHeaders.get(i), 15);
            System.out.println("Tab Headers = " + servicePointsPage.servicePointDetailTabHeaders.get(i).getText());
            assertEquals(expectedTabHeaders.get(i), servicePointsPage.servicePointDetailTabHeaders.get(i).getText());

        }


    }

    @And("User can click orders tab.\\(SP)")
    public void userCanClickOrdersTabSP() {
        BrowserUtils.waitForClickability(servicePointsPage.smdTableTabList.get(0), 15);
        servicePointsPage.smdTableTabList.get(0).click();

    }

    @And("User can click add ad hoc order button.")
    public void userCanClickAddAdHocOrderButton() {
        BrowserUtils.waitForClickability(servicePointsPage.spdAddAdHocOrderButton, 15);
        servicePointsPage.spdAddAdHocOrderButton.click();
    }

    @Then("Verify that entity name input box is not empty.")
    public void verifyThatEntityNameInputBoxIsNotEmpty() {
        assertFalse(servicePointsPage.servicePointEntityNameBox.getAttribute("value").isEmpty());

    }


    @And("User can click edit service point option.")
    public void userCanClickEditServicePointOption() {
        BrowserUtils.waitForClickability(servicePointsPage.treeDotMenuItems.get(1), 15);
        servicePointsPage.treeDotMenuItems.get(1).click();
    }


    @Then("Verify that the user should be on the {string} page.\\(edit)")
    public void verifyThatTheUserShouldBeOnThePageEdit(String expectedHeader) {
        servicePointsPage.verifyHeader(expectedHeader, servicePointsPage.editServicePointHeader);


    }


    @When("User can edit service point name.")
    public void userCanEditServicePointName() {
        servicePointsPage.servicePointNameBox.sendKeys("edit");
        String actualEditName = servicePointsPage.servicePointNameBox.getAttribute("value");
        System.out.println("Actual edit name =" + actualEditName);
        editedServicePointName = actualEditName;
    }

    @Then("Verify that user should be see {string} message.\\(SPEdit)")
    public void verifyThatUserShouldBeSeeMessageSPEdit(String statusMessage) {

        BrowserUtils.waitForVisibility(servicePointsPage.successMessage, 15);
        System.out.println("Actual success message = " + servicePointsPage.successMessage.getText());
        String expectedSuccessMessage = "Successfully " + statusMessage + " Service Point (" + editedServicePointName + ")\n" +
                " See More Details";
        String actualSuccessMessage = servicePointsPage.successMessage.getText().trim();
        assertEquals(expectedSuccessMessage, actualSuccessMessage);

    }


    @And("Verify that the user should be see the updated entity name appear in the table.\\(SPEdit)")
    public void verifyThatTheUserShouldBeSeeTheUpdatedEntityNameAppearInTheTableSPEdit() {
        BrowserUtils.waitForVisibility(servicePointsPage.baseTableFirstRow, 15);
        String expectedServicePointName = editedServicePointName;
        String actualServicePointName = servicePointsPage.baseTableFirstRow.getText();
        System.out.println("actualServicePointName = " + actualServicePointName);
        assertEquals(expectedServicePointName, actualServicePointName);


    }

    @And("User can click add order plan option.")
    public void userCanClickAddOrderPlanOption() {
        BrowserUtils.waitForClickability(servicePointsPage.treeDotMenuItems.get(2), 15);
        servicePointsPage.treeDotMenuItems.get(2).click();

    }

    @Then("Verify that the user should on the add order plan page.")
    public void verifyThatTheUserShouldOnTheAddOrderPlanPage() {
        servicePointsPage.verifyHeader("Add Order Plan", servicePointsPage.addOrderPlanHeader);
    }

    @And("Verify that the user should be see {string} message.\\(AOP)")
    public void verifyThatTheUserShouldBeSeeMessageAOP(String expectedMessage) {
        BrowserUtils.waitForVisibility(servicePointsPage.warningMessageAddOrderPlan, 15);
        String actualMessage = servicePointsPage.warningMessageAddOrderPlan.getText();
        assertEquals(expectedMessage, actualMessage);
    }


    @And("Verify that the user should be see following tab headers.\\(AOP)")
    public void verifyThatTheUserShouldBeSeeFollowingTabHeadersAOP(List<String> expectedTabHeader) {
        for (int i = 0; i < servicePointsPage.addOrderPlanTabAllHeader.size(); i++) {
            System.out.println("All Tab Headers = " + servicePointsPage.addOrderPlanTabAllHeader.get(i).getText());
            String actualTabHeaders = servicePointsPage.addOrderPlanTabAllHeader.get(i).getText();
            assertEquals(expectedTabHeader.get(i), actualTabHeaders);
        }


    }

    @And("User can enter order plan name.")
    public void userCanEnterOrderPlanName() {
        orderPlanName = faker.name().lastName();
        servicePointsPage.orderPlanNameBox.sendKeys(orderPlanName);
    }

    @And("User can select plan start date and plan end date.")
    public void userCanSelectPlanStartDateAndPlanEndDate() {
        servicePointsPage.selectDate(servicePointsPage.planStartDateBox, 1);
        servicePointsPage.selectDate(servicePointsPage.planEndDateBox, 3);
    }

    @And("User can enter {string} in entity search box.\\(AOP)")
    public void userCanEnterInEntitySearchBoxAOP(String entityName) {
        servicePointsPage.entityNameBoxAddOrderPlan.click();
        servicePointsPage.entityNameBoxAddOrderPlan.sendKeys(entityName);
        BrowserUtils.waitFor(2);
    }

    @And("User can select schedule.")
    public void userCanSelectSchedule() {
        BrowserUtils.waitForClickability(servicePointsPage.scheduleBoxAddOrderPlan, 15);
        servicePointsPage.scheduleBoxAddOrderPlan.click();
        BrowserUtils.waitForClickability(servicePointsPage.dailyOptionAddOrderPlan, 15);
        servicePointsPage.dailyOptionAddOrderPlan.click();

    }


    @And("User can enter days count.")
    public void userCanEnterDaysCount() {
        BrowserUtils.waitForVisibility(servicePointsPage.daysCountBox, 15);
        servicePointsPage.daysCountBox.sendKeys("2");
    }

    @Then("Verify that user should be see {string} message.\\(AOP)")
    public void verifyThatUserShouldBeSeeMessageAOP(String statusMessage) {
        BrowserUtils.waitForVisibility(servicePointsPage.successMessage, 15);
        System.out.println("Actual success message = " + servicePointsPage.successMessage.getText());
        String expectedSuccessMessage = "Successfully " + statusMessage + " Order Plan (" + orderPlanName + ")\n" +
                " See More Details";
        String actualSuccessMessage = servicePointsPage.successMessage.getText().trim();
        assertEquals(expectedSuccessMessage, actualSuccessMessage);


    }

    @When("User can click Orders option in Engagement dropdown menu.")
    public void userCanClickOrdersOptionInEngagementDropdownMenu() {
        BrowserUtils.waitForClickability(servicePointsPage.engagementOptions.get(2), 15);
        servicePointsPage.engagementOptions.get(2).click();

    }

    @Then("Verify that the user should on the orders page.")
    public void verifyThatTheUserShouldOnTheOrdersPage() {
        servicePointsPage.verifyHeader("Orders", ordersPage.ordersHeader);
    }

    @When("User can click order plans tab.")
    public void userCanClickOrderPlansTab() {
        BrowserUtils.waitForClickability(ordersPage.allTabHeaderOrders.get(1), 15);
        ordersPage.allTabHeaderOrders.get(1).click();


    }

    @Then("Verify that the user should be see the created order plan name appear in the table.")
    public void verifyThatTheUserShouldBeSeeTheCreatedOrderPlanNameAppearInTheTable() {
        BrowserUtils.waitForVisibility(ordersPage.orderPlansNameTable, 15);
        String expectedOrderPlanName = orderPlanName;
        String actualOrderPlanName = ordersPage.orderPlansNameTable.getText();
        System.out.println("actualOrderPlanName = " + actualOrderPlanName);
        assertEquals(expectedOrderPlanName, actualOrderPlanName);

    }

    @And("User can click add ad hoc order option.")
    public void userCanClickAddAdHocOrderOption() {
        BrowserUtils.waitForClickability(servicePointsPage.treeDotMenuItems.get(3), 15);
        servicePointsPage.treeDotMenuItems.get(3).click();
    }

    @When("User can enter order name in order name box.\\(AAHO)")
    public void userCanEnterOrderNameInOrderNameBoxAAHO() {
        orderName = faker.name().firstName();
        servicePointsPage.orderNameBox.sendKeys(orderName);
    }

    @Then("Verify that the user should be see {string} message.\\(AAHO)")
    public void verifyThatTheUserShouldBeSeeMessageAAHO(String expectedMessage) {
        BrowserUtils.waitForVisibility(servicePointsPage.addAdHocOrderMessageText, 15);
        String actualMessage = servicePointsPage.addAdHocOrderMessageText.getText();
        assertEquals(expectedMessage, actualMessage);


    }

    @When("User can click orders tab.\\(AAHO)")
    public void userCanClickOrdersTabAAHO() {
        BrowserUtils.waitForClickability(ordersPage.allTabHeaderOrders.get(0), 15);
        ordersPage.allTabHeaderOrders.get(0).click();
    }

    @Then("Verify that the user should be see the created order name appear in the table.")
    public void verifyThatTheUserShouldBeSeeTheCreatedOrderNameAppearInTheTable() {
        BrowserUtils.waitForVisibility(servicePointsPage.baseTableFirstRow, 15);
        String actualOrderName = servicePointsPage.baseTableFirstRow.getText();
        System.out.println("actualOrderName = " + actualOrderName);
        String expectedOrderName = orderName;
        assertEquals(expectedOrderName, actualOrderName);
    }


    @Then("Verify that user should be see {string} message.\\(AAHO)")
    public void verifyThatUserShouldBeSeeMessageAAHO(String statusMessage) {
        BrowserUtils.waitForVisibility(servicePointsPage.successMessage, 15);
        String expectedMessage = "Successfully " + statusMessage + " Order (" + orderName + ")\n" +
                " See More Details ";
        System.out.println("actualSuccessMessage = " + servicePointsPage.successMessage.getText());
        assertEquals(expectedMessage, servicePointsPage.successMessage.getText());
    }

    @When("User can click Asset Management dropdown menu.")
    public void userCanClickAssetManagementDropdownMenu() {
        BrowserUtils.waitForClickability(homePage.assetIcon, 15);
        homePage.assetIcon.click();
        BrowserUtils.waitFor(1);
    }

    @And("User can click Assets.")
    public void userCanClickAssets() {
        BrowserUtils.waitForClickability(assetPage.assetManagementOptions.get(0), 15);
        assetPage.assetManagementOptions.get(0).click();

    }

    @Then("Verify that the user should on the Assets page.")
    public void verifyThatTheUserShouldOnTheAssetsPage() {
        assetPage.verifyHeader("Assets", assetPage.assetsHeader);
    }

    @When("User can select asset name.")
    public void userCanSelectAssetName() {
        BrowserUtils.waitForVisibility(assetPage.baseTableFirstRow, 15);
        assetsName = assetPage.baseTableFirstRow.getText();

    }

    @And("User can click link asset option")
    public void userCanClickLinkAssetOption() {
        BrowserUtils.waitForClickability(servicePointsPage.treeDotMenuItems.get(4), 15);
        servicePointsPage.treeDotMenuItems.get(4).click();

    }

    @Then("Verify that the user should see {string} header.")
    public void verifyThatTheUserShouldSeeHeader(String expectedHeader) {
        servicePointsPage.verifyHeader(expectedHeader, servicePointsPage.linkAssetHeader);
    }

    @And("Verify that the user should see {string} sub-header.")
    public void verifyThatTheUserShouldSeeSubHeader(String expectedSubHeader) {
        servicePointsPage.verifyHeader(expectedSubHeader, servicePointsPage.linkAssetSubHeader);
    }

    @When("User can enter asset name in search box.")
    public void userCanEnterAssetNameInSearchBox() {
        BrowserUtils.waitForVisibility(servicePointsPage.linkAssetSearchBox, 15);
        servicePointsPage.linkAssetSearchBox.click();
        servicePointsPage.linkAssetSearchBox.sendKeys(assetsName);
        BrowserUtils.waitFor(2);
    }

    @And("User can select asset.")
    public void userCanSelectAsset() {
        BrowserUtils.waitForVisibility(servicePointsPage.linkAssetSearchOptions.get(0), 15);
        servicePointsPage.linkAssetSearchOptions.get(0).click();
    }

    @Then("Verify that the user should be see {string} success message.")
    public void verifyThatTheUserShouldBeSeeSuccessMessage(String expectedMessage) {
        BrowserUtils.waitForVisibility(servicePointsPage.successMessage, 15);
        String actualMessage = servicePointsPage.successMessage.getText();
        assertTrue(actualMessage.contains(expectedMessage));

    }

    @And("User can click assets tab.")
    public void userCanClickAssetsTab() {
        BrowserUtils.waitForClickability(servicePointsPage.smdTableTabList.get(2), 15);
        servicePointsPage.smdTableTabList.get(2).click();

    }

    @Then("Verify that the user should be see linked asset name in assets table.")
    public void verifyThatTheUserShouldBeSeeLinkedAssetNameInAssetsTable() {
        BrowserUtils.waitForVisibility(servicePointsPage.baseTableFirstRow, 15);
        String expectedAssetName = assetsName;
        String actualAssetName = servicePointsPage.baseTableFirstRow.getText();
        assertEquals(expectedAssetName, actualAssetName);
    }

    @When("User can click assets tree dot button.")
    public void userCanClickAssetsTreeDotButton() {
        BrowserUtils.waitForClickability(servicePointsPage.inTableTreeDotButton, 15);
        servicePointsPage.inTableTreeDotButton.click();
    }

    @And("User can click unlink asset option.")
    public void userCanClickUnlinkAssetOption() {
        BrowserUtils.scrollToElement(servicePointsPage.inTableTreeDotMenuOptions.get(1));
        BrowserUtils.waitForClickability(servicePointsPage.inTableTreeDotMenuOptions.get(1), 15);
        servicePointsPage.inTableTreeDotMenuOptions.get(1).click();
    }

    @Then("Verify that the user should be see {string} header.")
    public void verifyThatTheUserShouldBeSeeHeader(String expectedHeader) {
        servicePointsPage.verifyHeader(expectedHeader, servicePointsPage.unlinkConfirmHeader);
    }

    @When("User can click submit button.\\(linkAsset)")
    public void userCanClickSubmitButtonLinkAsset() {
        BrowserUtils.waitForClickability(servicePointsPage.linkAssetSubmitButton, 15);
        servicePointsPage.linkAssetSubmitButton.click();
    }

    @Then("Verify that the user should be see success message.")
    public void verifyThatTheUserShouldBeSeeSuccessMessage() {
        BrowserUtils.waitForVisibility(servicePointsPage.successMessage, 15);
        assertTrue(servicePointsPage.successMessage.isDisplayed());
    }


    @And("User can click link to operations option.")
    public void userCanClickLinkToOperationsOption() {
        BrowserUtils.waitForClickability(servicePointsPage.treeDotMenuItems.get(5), 15);
        servicePointsPage.treeDotMenuItems.get(5).click();

    }

    @And("User can check operation management service point name.")
    public void userCanCheckOperationManagementServicePointName() {
        BrowserUtils.waitForVisibility(servicePointsPage.baseTableFirstRow, 15);
        operationalServicePointName = servicePointsPage.baseTableFirstRow.getText();
        operationManagementServicePoint = servicePointsPage.operationManagementServicePointTableRow.getText();

    }

    @Then("Verify that the user should see {string} header.\\(LTO)")
    public void verifyThatTheUserShouldSeeHeaderLTO(String expectedHeader) {
        servicePointsPage.verifyHeader(expectedHeader, servicePointsPage.linkToOperationsHeader);

    }

    @And("Verify that the user should see {string} sub-header.\\(LTO)")
    public void verifyThatTheUserShouldSeeSubHeaderLTO(String expectedSubHeader) {
        servicePointsPage.verifyHeader(expectedSubHeader, servicePointsPage.linkToOperationsSubHeader);

    }
    @When("User can enter operation management service point name in search box.")
    public void userCanEnterOperationManagementServicePointNameInSearchBox() {
        BrowserUtils.waitForVisibility(servicePointsPage.linkToOperationsSearchBox,15);
        servicePointsPage.linkToOperationsSearchBox.clear();
        servicePointsPage.linkToOperationsSearchBox.click();
        servicePointsPage.linkToOperationsSearchBox.sendKeys(operationManagementServicePoint);
        BrowserUtils.waitFor(2);
    }

    @And("User can select operation management service point.")
    public void userCanSelectOperationManagementServicePoint() {
        BrowserUtils.waitForClickability(servicePointsPage.operationManagementServicePointOption,15);
        servicePointsPage.operationManagementServicePointOption.click();

    }


    @Then("Verify that the user should see {string} success message.")
    public void verifyThatTheUserShouldSeeSuccessMessage(String statusMessage) {
        BrowserUtils.waitForVisibility(servicePointsPage.successMessage, 15);
        System.out.println("Actual success message = " + servicePointsPage.successMessage.getText());
        String expectedSuccessMessage = "Successfully " + statusMessage + " Service Point (" + operationalServicePointName + ")\n" +
                " See More Details";
        String actualSuccessMessage = servicePointsPage.successMessage.getText().trim();
        assertEquals(expectedSuccessMessage, actualSuccessMessage);
    }

    @And("Verify that the user should see service point name in table.")
    public void verifyThatTheUserShouldSeeServicePointNameInTable() {

        String expectedServicePointName = operationManagementServicePoint;
        String actualServicePointName = servicePointsPage.operationManagementServicePointTableRow.getText();
        assertEquals(expectedServicePointName, actualServicePointName);

    }


    @Then("Verify that the user should be see {string} message.\\(SP)")
    public void verifyThatTheUserShouldBeSeeMessageSP(String expectedMessage) {
        BrowserUtils.waitForVisibility(servicePointsPage.addAdHocOrderMessageText,15);
        String actualMessage = servicePointsPage.addAdHocOrderMessageText.getText();
        assertEquals(expectedMessage,actualMessage);
    }
}
