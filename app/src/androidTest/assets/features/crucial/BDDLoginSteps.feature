Feature: BDD Enter login details

  @LargeTest
    @Main
    @Login
  Scenario Outline: Successful login
    Given I start the application
    When I enter valid account "<account>"
    And I enter valid password <password>
    Then I click login button
    Then I expect to see successful login message
    Examples:
      | account          | password |
      | someone@mail.com | 12345678 |
      | failed@gmail.com   | 111      |
      | ok@gmail.com     | 12345678 |