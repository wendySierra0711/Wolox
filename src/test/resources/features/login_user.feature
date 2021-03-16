Feature: Login to the application

  As a user of the Nanofy application
  I want to login to the application
  So check the functionality

  Scenario Outline:  Login to the application
    Given the user wants to login to the application
    When The user login with the data
      | email   | password   |
      | <email> | <password> |
    And the user validates json schema for login
    Then the user validates that he was logged in correctly
    Examples:
      | email                  | password  |
      | Pruebawlx@wolox.com.ar | 1234*SSaa |

  Scenario Outline:  Login to the application alternate cases
    Given the user wants to login to the application
    When The user login with the wrong data
      | email   | password   |
      | <email> | <password> |
    Then the user validates that the <code> and <message> is displayed correctly
    Examples:
      | email                  | password  | code             | message                                                                                          |
      | Pruebawlx@wol.com.ar   | 1234*SSaa | validation_error | The email must be @wolox.com.ar                                                                  |
      | Pruebawlx@wol.com.ar   | 1234      | validation_error | The email must be @wolox.com.ar. Password format invalid. Password must be at least 8 characters |
      | Pruebawlx@wolox.com.ar | 1234      | validation_error | Password format invalid. Password must be at least 8 characters                                  |

  Scenario Outline:  Login to the application mandatory fields
    Given the user wants to login to the application
    When The user login with the wrong data
      | email   | password   |
      | <email> | <password> |
    Then the user validates the mandatory fields with <code> and <message>
    Examples:
      | email                  | password | code               | message                           |
      | Pruebawlx@wolox.com.ar |          | missing_data_error | missing required fields: password |
      |                        | 1234     | missing_data_error | missing required fields: email    |
