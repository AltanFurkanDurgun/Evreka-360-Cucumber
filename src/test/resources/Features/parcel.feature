@parcel @smoke
Feature: User check parcel`s page.

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
    And User can click parcel option.
    Then Verify that the user should on the parcel page.


  @addParcel
  Scenario: User can add parcel.
    When User can click add parcel button.
    Then Verify that the user should on the "Add Parcel" page.(addParcel)
    When User can enter name.(addParcel)
    Then Verify that the user should see "This name is available" message.(inbound)
    And User can select parcel type.
    And User can select collection scheme type.
    And User can select asset type.(addParcel)
    And User can click submit button.
    Then Verify that the user should see success message.(addParcel)
    And Verify that the user should be see parcel name in table.

  @seeMoreDetailParcel
  Scenario: User can check see more details page.
    When User can click tree dot button.
    And User can click see more detail.
    Then Verify that the user should see "Parcel Details" header.(SMDParcel)
    When User can click tree dot button.
    Then Verify that the user should see following options.(smdParcel)
      | Edit Parcel   |
      | Link Task     |
      | Update Weight |
      | Delete Parcel |
    And Verify that the user should see following options.(tabHeader)
      | Asset |
      | Media |
      | Task  |
    When User can click all tab headers.(orders)
    And Verify that the user should see following options.(tableTabHeader)
      | History        |
      | Linked Inbound |
    When User can click all table tab headers.(orders)

  @editParcel
  Scenario: User can edit parcel.
    When User can click tree dot button.
    And User can click edit parcel.
    Then Verify that the user should on the "Edit Parcel" page.(editParcel)
    When User can edit parcel name.
    And User can click submit button.
    Then Verify that the user should see success message.(addParcel)
    And Verify that the user should be see edited parcel name in table.


  @updateWeight
  Scenario: User can update weight.
    When User can click tree dot button.
    And User can click update weight.
    Then Verify that the user should see "Update Weight" header(updateWeight).
    When User can edit tare weight.
    Then Verify that the user should see net weight count.
    When User can click submit button.(Asset)
    Then Verify that the user should see success message.(addParcel)

  @deleteParcel
  Scenario: User can delete parcel.
    When User can click tree dot button.
    And User can click delete parcel.
    Then Verify that the user should see "Delete Parcel" header.(deleteParcel)
    And Verify that the user should see "Are you sure you want to delete this Parcel? This action cannot be undone!" warning message.
    When User can click submit button.(Asset)
    Then Verify that the user should see "Parcel deleted successfully" deleted message.










