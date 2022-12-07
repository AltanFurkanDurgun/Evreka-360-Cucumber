@orders @smoke
Feature: Use all orders module

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
    When User can click Orders option.
    Then Verify that the user should on the orders page.

  @addAdHocOrderOrdersPage
  Scenario: User can add ad hoc order
    Then Verify that the user should see following options.(orders)
      | Orders      |
      | Order Plans |
    When User can click add ad hoc order button.(orders)
    Then Verify that the user should be see following tab headers.(AOP)
      | Ad Hoc Point  |
      | Service Point |
    When User can click cross button.
    And User can search "tucson" in location search box.
    When User can select location.
    And User can enter order name in order name box.(orders)
    Then Verify that the user should be see "If left blank, the system will fill it automatically" message.(AAHO)
    When User can select order type.
    And User can enter "test" in entity search box.(AOP)
    And User can select test option.
    And  User can enter date in due date box.
    And User can click submit button.
    Then Verify that user should be see "created" message.(orders)
    Then Verify that the user should be see the created order name appear in the table.(orders)

  @seeMoreDetailsOrders
  Scenario: Check see more details page`s items
    When User can click tree dot button.
    And  User can click see more detail item.
    Then Verify that the user should on the order details page.
    When User can click status button.(orders)
    Then Verify that the user should see following status options.
      | Done        |
      | In Progress |
      | New         |
    When User can click tree dot button.(orders)
    Then Verify that the user should be see "Repeat Order" option.
    And  Verify that the user should see following options.(orders)
      | Location    |
      | Attachments |
      | Disputes    |
      | Documents   |
      | Order Items |
      | Work Orders |
    When User can click all tab headers.(orders)
    And User can click all table tab headers.(orders)

  @createDocument
  Scenario: Check create document items
    When User can click tree dot button.
    And User can click create document option.
    Then Verify that the user should see "Create Document" header.(CD)
    And Verify that the user should see "Not every document can be provided for every order, and some documents can only be requested once." warning message.(CD)
    When User can select document type.
    And User can click submit button.
    Then Verify that the user should see "Successfully requested ORDER INVOICE" message.(CD)
    When User can click Documents.
    Then Verify that the user should see on the "Documents" page.
    Then Verify that the user should see order name in documents table.

  @repeatOrder
  Scenario: Check repeat order items
    When User can click tree dot button.
    And User can click repeat order option.
    Then Verify that the user should see "Repeat Order" header.(RO)
    And Verify that the user should be see "If left blank, the system will fill it automatically" message.(AAHO)
    When User can enter date in due date box.
    And User can click submit button.
    Then Verify that the user should see "Successfully created Order" message.(RO)
    And Verify that the user should see repeat order name in orders table.
























