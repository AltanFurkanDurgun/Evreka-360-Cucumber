@inbound @smoke
Feature: Use all mrf`s module

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
    And User can click inbound option.
    Then Verify that the user should on the inbound page.


  @addInbound
  Scenario: User can add inbound.
    When User can click add inbound button.
    Then Verify that the user on the "Add Inbound" page.(inbound)
    When User can enter name.(inbound)
    Then Verify that the user should see "This name is available" message.(inbound)
    And User can select facility.
    And User can select material type.
    And User can enter gross weight.
    And User can enter tare weight.
    And User can click submit button.
    Then Verify that the user should see "Successfully created Inbound" success message.(inbound)
    And Verify that the user should see inbound name in inbound table.

  @seeMoreDetailInbound
  Scenario: User can check see more details page.
    When User can click tree dot button.
    And User can click see more detail.
    Then Verify that the user should on the "Inbound Details" page.(SMDInbound)
    When User can click status button.(inbound)
    Then Verify that the user should see following options.(inbound)
      | New         |
      | In Progress |
      | Done        |
    When User can click inbound tree dot button.
    Then Verify that the user should see "Edit Inbound" option.(inbound)
    And Verify that the user should see following options.(inboundTab)
      | Attachments  |
      | Inbound Note |
    When User can click all tab headers.(inbound)
    And Verify that the user should see following options.(inboundTable)
      | History       |
      | Linked Parcel |
    When User can click all table tab headers.(inbound)

  @editInbound
  Scenario: User can edit inbound.
    When User can click tree dot button.
    And User can click edit inbound.
    Then Verify that the user should on the "Edit Inbound" page.(inbound)
    When User can edit name.
    Then Verify that the user should see "This name is available" message.(inbound)
    When User can click submit button.
    Then Verify that the user should see "Successfully updated Inbound" success message.(inbound)
    Then Verify that the edited inbound appears in the inbound table.

  @deleteInbound
    Scenario: User can delete inbound.
    When User can click tree dot button.
    And User can click delete inbound.
    Then Verify that the user should see "Delete Inbound" header.(inbound)
    And  Verify that the user should see "Are you sure you want to delete this Inbound? This action cannot be undone!" warning message.(inbound)
    When User can click submit button.(linkAsset)
    Then Verify that the user should see "Inbound(s) deleted successfully" message.(inboundDelete)















