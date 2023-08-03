Feature: Syntax API HRMS Flow

  Background:
    Given a JWT is generated

  @api
  Scenario: Creating the employee using API
    Given a request is prepared for creating an employee
    When a POST call is made to create an employee
    Then the status code for creating an employee is 201
    And  the employee created contains key " Message" and value "Employee Created"
    And the employee id "Employee.employee_id" is stored as a global variable

  @api
  Scenario: Get the created employee
    Given a request is prepared for retrieving an employee
    When  a GET call is made to retrieve the employee
    Then  the status code for this employee is 200
    And the employee id "employee.employee_id" must match with globally stored employee id


