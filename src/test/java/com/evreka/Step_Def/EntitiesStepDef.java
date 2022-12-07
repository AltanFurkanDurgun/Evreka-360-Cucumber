package com.evreka.Step_Def;

import com.evreka.Pages.EntitiesPage;
import com.evreka.Pages.HomePage;
import com.evreka.Pages.LoginPage;
import com.evreka.Utilies.BrowserUtils;
import com.evreka.Utilies.ConfigurationReader;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.Assert.*;

public class EntitiesStepDef {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    EntitiesPage entitiesPage = new EntitiesPage();

    String actualUser, entityNameCheck, actualSuccessMessage, orderNameCheck;


    @When("User can be login.")
    public void user_can_be_login() {
        loginPage.login(ConfigurationReader.get("username"), ConfigurationReader.get("password"));
        BrowserUtils.waitForClickability(loginPage.loginButton, 15);
        loginPage.loginButton.click();

    }


    @When("User can select user account.")
    public void userCanSelectUserAccount() {
        Select selectUser = new Select(homePage.changeUser);
        selectUser.selectByValue("12");
        String expectedUser = "QA Client";
        BrowserUtils.waitForVisibility(selectUser.getFirstSelectedOption(), 15);
        actualUser = selectUser.getFirstSelectedOption().getText();
        assertEquals(expectedUser, actualUser);
    }

    @Then("Verify that the user should see the selected user next to on account text.")
    public void verifyThatTheUserShouldSeeTheSelectedUserNextToOnAccountText() {
        BrowserUtils.waitForVisibility(homePage.selectedUserText, 15);
        BrowserUtils.waitFor(2);
        String expectedUser = homePage.selectedUserText.getText();
        System.out.println("expectedUser = " + expectedUser);
        System.out.println("actualUser = " + actualUser);
        assertTrue(expectedUser.contains(actualUser));


    }


    @When("User can click Engagement dropdown menu.")
    public void userCanClickEngagementDropdownMenu() {
        BrowserUtils.waitForClickability(homePage.engagementIcon, 15);
        homePage.engagementIcon.click();
        BrowserUtils.waitFor(1);


    }

    @Then("Verify that the user should see following options.")
    public void verifyThatTheUserShouldSeeFollowingOptions(List<String> menuOptions) {
        BrowserUtils.waitForVisibility(homePage.engagementOptions.get(0),15);
        for (int i = 0; i < homePage.engagementOptions.size(); i++) {
            BrowserUtils.waitForVisibility(homePage.engagementOptions.get(i), 15);
            System.out.println("allMenuOptions = " + homePage.engagementOptions.get(i).getText());
            assertEquals(menuOptions.get(i), homePage.engagementOptions.get(i).getText());
        }

    }

    @When("User can click Entities option.")
    public void userCanClickEntitiesOption() {
        BrowserUtils.waitForClickability(homePage.engagementOptions.get(0), 15);
        homePage.engagementOptions.get(0).click();
    }

    @Then("Verify that the user should on the entities page.")
    public void verifyThatTheUserShouldOnTheEntitiesPage() {
        BrowserUtils.waitForVisibility(entitiesPage.entitiesHeader, 15);
        String expectedHeaderText = "Entities";
        String actualHeaderText = entitiesPage.entitiesHeader.getText();
        assertEquals(expectedHeaderText, actualHeaderText);
    }

    @When("User can click add entity button.")
    public void userCanClickAddEntityButton() {
        BrowserUtils.waitForClickability(entitiesPage.addEntityButton, 15);
        entitiesPage.addEntityButton.click();

    }

    @Then("Verify that the user on the add entity page.")
    public void verifyThatTheUserOnTheAddEntityPage() {
        BrowserUtils.waitForVisibility(entitiesPage.entityNameBox, 15);
        String expectedHeaderText = "Add Entity";
        String actualHeaderText = entitiesPage.addEntityHeader.getAttribute("innerText");
        System.out.println("actualHeaderText = " + actualHeaderText);
        assertEquals(expectedHeaderText, actualHeaderText);
    }

    @When("User can enter {string} in the entity name field.")
    public void userCanEnterInTheEntityNameField(String entityName) {
        BrowserUtils.waitForVisibility(entitiesPage.entityNameBox, 15);
        entityNameCheck = entityName;
        entitiesPage.entityNameBox.sendKeys(entityNameCheck);

    }

    @Then("Verify that the user should be see {string} message.")
    public void verifyThatTheUserShouldBeSeeMessage(String expectedSuccessMessage) {
        BrowserUtils.waitForVisibility(entitiesPage.availableNameMessage, 15);
        BrowserUtils.waitFor(1);
        String actualSuccessMessage = entitiesPage.availableNameMessage.getText();
        assertEquals(expectedSuccessMessage, actualSuccessMessage);
    }


    @And("User can click submit button.")
    public void userCanClickSubmitButton() {
        BrowserUtils.waitForClickability(entitiesPage.submitButton, 15);
        entitiesPage.submitButton.click();
    }

    @Then("Verify that user should be see {string} message.")
    public void verifyThatUserShouldBeSeeMessage(String statusMessage) {
        BrowserUtils.waitForVisibility(entitiesPage.successMessage, 15);
        System.out.println("entitiesPage = " + entitiesPage.successMessage.getText());
        String expectedSuccessMessage = "Successfully " + statusMessage + " Entity (" + entityNameCheck + ")\n" +
                " See More Details";
        actualSuccessMessage = entitiesPage.successMessage.getText().trim();
        assertEquals(expectedSuccessMessage, actualSuccessMessage);
    }


    @And("Verify that the user should be see entity name in success message.")
    public void verifyThatTheUserShouldBeSeeEntityNameInSuccessMessage() {
        assertTrue(actualSuccessMessage.contains(entityNameCheck));
    }

    @And("Verify that the user should be see the created entity name appear in the table.")
    public void verifyThatTheUserShouldBeSeeTheCreatedEntityNameAppearInTheTable() {
        BrowserUtils.waitForVisibility(entitiesPage.entityNameTable, 15);
        String actualEntityNameTable = entitiesPage.entityNameTable.getText();
        System.out.println("actualEntityNameTable = " + actualEntityNameTable);
        assertEquals(entityNameCheck, actualEntityNameTable);

    }

    @And("User can click tree dot button.")
    public void userCanClickTreeDotButton() {
        BrowserUtils.waitForClickability(entitiesPage.treeDotButton, 15);
        entitiesPage.treeDotButton.click();
    }

    @Then("Verify that the user should see following options\\(treeDot).")
    public void verifyThatTheUserShouldSeeFollowingOptionsTreeDot(List<String> allMenuItems) {
        BrowserUtils.waitForVisibility(entitiesPage.treeDotMenuItems.get(0), 15);
        for (int i = 0; i < entitiesPage.treeDotMenuItems.size(); i++) {
            System.out.println("All menu items = " + entitiesPage.treeDotMenuItems.get(i).getText());
            assertEquals(allMenuItems.get(i), entitiesPage.treeDotMenuItems.get(i).getText());
        }


    }

    @When("User can click edit entity item.")
    public void userCanClickEditEntityItem() {
        BrowserUtils.waitForClickability(entitiesPage.editEntityItem, 15);
        entitiesPage.editEntityItem.click();

    }

    @Then("Verify that the user on the edit entity page.")
    public void verifyThatTheUserOnTheEditEntityPage() {
        BrowserUtils.waitForVisibility(entitiesPage.entityNameBox, 15);
        String expectedHeaderText = "Edit Entity";
        String actualHeaderText = entitiesPage.editEntityHeader.getText();
        assertEquals(expectedHeaderText, actualHeaderText);
    }

    @When("User can edit entity name as {string}.")
    public void userCanEditEntityNameAs(String editedEntityName) {
        BrowserUtils.waitForVisibility(entitiesPage.entityNameBox, 15);
        BrowserUtils.cleanBox(entitiesPage.entityNameBox);
        entitiesPage.entityNameBox.sendKeys(editedEntityName);
        entityNameCheck = editedEntityName;
    }


    @And("Verify that the user should be see the updated entity name appear in the table.")
    public void verifyThatTheUserShouldBeSeeTheUpdatedEntityNameAppearInTheTable() {
        BrowserUtils.waitForVisibility(entitiesPage.entityNameTable, 15);
        String actualEntityNameTable = entitiesPage.entityNameTable.getText();
        System.out.println("actualEntityNameTable = " + actualEntityNameTable);
        assertEquals(entityNameCheck, actualEntityNameTable);
    }

    @When("User can enter entity name in search input box.")
    public void userCanEnterEntityNameInSearchInputBox() {
        entitiesPage.tableSearchInputBox.sendKeys(entityNameCheck);
        BrowserUtils.waitFor(2);


    }

    @Then("Verify that the user should be see entity name in table.")
    public void verifyThatTheUserShouldBeSeeEntityNameInTable() {
        BrowserUtils.waitForVisibility(entitiesPage.itemsCount, 15);
        assertEquals(entityNameCheck, entitiesPage.entityNameTable.getText());
    }

    @And("User can click delete entity item.")
    public void userCanClickDeleteEntityItem() {
        BrowserUtils.waitForVisibility(entitiesPage.entityNameTable, 15);
        entityNameCheck = entitiesPage.entityNameTable.getText();
        BrowserUtils.waitForVisibility(entitiesPage.deleteEntityItems, 15);
        entitiesPage.deleteEntityItems.click();
    }

    @Then("Verify that the user should be see confirm popup.")
    public void verifyThatTheUserShouldBeSeeConfirmPopup() {
        BrowserUtils.waitForVisibility(entitiesPage.confirmText, 15);
        String expectedHeader = "Confirm";
        String actualHeader = entitiesPage.confirmText.getText();
        assertEquals(expectedHeader, actualHeader);

    }

    @And("Verify that the user should be see {string} and {string} button.")
    public void verifyThatTheUserShouldBeSeeAndButton(String cancelButton, String submitButton) {
        BrowserUtils.waitForVisibility(entitiesPage.cancelButton, 15);
        String actualCancelButtonText = entitiesPage.cancelButton.getText();
        System.out.println("actualCancelButtonText = " + actualCancelButtonText);
        String actualSubmitButtonText = entitiesPage.submitButton.getText();
        System.out.println("actualSubmitButtonText = " + actualSubmitButtonText);
        assertEquals(cancelButton, actualCancelButtonText);
        assertEquals(submitButton, actualSubmitButtonText);
    }

    @When("User can click on the submit button.")
    public void userCanClickOnTheSubmitButton() {
        BrowserUtils.waitForClickability(entitiesPage.submitButton, 15);
        entitiesPage.submitButton.click();


    }


    @Then("Verify that user should be see {string} message.\\(delete)")
    public void verifyThatUserShouldBeSeeMessageDelete(String statusMessage) {
        BrowserUtils.waitForVisibility(entitiesPage.successMessage, 15);
        System.out.println("entitiesPage = " + entitiesPage.successMessage.getText());
        String expectedDeletedMessage = "Successfully " + statusMessage + " Entity (" + entityNameCheck + ")";
        String actualDeletedMessage = entitiesPage.successMessage.getText();
        assertEquals(expectedDeletedMessage, actualDeletedMessage);

    }

    @And("Verify that the user shouldn`t be see entity in table.")
    public void verifyThatTheUserShouldnTBeSeeEntityInTable() {
        assertNotEquals(entityNameCheck, entitiesPage.entityNameTable.getText());

    }

    @Then("Verify that the user should be see {string}")
    public void verifyThatTheUserShouldBeSee(String errorMessage) {
        BrowserUtils.waitForVisibility(entitiesPage.noEntitiesMessage, 15);
        String actualNoEntitiesMessage = entitiesPage.noEntitiesMessage.getText();
        assertEquals(errorMessage, actualNoEntitiesMessage);


    }

    @And("User can click see more detail item.")
    public void userCanClickSeeMoreDetailItem() {
        BrowserUtils.waitForClickability(entitiesPage.treeDotMenuItems.get(0), 15);
        entitiesPage.treeDotMenuItems.get(0).click();

    }

    @Then("Verify that the user on the {string} page.")
    public void verifyThatTheUserOnThePage(String expectedHeaderText) {
        BrowserUtils.waitForVisibility(entitiesPage.entityDetailsHeader, 15);
        String actualHeaderText = entitiesPage.entityDetailsHeader.getText();
        assertEquals(expectedHeaderText, actualHeaderText);
    }


    @Then("Verify that the user should see following options\\(SMD).")
    public void verifyThatTheUserShouldSeeFollowingOptionsSMD(List<String> expectedMenuItems) {
        BrowserUtils.waitForVisibility(entitiesPage.entityDetailsTreeDotMenuItems.get(0), 15);
        for (int i = 0; i < entitiesPage.entityDetailsTreeDotMenuItems.size(); i++) {
            System.out.println("Tree dot menu item = " + entitiesPage.entityDetailsTreeDotMenuItems.get(i).getText());
            assertEquals(expectedMenuItems.get(i), entitiesPage.entityDetailsTreeDotMenuItems.get(i).getText());
        }

    }

    @When("User can click status button.")
    public void userCanClickStatusButton() {
        BrowserUtils.waitForClickability(entitiesPage.statusButton, 15);
        entitiesPage.statusButton.click();
    }

    @Then("Verify that the user should see following status.")
    public void verifyThatTheUserShouldSeeFollowingStatus(List<String> expectedStatusList) {
        BrowserUtils.waitForVisibility(entitiesPage.allStatus.get(0), 15);
        for (int i = 0; i < entitiesPage.allStatus.size(); i++) {
            System.out.println("Status = " + entitiesPage.allStatus.get(i).getText());
            assertEquals(expectedStatusList.get(i), entitiesPage.allStatus.get(i).getText());

        }


    }

    @And("Verify that the user should be see following tab headers.")
    public void verifyThatTheUserShouldBeSeeFollowingTabHeaders(List<String> expectedTabList) {
        BrowserUtils.waitForVisibility(entitiesPage.smdTabList.get(0), 15);
        for (int i = 0; i < entitiesPage.smdTabList.size(); i++) {
            System.out.println("Tab header = " + entitiesPage.smdTabList.get(i).getText());
            assertEquals(expectedTabList.get(i), entitiesPage.smdTabList.get(i).getText());
        }
    }

    @And("Verify that the user click all tab headers.")
    public void verifyThatTheUserClickAllTabHeaders() {
        for (int i = 0; i < entitiesPage.smdTabList.size(); i++) {
            BrowserUtils.waitForClickability(entitiesPage.smdTabList.get(i), 15);
            entitiesPage.smdTabList.get(i).click();
        }
    }

    @And("Verify that the user should be see following table tab headers.")
    public void verifyThatTheUserShouldBeSeeFollowingTableTabHeaders(List<String> expectedTableTabHeaders) {
        BrowserUtils.waitForVisibility(entitiesPage.smdTableTabList.get(0), 15);
        for (int i = 0; i < entitiesPage.smdTableTabList.size(); i++) {
            System.out.println("Table`s tab header = " + entitiesPage.smdTableTabList.get(i).getText());
            assertEquals(expectedTableTabHeaders.get(i), entitiesPage.smdTableTabList.get(i).getText());
        }


    }

    @When("User can click table`s tab headers and the table header must be the same as the table tab header.")
    public void userCanClickTableSTabHeadersAndTheTableHeaderMustBeTheSameAsTheTableTabHeader() {
        for (int i = 0; i < entitiesPage.smdTableTabList.size(); i++) {
            BrowserUtils.waitForClickability(entitiesPage.smdTableTabList.get(i), 15);
            entitiesPage.smdTableTabList.get(i).click();
            String expectedHeader = entitiesPage.smdTableTabList.get(i).getText();
            System.out.println("expectedHeader = " + expectedHeader);
            BrowserUtils.waitForVisibility(entitiesPage.smdTableHeaderEntities,15);
            String actualHeader = entitiesPage.smdTableHeaderEntities.getText();
            System.out.println("actualHeader = " + actualHeader);
            assertEquals(expectedHeader, actualHeader);


        }
    }

    @And("User can click orders tab.")
    public void userCanClickOrdersTab() {
        BrowserUtils.waitForClickability(entitiesPage.smdTableTabList.get(1), 15);
        entitiesPage.smdTableTabList.get(1).click();
    }

    @And("User can click Add Ad Hoc Order button.")
    public void userCanClickAddAdHocOrderButton() {
        BrowserUtils.waitForClickability(entitiesPage.addAdHocOrderButton, 15);
        entitiesPage.addAdHocOrderButton.click();
    }

    @Then("Verify that the user should be on the {string} page.")
    public void verifyThatTheUserShouldBeOnThePage(String expectedHeader) {
        BrowserUtils.waitForVisibility(entitiesPage.addAdHocOrderHeader, 15);
        String actualHeader = entitiesPage.addAdHocOrderHeader.getText();
        assertEquals(expectedHeader, actualHeader);
    }


    @And("Verify that the user should be see {string} text.\\(addAdHoc)")
    public void verifyThatTheUserShouldBeSeeTextAddAdHoc(String expectedText) {
        BrowserUtils.waitForVisibility(entitiesPage.locationBoxText, 15);
        String actualText = entitiesPage.locationBoxText.getText();
        assertEquals(expectedText, actualText);
    }

    @When("User can click cross button.")
    public void userCanClickCrossButton() {
        BrowserUtils.waitFor(1);
        BrowserUtils.waitForVisibility(entitiesPage.crossButton, 15);
        //entitiesPage.crossButton.click();
        BrowserUtils.doubleClick(entitiesPage.crossButton);
        BrowserUtils.waitFor(2);
    }

    @When("User can search {string} in location search box.")
    public void userCanSearchInLocationSearchBox(String location) {
        BrowserUtils.waitForVisibility(entitiesPage.locationSearchBox, 15);
        entitiesPage.locationSearchBox.sendKeys(location);
        BrowserUtils.waitFor(2);


    }

    @When("User can select location.")
    public void userCanSelectLocation() {
        BrowserUtils.waitForClickability(entitiesPage.firstLocation, 15);
        entitiesPage.firstLocation.click();


    }

    @Then("Verify that the user should be see location in location input box.")
    public void verifyThatTheUserShouldBeSeeLocationInLocationInputBox() {
        BrowserUtils.waitForVisibility(entitiesPage.locationBoxText, 15);
        assertFalse(entitiesPage.locationBox.getAttribute("value").isEmpty());

    }

    @When("User can enter order name in order name box.")
    public void userCanEnterOrderNameInOrderNameBox() {

        BrowserUtils.waitForVisibility(entitiesPage.orderNameBox, 15);
        Faker orderFaker = new Faker();
        String orderName = String.valueOf(orderFaker.name().firstName());
        entitiesPage.orderNameBox.sendKeys(orderName);
        orderNameCheck = orderName;
    }

    @When("User can select producer order option.")
    public void userCanSelectProducerOrderOption() {
        BrowserUtils.waitForClickability(entitiesPage.orderTypeBox, 15);
        entitiesPage.orderTypeBox.click();
        BrowserUtils.waitForClickability(entitiesPage.producerOrder, 15);
        entitiesPage.producerOrder.click();
    }

    @And("User can enter date in due date box.")
    public void userCanEnterDateInDueDateBox() {
        entitiesPage.selectDate(entitiesPage.dueDateBox,0);

    }


    @Then("Verify that user should be see {string} message.\\(order)")
    public void verifyThatUserShouldBeSeeMessageOrder(String status) {
        BrowserUtils.waitForVisibility(entitiesPage.successMessage, 15);
        String expectedMessage = "Successfully " + status + " Order (" + orderNameCheck + ")\n" +
                " See More Details ";
        System.out.println("actualSuccessMessage = " + entitiesPage.successMessage.getText());
        assertEquals(expectedMessage, entitiesPage.successMessage.getText());
    }

    @Then("Verify that the created order appears in the order table.")
    public void verifyThatTheCreatedOrderAppearsInTheOrderTable() {
        BrowserUtils.waitForVisibility(entitiesPage.baseTableFirstRow, 15);
        System.out.println("Order name in order tables`s= " + entitiesPage.baseTableFirstRow.getText());
        assertEquals(orderNameCheck, entitiesPage.baseTableFirstRow.getText());

    }


    @Then("Verify that the user should be see {string} message.\\(SMD)")
    public void verifyThatTheUserShouldBeSeeMessageSMD(String expectedMessage) {
        BrowserUtils.waitForVisibility(entitiesPage.addAdHocOrderMessageText,15);
        String actualMessage = entitiesPage.addAdHocOrderMessageText.getText();
        assertEquals(expectedMessage,actualMessage);
    }
}
