Feature: Adding new jobs in HRMS

  Background:
    When user enters valid admin username and password
    And user clicks on login button
    Then user is successfully logged in the application

  @addJob
  Scenario: User adds a new job
    * user clicks on the admin button
    * user click on the job
    * user Click on Job Title
    * user clicks on the add button
    * user enters job "Frog" title
    * user enters job description "Always with java"
    * user enters job note "Java programming notes"
    * user clicks on the save button
    * verify data is stored properly in database
