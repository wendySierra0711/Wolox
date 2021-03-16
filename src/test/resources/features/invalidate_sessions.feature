Feature:Invalidate sessions

  As a user of the Nanofy app
  I want to invalidate user sessions
  So verify its functionality

  Scenario: Invalidate sessions
    Given the login in the application with administrator role
    When the session invalidation process runs
    Then validates that the session was invalidated

  Scenario: Invalidate sessions rol regular
    Given the login in the application with regular role
    When the session invalidation process runs
    Then the user validate that the information is not displayed correctly

  Scenario Outline: Consult list purchased albums others validations
    Given you validate the authorization <token>
    When the session invalidation process runs
    Then the user validate that the information is not displayed correctly
    Examples:
      | token |
      | ABLD  |
      |       |

