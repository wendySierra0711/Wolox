Feature: Consult list purchased albums

  As a user of the Nanofy application
  I want to consult the list purchased albums
  So verify the buy

  Scenario: Consult list purchased albums
    Given the login in the application with administrator role
    When consult list purchased albums of the customer with id 498
    Then the user validates that the information is displayed correctly
    And the user validates json schema for purchased_albums

  Scenario: Consult list purchased albums rol regular
    Given the login in the application with regular role
    When consult list purchased albums of the customer with id 498
    Then the user validates that he does not have permissions for the information

  Scenario Outline: Consult list purchased albums others validations
    Given you validate the authorization <token>
    When consult list purchased albums of the customer with id 498
    Then the user validate that the information is not displayed correctly
    Examples:
      | token |
      | ABLD  |
      |       |
  Scenario: Consult list purchased albums without token
    Given the user wants to login to the application
    When without token the consult list purchased albums with idUser 498
    Then the user validate that the information is not displayed correctly

