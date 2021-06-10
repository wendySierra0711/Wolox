Feature: Buy album

  As a user of the Naiofy app
  I want to buy an album
  So verify the functionality

  Scenario Outline: Buy album
    Given the login in the application with <rol> role
    When the user buy album with <id>
    Then the user validate the buy is successfully
    Examples:
      | rol           | id |
      | administrator | 28  |
      | regular       | 27  |
      sdgjdskv

  Scenario Outline: Buy album customer created
    Given the user wants to login to the application
    When The user login with the data
      | email   | password   |
      | <email> | <password> |
    And the user buy album with <id>
    Then the user validate the buy is successfully
    Examples:
      | email                  | password  |id|
      | Pruebawlx@wolox.com.ar | 1234*SSaa |29 |

  Scenario: Buy album without token
    Given the user wants to login to the application
    When buy album without token with idAlbum 1
    Then the user validate that the information is not displayed correctly

  Scenario Outline: Buy album other data validations
    Given the login in the application with <rol> role
    When the user buy album with <id>
    Then the user validates that he does not allow to buy the album
    Examples:
      | rol           | id |
      | administrator | 1  |
      | administrator | 1  |
      | regular       | 2  |
      | regular       | 2  |

  Scenario Outline: Buy album others token validations
    Given you validate the authorization <token>
    When the user buy album with <id>
    Then the user validate that the information is not displayed correctly
    Examples:
      | id | token |
      | 1  | ABLD  |
      | 1  |       |


