Feature: BDD Enter login details

    @LargeTest
    @Main
    @Login
  Scenario Outline: Successful login A
    Given I start the application
    When I enter valid account "<account>"
    And I enter valid password <password>
    Then I expect to see successful login message
    Examples:
      | account          | password |
      | someone@mail.com | 12345678 |
#      | test@gmail.com   | 111      |