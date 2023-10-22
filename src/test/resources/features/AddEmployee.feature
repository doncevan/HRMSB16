Feature: Adding employee in HRMS application

  Background:
    When user enters valid admin username and password
    And user clicks on login button
    Then user is successfully logged in the application
    When user clicks on PIM option
    And user clicks on add employee button

  @test
  Scenario: adding one employee
    When user enters firstname and lastname
    And user clicks on save button
    Then employee added successfully

  @sample
  Scenario: Adding one employee from feature file
    When user enters "Abel" and "Ava" and "Abrams"
    And user clicks on save button
    Then employee added successfully

  @outline
  Scenario Outline: adding multiple employees using scenario outline
    When user enters "<firstName>" and "<middleName>" and "<lastName>" in data driven format
    And user clicks on save button
    Then employee added successfully
    Examples:
      | firstName | middleName | lastName |
      | Ana       | Maria      | Abb      |
      | Ariana    | Zoia       | Aaw      |
      | Ael       | Caty       | Abe      |

  @datatable
  Scenario: adding multiple employees using data table
    When user enters firstName and middleName and lastName and verify employee has added
      | firstName | middleName | lastName |
      | Ana       | Maria      | Abb      |
      | Ariana    | Zoia       | Aaw      |
      | Ael       | Caty       | Abe      |

  @excel
  Scenario: adding multiple employees using excel file
    When user adds multiple employees using excel from "EmployeeDataBatch16" and verify it
    Then  user deletes multiple employees

  @Db
  Scenario: Adding one employee from feature file
    When user enters "adam" and "Aunt" and "Aaw"
    And user clicks on save button
    Then employee added successfully
    Then  verify employee is stored in database
