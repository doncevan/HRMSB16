package utils;

import io.restassured.RestAssured;

public class APIConstants {
    public static final String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    public static final String CREATE_USER_URI = baseURI + "/createUser.php";
    public static final String GENERATE_TOKEN_URI = baseURI + "/generateToken.php";
    public static final String CREATE_EMPLOYEE_URI = baseURI + "/createEmployee.php";
    public static final String GET_ONE_EMPLOYEE_URI = baseURI + "/getOneEmployee.php";
    public static final String GET_ALL_EMPLOYEES_URI = baseURI + "/getAllEmployees.php";
    public static final String UPDATE_EMPLOYEE_URI = baseURI + "/updateEmployee.php";
    public static final String DELETE_EMPLOYEE_URI = baseURI + "/deleteEmployee.php";
    public static final String PARTIALLY_UPDATE_EMPLOYEE_URI = baseURI + "/updatePartialEmplyeesDetails.php";
    public static final String GET_JOB_TITLE_URI = baseURI + "/jobTitle.php";


    //we need to add headers as well
    public static final String HEADER_CONTENT_TYPE_KEY = "Content-Type";
    public static final String HEADER_CONTENT_TYPE_VALUE = "application/json";
    public static final String HEADER_AUTHORIZATION_KEY = "Authorization";
}
