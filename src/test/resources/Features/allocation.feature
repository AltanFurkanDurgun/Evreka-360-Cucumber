@allocation @smoke
Feature: User can check allocation page

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
    And User can click allocation option.
    Then Verify that the user should on the "Allocation" page.(allocation)

  @addAllocation
  Scenario: User can add allocation.
    When User can click add allocation.
    Then Verify that the user should see "Add Allocation" header.(allocation)
    When User can enter allocation name.
    Then Verify that the user should see "This name is available" message.(inbound)
    When User can select allocation type.
    And User can select facility.
    And User can enter date in due date box.
    And User can select material type.(allocation)
    Then Verify that the user should see "If left blank, it will be automatically set to 'as much as possible'." message.(allocation)
    When User can click submit button.
    Then Verify that the user should see success message.(allocation)
    And Verify that the created allocation appears in the allocation table.

  @seeMoreDetailsAllocation
  Scenario: User can check see more details page.
    When User can click tree dot button.
    And User can click see more detail.
    Then Verify that the user should on the "Allocation Details" page.(SMDAllocation)
    When User can click status button.
    Then Verify that the user should see following options.(processStatus)
      | New         |
      | In Progress |
      | Done        |
    When User can click tree dot button.
    Then Verify that the user should see following options.(process)
      | Edit Allocation   |
      | Delete Allocation |
    And Verify that the user should see following options.(allocationTab)
      | Material Types |
      | Delivery Note  |
    When User can click all tab headers.(inbound)
    Then Verify that the user should see following options.(allocationTableTab)
      | Parcel  |
      | History |
    When User can click all table tab headers.(inbound)

  @editAllocation
  Scenario: User can edit allocation.
    When User can click tree dot button.
    And User can click edit allocation.
    Then Verify that the user should see on the "Edit Allocation" page.(editAllocation)
    When User can edit allocation name.
    Then Verify that the user should see "This name is available" message.(inbound)
    When User can click submit button.
    Then Verify that the user should see success message.(editAllocation)
    And Verify that the edited allocation appears in the allocation table.

    @deleteAllocation
    Scenario: User can delete allocation.
    When User can click tree dot button.
    And User can click delete allocation.
    Then Verify that the user should see "Delete Allocation" header.(deleteAllocation)
    And Verify that the user should see "Are you sure you want to delete this Allocation? This action cannot be undone!" warning message.
    When User can click submit button.(Asset)
    Then Verify that the user should see "Allocation deleted successfully" deleted message.(deleteMessage)








