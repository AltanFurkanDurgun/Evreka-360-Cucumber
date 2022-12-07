@entity @smoke
Feature: Use all entities`s module

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
    When User can click Entities option.
    Then Verify that the user should on the entities page.

  @addEntity
  Scenario: User can add entity.(Entity name)
    When User can click add entity button.
    Then Verify that the user on the add entity page.
    When User can enter "entitytest" in the entity name field.
    Then Verify that the user should be see "This entity name is available" message.
    When User can click submit button.
    Then Verify that user should be see "created" message.
    And Verify that the user should be see entity name in success message.
    And Verify that the user should be see the created entity name appear in the table.
    When User can enter entity name in search input box.
    Then Verify that the user should be see entity name in table.


  @seeMoreDetails
  Scenario: Check see more details page`s items
    When User can click tree dot button.
    And  User can click see more detail item.
    Then Verify that the user on the "Entity Details" page.
    When User can click tree dot button.
    Then Verify that the user should see following options(SMD).
      | Edit Entity          |
      | Attach Service Point |
      | Add Ad Hoc Order     |
      | Delete Entity        |
    When User can click status button.
    Then Verify that the user should see following status.
      | Passive |
      | Active  |
    And Verify that the user should be see following tab headers.
      | Service Points Locations |
      | Service Days             |
      | Attachments              |
      | Insights                 |
    And Verify that the user click all tab headers.
    And Verify that the user should be see following table tab headers.
      | Service Points |
      | Orders         |
      | Order Plans    |
      | Cases          |
      | Documents      |
      | Assets         |
      | Contacts       |
    When User can click table`s tab headers and the table header must be the same as the table tab header.
    And User can click orders tab.
    And User can click Add Ad Hoc Order button.
    Then Verify that the user should be on the "Add Ad Hoc Order" page.
    When User can click cross button.
    And User can search "tucson" in location search box.
    And User can select location.
    Then Verify that the user should be see location in location input box.
    And Verify that the user should be see "Add marker from map to fill location" text.(addAdHoc)
    When User can enter order name in order name box.
    Then Verify that the user should be see "If left blank, the system will fill it automatically" message.(SMD)
    When  User can select producer order option.
    And  User can enter date in due date box.
    And User can click submit button.
    Then Verify that user should be see "created" message.(order)
    When User can click tree dot button.
    And  User can click see more detail item.
    Then Verify that the user on the "Entity Details" page.
    And User can click orders tab.
    Then Verify that the created order appears in the order table.


  @editEntity
  Scenario: User can edit entity.
    When User can click tree dot button.
    Then Verify that the user should see following options(treeDot).
      | See More Details     |
      | Edit Entity          |
      | Attach Service Point |
      | Add Ad Hoc Order     |
      | Entity History       |
      | Delete Entity        |
    When User can click edit entity item.
    Then Verify that the user on the edit entity page.
    When User can edit entity name as "entitytest1".
    Then Verify that the user should be see "This entity name is available" message.
    When User can click submit button.
    Then Verify that user should be see "updated" message.
    And Verify that the user should be see the updated entity name appear in the table.
    When User can enter entity name in search input box.
    Then Verify that the user should be see entity name in table.

  @deleteEntity
  Scenario: User can delete entity.
    When User can click tree dot button.
    And User can click delete entity item.
    Then Verify that the user should be see confirm popup.
    And Verify that the user should be see "Cancel" and "Submit" button.
    When User can click on the submit button.
    Then Verify that user should be see "deleted" message.(delete)
    And Verify that the user shouldn`t be see entity in table.
    When User can enter entity name in search input box.
    Then Verify that the user should be see "There are no entities."





















