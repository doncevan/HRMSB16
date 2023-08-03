Feature: Adding new job in HRMS application

  Background:
    When user enters valid admin username and password
    And user clicks on login button
    Then user is successfully logged in the application

  @addJob
  Scenario: User adds a new job
    When  user clicks on the admin button
    And  user clicks on job
    And user clicks on Job Title
    And  use clicks on the add button
    And  user enters the job "Java Instructor"title
    And  user enters the job description "Teaches Java"
    And clicks on the save button
    Then  verify data is stored properly in database
