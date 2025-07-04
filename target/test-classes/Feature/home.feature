Feature: Entrata Website Tests


 Background:
    Given I navigate to Entrata homepage


@smoke
Scenario: Verify Home Page Load
    Then the page title should contain <title>

Examples:
		|  title     |
		|  "Entrata" |


@navigation
  Scenario: Verify homepage core elements and navigation

    And the main navigation menu should contain  <first_navigation> and <second_navigation>
    And "Watch Demo" primary button should be visible and clickable

    Examples:
|first_navigation | second_navigation|
|"sign-in" | "demo" |


 @form_interatction
  Scenario: Interact with Watch Demo form without submission
    When I am on Watch Demo page
    When I enter all form field
    Then watch demo button is clickable without interaction


