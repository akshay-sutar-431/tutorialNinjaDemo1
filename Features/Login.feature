Feature: Login functionality
  @Smoke
  Scenario Outline: Verify logging into the Application using valid credentials
    Given User launch the browser
    When I open the application URL "http://tutorialsninja.com/demo"
    And I click on My Account drop menu and click on Login option
    #Then User should navigate to login page
    When I enter the "<Username>" and "<Password>"
    And I click on login button
    Then User should be navigated to Login page "<expected>"
    And close browser
Examples:
  | Username | Password | expected |
  | Admin    | Admin    | Fail |
  | user     | user     | Pass |
