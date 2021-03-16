Feature: Register client

  As a user of the Naiofy application
  I want to register a client in the application
  So check the functionality

  Scenario Outline: Register new client
    Given the user wants to create a new customer
    When the user register client with the following data
      | email   | password   | firstName   | lastName   |
      | <email> | <password> | <firstName> | <lastName> |
    Then the user validates that the client was registered successfully
    Examples:
      | email                     | password   | firstName | lastName |
      | PruebaWSs101@wolox.com.ar | 1234*SSaaq | amandaM   | wlx      |
      | PruebaWSs091@wolox.com.ar | 1234*SSaaq | milenaMM  | wlx      |

  Scenario Outline: Register new client alternate cases
    Given the user wants to create a new customer
    When the user register client with the following data
      | email   | password   | firstName   | lastName   |
      | <email> | <password> | <firstName> | <lastName> |
    Then the user validates that the <code> and <message> is displayed correctly
    Examples:
      | email                      | password   | firstName | lastName | code                  | message                                                                                          |
      | Pruebawws@aaa.com.ar       | 1234*SSaaq | Prueba    | wlx      | validation_error      | The email must be @wolox.com.ar                                                                  |
      | Pruebhgjx@wolox.com.ar     | 1234*SSaaq | Prueba    | wlx      | entity_already_exists | Unable to create new user. The resource you are trying to create already exists                  |
      | Pruebhgjx@UU.com.ar        | 1234       | Prueba    | wlx      | validation_error      | The email must be @wolox.com.ar. Password format invalid. Password must be at least 8 characters |
      | Pruebhgjx@wolox.com.ar     | 1234       | Prueba    | wlx      | validation_error      | Password format invalid. Password must be at least 8 characters                                  |
      | @wolox.com.ar              | 1234*SSaaq | Prueba    | wlx      | validation_error      | Invalid email                                                                                    |
      | Prsuebpedpse5@wolox.com.ar | 1234*SSaaq | Prueba    | 1        | error                 | error                                                                                            |
      | Prusebpedwpe7@wolox.com.ar | 1234*SSaaq | 1         | wlx      | error                 | error                                                                                            |

  Scenario Outline: Register new client mandatory fields
    Given the user wants to create a new customer
    When the user register client with the following data
      | email   | password   | firstName   | lastName   |
      | <email> | <password> | <firstName> | <lastName> |
    Then the user validates the mandatory fields with <code> and <message>
    Examples:
      | email                  | password   | firstName | lastName | code               | message                            |
      |                        | 1234*SSaaq | Prueba    | wlx      | missing_data_error | missing required fields: email     |
      | Pruebhgjx@wolox.com.ar |            | Prueba    | wlx      | missing_data_error | missing required fields: password  |
      | Pruebhgjx@wolox.com.ar | 1234*SSaaq |           | wlx      | missing_data_error | missing required fields: firstName |
      | Pruebhgjx@wolox.com.ar | 1234*SSaaq | Prueba    |          | missing_data_error | missing required fields: lastName  |
