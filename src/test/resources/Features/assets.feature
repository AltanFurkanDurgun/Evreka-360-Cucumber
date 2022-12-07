@asset @smoke
Feature: User check assets page

  Background:
    Given User navigate to login page.
    When User can be login.
    Then Verify that the user should be on the home page.
    When User can select user account.
    Then Verify that the user should see the selected user next to on account text.
    When User can click Asset Management dropdown menu.
    Then Verify that the user should see following options.(Asset)
      | Assets     |
      | Activities |
    When User can click Assets.
    Then Verify that the user should on the Assets page.

  @addAsset
  Scenario: User can add asset.
    When User can click add asset button.
    Then Verify that the the user should on the "Add Asset" page.
    When User can enter name.
    Then Verify that the user should see "This name is available".
    When User can select asset type.
    And User can click submit button.(Asset)
    Then Verify that the user should see success message.(Asset)
    And  Verify that the user should be see asset name in table.


  @seeMoreDetail
  Scenario: User can check see more detail page.
    When User can click tree dot button.
    And User can click see more detail.
    Then Verify that the user should on the "Asset Details" page.
    When User can click tree dot button.
    Then Verify that the user should see "Edit Asset" option.
    And Verify that the user should see following options.(AssetSMD)
      | Location    |
      | Fullness    |
      | Temperature |
    When User can click all tab headers.(orders)
    And Verify that the user should see following options.(AssetTable)
      | Devices    |
      | History    |
      | Activities |
    When User can click all table tab headers.(orders)


  @editAsset
  Scenario: User can edit asset.
    When User can click tree dot button.
    And User can click edit asset.
    Then Verify that the user should on the "Edit Asset" page.(EA)
    When User can edit asset type.
    And User can click submit button.(Asset)
    Then Verify that the user should see success message.(Asset)
    And Verify that the user should be see edited asset type in table.

  @attachDevice
  Scenario: User can attach device.
    When User can click tree dot button.
    And User can click attach device.
    Then Verify that the user should see "Attach Device" header.(AD)
    When User can select device type.
    And User can enter "1234567890" in device id box
    And User can select device id.
    And User can click submit button.(linkAsset)
    Then Verify that the user should see success message.(AD)
    When User can click tree dot button.
    And User can click see more detail.
    Then Verify that the user should on the "Asset Details" page.
    And Verify that the user should see device id in devices table.
    When User can click delete button.
    Then Verify that the user should see "Are you sure you want to detach this device?" warning message.
    When User can click submit button.(linkAsset)
    Then Verify that the user should see success message.(AD)























