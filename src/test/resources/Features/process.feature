@process @smoke
Feature:  User check process page

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
    And User can click process option.
    Then Verify that the user should on the process page.

  @addProcess
  Scenario: User can add process.
    When User can click add process.
    Then Verify that the user should see "Add Process" header.(addProcess)
    When User can enter process name.
    Then Verify that the user should see "This name is available" message.(inbound)
    When User can select process type.
    And User can click submit button.(Asset)
    Then Verify that the user should see success message.(process)
    Then Verify that the added process appears in the process table.

  @seeMoreDetailsProcess
  Scenario: User can check see more details page.
    When User can click tree dot button.
    And User can click see more detail.(process)
    Then Verify that the user should on the "Process Details" page.(process)
    When User can click status button.
    Then Verify that the user should see following options.(processStatus)
      | New         |
      | In Progress |
      | Completed   |
    When User can click tree dot button.
    Then Verify that the user should see following options.(process)
      | Edit Process   |
      | Delete Process |
    And Verify that the user should see "Media" tab.
    And Verify that the user should see following options.(processTableTab)
      | Input Parcel  |
      | Output Parcel |
      | History       |
    When User can click all table tab headers.(inbound)

    @editProcess
    Scenario: User can edit process.
      When User can click tree dot button.
      And User can click edit process.
      Then Verify that the user should see "Edit Process" header.(process)
      When User can edit process name.
      Then Verify that the user should see "This name is available" message.(inbound)
      And Verify that the user should see not enable process type.
      When User can click submit button.(Asset)
      Then Verify that the user should see success message.(process)
      And Verify that the user should be see edited process name in table.


    @deleteProcess
    Scenario: User can delete process.
      When User can click tree dot button.
      And User can click delete process.
      Then Verify that the user should see "Delete Process" header.(deleteProcess)
      And Verify that the user should see "Are you sure you want to delete this Process? This action cannot be undone!" warning message.
      When User can click submit button.(Asset)
      Then Verify that the user should see "Processes deleted successfully" deleted message.(deleteProcess)












