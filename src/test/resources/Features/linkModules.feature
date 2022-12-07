@smoke
Feature: Service point`s and Orders continued.

 Background:
   Given User navigate to login page.
   When User can be login.
   Then Verify that the user should be on the home page.
   When User can select user account.
   Then Verify that the user should see the selected user next to on account text.


  @linkAssetSP @servicePoints
  Scenario: Check link asset
    When User can click Asset Management dropdown menu.
    And  User can click Assets.
    Then Verify that the user should on the Assets page.
    When User can select asset name.
    When User can click Engagement dropdown menu.
    When User can click Service Points option.
    Then Verify that the user should be on the service points page.
    When User can click tree dot button.
    And User can click link asset option
    Then Verify that the user should see "Link Asset" header.
    And Verify that the user should see "Asset ID / Asset Name *" sub-header.
    When User can enter asset name in search box.
    And User can select asset.
    And User can click submit button.
    Then Verify that the user should be see "Successfully linked Service Point" success message.
    When User can click tree dot button.
    And  User can click see more detail item.
    And User can click assets tab.
    Then Verify that the user should be see linked asset name in assets table.
    When User can click assets tree dot button.
    And User can click unlink asset option.
    Then Verify that the user should be see "Confirm" header.
    When User can click submit button.(linkAsset)
    Then Verify that the user should be see success message.

    @linkWorkOrderOrders @orders
    Scenario: Check link work order
      When User can click MRF Management dropdown menu.
      And User can click inbound option.
      Then Verify that the user should on the inbound page.
      When User can check inbound name in inbound table.
      And User can click Engagement dropdown menu.
      When User can click Orders option.
      Then Verify that the user should on the orders page.
      When User can click tree dot button.
      And User can click link work order.
      Then Verify that the user should see "Link Work Order" header.
      When User can select type.
      And  User can enter name in name search box.
      Then Verify that the user should see "Inbound is valid for a link work order." message.
      When User can click submit button.
      Then Verify that the user should see "Successfully created WorkOrder" success message.(LWO)
      When User can click tree dot button.
      And User can click see more detail item.
      And User can click work order.
      Then Verify that the user should see "Inbound" in work orders table.
      When User can click tree dot button in work orders table.
      And User can click unlink work order option.
      Then Verify that the user should be see "Confirm" header.
      When User can click submit button.(linkAsset)
      #Then Verify that the user should see "Successfully unliked WorkOrder" success message.(LWO)





