Feature: BDD ENTER TEXT

  @Main
  @Text
  @MediumTest
  Scenario Outline: Successful Enter Text
    Given I start the page
    When I enter valid text "<inputText>"
    Then I expect to see text
    Examples:
      | inputText |
      | test123   |
