Feature: Happy path login scenario

  @login
  Scenario: User can login valid credentials
    Given User navigate to login page.
    Then Verify that the user on the login page.
    And Verify that the user should be see "Login Page" text.
    And Verify that the user should be see "Username" and "Password" labels.
    And Verify that the user should be see empty username and empty password box.
    And Verify that the user should be see "Username" and "Password" placeholders.
    When User can be enter username in username box.
    And User can be enter password in password box.
    Then Verify that the user should be see "Remember Me" checkbox text.
    And Verify that the user should see the login button.
    When User can click on login button.
    Then Verify that the user should be on the home page.
    And Verify that the login username should be match the username on the homepage.

  @negativeLogin
  Scenario Outline: User can't login invalid credentials.
    Given User navigate to login page.
    Then Verify that the user on the login page.
    When User input invalid "<username>" and invalid "<password>".
  #  When User can click on login button.
    Then Verify that the user should be see "<errorMessage>" error message.
    Examples:
      | username | password   | errorMessage                                                                               |
      |          | Evreka123! | Please fill out this field.                                                                |
      | burhan   |            | Please fill out this field.                                                                |
      |          |            | Please fill out this field.                                                                |
      | user     | Evreka123! | Please enter a correct username and password. Note that both fields may be case-sensitive. |
      | burhan   | Evreka     | Please enter a correct username and password. Note that both fields may be case-sensitive. |