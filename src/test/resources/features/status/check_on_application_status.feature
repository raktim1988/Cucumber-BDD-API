Feature: Check on application status

  The `/api/status` end point returns a status message to indicate that the application is running successfully.

  Scenario: Application status end-point
    Given the application is running
    When I check the application status
    Then the API response should return "200"

  Scenario: Application status end-point
    Given the application is running
    When I check the application status
    Then the API response should not return "400"
