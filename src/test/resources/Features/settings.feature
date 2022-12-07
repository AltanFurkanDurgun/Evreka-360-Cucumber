@material @smoke
Feature: User check setting page

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
    When User can click settings option.
    Then Verify that the user should on the "Settings" page.(settings)

    @addMaterial
    Scenario: User can add material.
      When User can click add material button.
      Then Verify that the user should see "Add Material" header.(addMaterial)
      When User can enter material name.
      Then Verify that the user should see "This name is available" message.(inbound)
      When User can enter weighting percentage.
      And User can click submit button.(Asset)
      Then Verify that the user should see "Successfully Created Material" message.(addMaterial)
      And Verify that the user should be see material name in material table.


      @editMaterial
      Scenario: User can edit material.
        When User can click tree dot button.
        And User can click edit material.
        Then Verify that the user should see "Edit Material" header.(editMaterial)
        When User can edit material name.
        Then Verify that the user should see "This name is available" message.(inbound)
        When User can click submit button.(Asset)
        Then Verify that the user should see "Successfully Updated Material" message.(editMaterial)
        And Verify that the user should be see edited material in material table.

        @deleteMaterial
        Scenario: User can delete material.
          When User can click tree dot button.
          And User can click delete material.
          Then Verify that the user should see "Delete Material" header.(deleteMaterial)
          And Verify that the user should see delete warning message.
          When User can click submit button.(Asset)
          Then Verify that the user should be see "Material(s) deleted successfully" message.(deleteMaterial)


