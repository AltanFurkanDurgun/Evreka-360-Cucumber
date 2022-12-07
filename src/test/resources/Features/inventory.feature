@inventory @smoke
Feature: User can check inventory page.

  Background:
    Given User navigate to login page.
    When User can be login.
    Then Verify that the user should be on the home page.
    When User can select user account.
    Then Verify that the user should see the selected user next to on account text.
    When User can click MRF Management dropdown menu.
    Then Verify that the user should see following options.(mrf)
      | Inbound    |
      | Parcel     |
      | Process    |
      | Allocation |
      | Inventory  |
      | Settings   |
    When User can click inventory option.
    Then Verify that the user should on the "Inventory" page.(inventory)


  @addInventory
  Scenario: User can add inventory.
    When User can click add inventory record button.
    Then Verify that the user should on the "Add Inventory Record" page.(inventory)
    When User can select material type.(inventory)
    And User can enter amount.
    And User can select facility.
    And User can enter capacity.
    And User can click submit button.
    Then Verify that the user should see success message.(inventory)

  @increaseAmount
  Scenario: User can increase amount.
    When User can click tree dot button.
    And User can click increase amount.
    Then Verify that the user should see "Increase Amount" header.(increase)
    When User can enter amount.(increase)
    Then Verify that the user should see warning message.
    When User can click submit button.(Asset)
    Then Verify that the user should see success message.(inventory)
    And Verify that the user should be see total amount in inventory table.

  @decreaseAmount
  Scenario: User can decrease amount.
    When User can click tree dot button.
    And User can click decrease amount.
    Then Verify that the user should see "Decrease Amount" header.(decrease)
    When User can enter amount.(decrease)
    When User can click submit button.(Asset)
    Then Verify that the user should see success message.(inventory)
    And Verify that the user should be see total decrease amount in inventory table.

  @changeCapacity
  Scenario: User can change capacity.
    When User can click tree dot button.
    And User can click change capacity.
    And User can enter capacity.(change)
    Then Verify that the user should see warning message.(change)
    And User can click submit button.(Asset)
    Then Verify that the user should see success message.(inventory)
    And Verify that the user should be see total capacity amount in inventory table.

    @deleteInventory
    Scenario: User can delete inventory.
    When User can click tree dot button.
    And User can click delete.
    Then Verify that the user should see "Delete Inventory Item"
    And Verify that the user should see "Are you sure you want to delete this inventory item? This action cannot be undone!" warning message.
    When User can click submit button.(Asset)
    Then Verify that the user should see "Inventory items deleted successfully" message.(inventory)









