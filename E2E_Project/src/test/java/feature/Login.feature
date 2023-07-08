Feature: Login into Application
  Scenario Outline: Positive test validating login
    Given Initialise driver with chrome browser
    And Navigate to "https://qaclickacademy.com" site
    And Clicking on login link on home page to land on sign in page
    When User enters <username> and <password> and logs in
    Then Verify that user is successfully logged in
    And Close the Browsers
    Examples:
      | username          | password |
      | test99@gmail.com  | 123456   |
      | test123@gmail.com | 12345    |