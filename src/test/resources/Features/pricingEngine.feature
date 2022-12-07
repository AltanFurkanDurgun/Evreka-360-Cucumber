@priceEngine @smoke
Feature: Use pricing engine modules

  Background:
    Given User navigate to login page.
    When User can be login.
    Then Verify that the user should be on the home page.
    When User can select user account.
    Then Verify that the user should see the selected user next to on account text.
    When User can click Engagement dropdown menu.
    Then Verify that the user should see following options.
      | Entities       |
      | Service Points |
      | Orders         |
      | Pricing Engine |
    When User can click Pricing Engine option.
    Then Verify that the user should on the pricing engine page.

  @addPrice
  Scenario: User can add price
    When User can click add price
    Then Verify that the user should see "Add Price" header.(PE)
    When User can enter entity name.
    And User can select entity type.(PE)
    And User can select order type.(PE)
    And User can select order item.
    And User can enter unit price.
    And User can enter market share.
    And User can click submit button.
    Then Verify that the user should see "Successfully created FinancialDetail" success message.(PE)
    And Verify that the user should see creation time.


  @editPrice
  Scenario: User can edit price
    When User can click tree dot button.
    And User can click edit price.
    Then Verify that the user should see "Edit Price" header.(EP)
    And Verify that the entity name ,order type ,order item is not enable.
    When User can edit unit price.
    And User can click submit button.
    Then Verify that the user should see "Successfully updated Financial detail" success message.(EP)
    And Verify that the user should see last update time.

  @priceHistory
  Scenario: User can check price history
    When User can check unit price.
    And User can click tree dot button.
    And User can click price history.
    Then Verify that the user should see "Price History" header.(EP)
    And Verify that the user should see unit price.
    When User can click close button.

  @deletePrice
  Scenario: User can delete price
    When User can click tree dot button.
    And User can click delete price.
    Then Verify that the user should be see "Confirm" header.
    When User can click submit button.(linkAsset)
    Then Verify that the user should see "Successfully deleted Financial detail" success message.(EP)
    And Verify that the deleted entity name should not appear in the price table.

























