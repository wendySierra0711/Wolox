Feature: Consult list photos of the album

  As a user of the Nanofy application
  I want to consult the photos
  So verify the photos of the album

  Scenario Outline: Consult photos
    Given the login in the application with <rol> role
    When  consult list photos of the album with id 1
    Then the user validates that the information is displayed correctly
    And the user validates json schema for photos
    Examples:
      | rol           |
      | administrator |
      | regular       |

  Scenario Outline: Consult photos others validations
    Given you validate the authorization <token>
    When  consult list photos of the album with id 1
    Then the user validate that the information is not displayed correctly
    Examples:
      | token |
      | ABLD  |
      |       |

  Scenario: Consult photos without token
    Given the user wants to login to the application
    When without token the consult list photos with idAlbum 1
    Then the user validate that the information is not displayed correctly