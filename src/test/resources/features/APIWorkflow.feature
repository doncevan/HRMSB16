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
    And this employee data at "employee" object matches with the data used to create the employee
      | emp_firstname | emp_lastname | emp_middle_name | emp_gender | emp_birthday | emp_status | emp_job_title |
      | Jacob         | Bronson      | Van             | Male       | 2003-03-20   | working    | QA            |

  @json
  Scenario: Creating an employee using json body
    Given a request is prepared for creating an employee using json payload
    When a POST call is made to create an employee
    Then the status code for creating an employee is 201
    And  the employee created contains key " Message" and value "Employee Created"
    And the employee id "Employee.employee_id" is stored as a global variable

  @dynamic1
  Scenario: Creating an employee using highly dynamic scenario
    Given a request is prepared for creating an employee with data "Jacob", "Bronson", "Van", "M", "2003-03-20", "working", "QA"
    When a POST call is made to create an employee
    Then the status code for creating an employee is 201
    And  the employee created contains key " Message" and value "Employee Created"
    And the employee id "Employee.employee_id" is stored as a global variable

  @dynamic
  Scenario: Partially updating an employee using highly dynamic scenario
    Given a request is prepared for partially updating an employee with data "Brandosa"
    When a PATCH call is made to partially update an employee
    Then the status code for partially updating an employee is 201
    And  the partially updated employee contains key " Message" and value "Employee record updated successfully"
    And the partially updated employee's id "employee.employee_id" is stored as a global variable


  @dynamic
  Scenario: Get the partially updated employee
    Given a request is prepared for retrieving a partially updated employee
    When  a GET call is made to retrieve the partially updated employee
    Then  the status code for the partially updated employee is 200
    And the employee id "employee.employee_id" must match with globally stored employee id
    And this employee data at "employee" object matches with the data used to partially update the employee
      | emp_firstname | emp_lastname | emp_middle_name | emp_gender | emp_birthday | emp_status | emp_job_title |
      | Brandosa      | Bronson      | Van             | Male       | 2003-03-20   | working    | QA            |