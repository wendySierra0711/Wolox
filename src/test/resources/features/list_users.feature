Feature: Consult list users

  As a user of the Nanofy application
  I want to consult the users
  So verify personal data

  Scenario: Consult users administrator
    Given the login in the application with administrator role
    When  consult the user list
    Then the user validates that the information is displayed correctly
    And the user validates json schema for user

  Scenario: Consult users regular
    Given the login in the application with regular role
    When consult the user list
    Then the user validates that the information is displayed correctly
    And validate the role of returned users

  Scenario Outline: Consult users with registered users
    Given the user wants to login to the application
    When The user login with the data
      | email   | password   |
      | <email> | <password> |
    And consult the user list
    Then the user validates that the information is displayed correctly
    Examples:
      | email                  | password  |
      | Pruebawlx@wolox.com.ar | 1234*SSaa |

  Scenario Outline: Consult users others validations
    Given you validate the authorization <token>
    When consult the user list
    Then the user validate that the information is not displayed correctly
    Examples:
      | token |
      | ABLD  |
      |       |

  Scenario: Consult users without token
    Given the user wants to login to the application
    When to consult user list without token
    Then the user validate that the information is not displayed correctly