Feature: Application Login

  Scenario: Home page default login
    Given User is on Netbanking landing page
    When User login into application with username = "jane" and password = "12345"
    Then Homepage is opened
    And Cards are displayed = "true"

  Scenario: Home page default login
    Given User is on Netbanking landing page
    When User login into application with username = "john" and password = "54321"
    Then Homepage is opened
    And Cards are displayed = "false"