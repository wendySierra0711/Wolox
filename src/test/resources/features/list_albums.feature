Feature: Consult list albums

  As a user of the Nanofy application
  I want to consult the albums
  So verify albums

  Scenario Outline: Consult albums
    Given the login in the application with <rol> role
    When  consult the albums list
    Then the user validates that the information is displayed correctly
    And the user validates json schema for albums
    Examples:
      | rol           |
      | administrator |
      | regular       |

  Scenario Outline: Consult albums others validations
    Given you validate the authorization <token>
    When  consult the albums list
    Then the user validate that the information is not displayed correctly
    Examples:
      | token |
      | ABLD  |
      |       |

  Scenario: Consult albums without token
    Given the user wants to login to the application
    When to consult albums list without token
    Then the user validate that the information is not displayed correctly