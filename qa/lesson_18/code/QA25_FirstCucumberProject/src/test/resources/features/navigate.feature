Feature: Home Page UI

  @navigate
  Scenario: Verify Home Page title is displayed
    Given User launches ChromeBrowser
    When User opens ilcarro Home Page
    Then User verifies Home Page title is displayed
    And User quites browser
