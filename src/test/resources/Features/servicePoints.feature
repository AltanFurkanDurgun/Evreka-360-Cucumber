@servicePoints @smoke
Feature: Use all service points module

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
    When User can click Service Points option.
    Then Verify that the user should be on the service points page.

  @addServicePoint
  Scenario: User can add service point
    When User can click add service point button.
    Then Verify that user should be on the add service point page.
    When User can enter service point name.
    Then Verify that the user should be see "This service point name is available" message.
    When User can click cross button.
    And User can search "tucson" in location search box.
    When User can select location.
    And User can select order type.
    And User can select service point type.
    And User can select entity type.
    And User can enter "test" in entity search box.
    And User can select test option.
    And User can enter "test11" in operations service point search box.
    And User can select operations service point.
    And User can click submit button.
    Then Verify that user should be see "created" message.(SP)
    And Verify that the user should be see the created service point name appear in the table.
    When User can enter service point name in search input box.
    Then Verify that the user should be see service point name in table.

  @seeMoreDetailSP
  Scenario: Check see more details page`s items
    When User can click tree dot button.
    And  User can click see more detail item.
    Then Verify that the user on the "Service Point Detail" page.(SP)
    When User can click tree dot button.
    Then Verify that the user should see following options(SMD).
      | Edit Service Point |
      | Add Ad Hoc Order   |
      | Add Order Plan     |
      | Link Asset         |
    When User can click status button.
    Then Verify that the user should see following status.
      | Passive |
      | Active  |
    And Verify that the user should be see following tab headers.(SPD)
      | Location     |
      | Service Days |
      | Attachments  |
    And Verify that the user click all tab headers.
    And Verify that the user should be see following table tab headers.
      | Orders      |
      | Order Plans |
      | Assets      |
      | Entities    |
    When User can click table`s tab headers and the table header must be the same as the table tab header.
    And User can click orders tab.(SP)
    And User can click add ad hoc order button.
    Then Verify that the user should be on the "Add Ad Hoc Order" page.
    When User can enter order name in order name box.
    Then Verify that the user should be see "If left blank, the system will fill it automatically" message.(SP)
    When  User can select producer order option.
    And  User can enter date in due date box.
    And User can click submit button.
    Then Verify that user should be see "created" message.(order)
    When User can click tree dot button.
    And  User can click see more detail item.
    Then Verify that the user on the "Service Point Detail" page.(SP)
    And User can click orders tab.(SP)
    Then Verify that the created order appears in the order table.

  @editServicePointSP
  Scenario: Check edit service point page`s items
    When User can click tree dot button.
    And User can click edit service point option.
    Then Verify that the user should be on the "Edit Service Point" page.(edit)
    When User can edit service point name.
    Then Verify that the user should be see "This service point name is available" message.
    When User can click submit button.
    Then Verify that user should be see "updated" message.(SPEdit)
    And Verify that the user should be see the updated entity name appear in the table.(SPEdit)


  @addOrderPlanSP
  Scenario: Check add order plan page`s items
    When User can click tree dot button.
    And User can click add order plan option.
    Then Verify that the user should on the add order plan page.
    And Verify that the user should be see "Only orders after today will be affected." message.(AOP)
    And Verify that the user should be see following tab headers.(AOP)
      | Ad Hoc Point  |
      | Service Point |
    When User can click cross button.
    And User can search "tucson" in location search box.
    When User can select location.
    And User can enter order plan name.
    Then Verify that the user should be see "This order plan name is available" message.
    When User can select order type.
    And User can select plan start date and plan end date.
    And User can enter "test" in entity search box.(AOP)
    And User can select test option.
    And User can select schedule.
    And User can enter days count.
    And User can click submit button.
    Then Verify that user should be see "created" message.(AOP)
    When User can click Orders option in Engagement dropdown menu.
    Then Verify that the user should on the orders page.
    When User can click order plans tab.
    Then Verify that the user should be see the created order plan name appear in the table.

  @addAdHocOrderSP
  Scenario: Check add ad hoc order page`s items
    When User can click tree dot button.
    And User can click add ad hoc order option.
    Then Verify that the user should be on the "Add Ad Hoc Order" page.
    When User can enter order name in order name box.(AAHO)
    Then Verify that the user should be see "If left blank, the system will fill it automatically" message.(AAHO)
    When  User can select producer order option.
    And  User can enter date in due date box.
    And User can click submit button.
    Then Verify that user should be see "created" message.(AAHO)
    When User can click Orders option in Engagement dropdown menu.
    Then Verify that the user should on the orders page.
    When User can click orders tab.(AAHO)
    Then Verify that the user should be see the created order name appear in the table.


  @linkToOperationsSP
  Scenario: Check link to operations
    When User can click tree dot button.
    And User can click link to operations option.
    And User can check operation management service point name.
    Then Verify that the user should see "Link to Operations" header.(LTO)
    And Verify that the user should see "Operations Management Service Point" sub-header.(LTO)
    When User can enter operation management service point name in search box.
    And User can select operation management service point.
    And User can click submit button.
    Then Verify that the user should see "updated" success message.
    And Verify that the user should see service point name in table.



















