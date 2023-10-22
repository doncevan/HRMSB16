package steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedAPI {

    //baseURI = baseURL + endpoint
    //given - preparation
    //when - hitting the endpoint
    //base URI = base URL

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    static String employee_id;
    static String token;

    @Test
    public void a_generateToken() {
        RequestSpecification request = given().
                header("Content-Type", "application/json").
                body("{\n" +
                        "  \"email\": \"myvanelly@test.com\",\n" +
                        "  \"password\": \"06032008\"\n" +
                        "}");
        Response response = request.when().post("/generateToken.php");
        //response.prettyPrint();
        token = "Bearer " + response.jsonPath().getString("token");
        System.out.println(token);
    }

    //in this method we are going to create an employee
    //we need headers, body to prepare the request
    @Test
    public void b_createEmployee() {
        //preparing the request
        RequestSpecification request = given().header("Content-Type", "application/json").
                header("Authorization", token).body("{\n" +
                        "  \"emp_firstname\": \"Jacob\",\n" +
                        "  \"emp_lastname\": \"Vanelly\",\n" +
                        "  \"emp_middle_name\": \"Bronson\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"2003-03-20\",\n" +
                        "  \"emp_status\": \"working\",\n" +
                        "  \"emp_job_title\": \"QA\"\n" +
                        "}");
        //hitting the endpoint
        Response response = request.when().post("/createEmployee.php");
        //verifying the response
        response.then().assertThat().statusCode(201);
        //  System.out.println(response);
        //this method we use to print the response of API in console
        response.prettyPrint();

        //verify all the values and headers from response
        response.then().assertThat().body("Employee.emp_firstname", equalTo("Jacob"));
        response.then().assertThat().body("Employee.emp_middle_name", equalTo("Bronson"));
        response.then().assertThat().body("Message", equalTo("Employee Created"));
        response.then().assertThat().header("X-Powered-By", "PHP/7.2.18");
        employee_id = response.jsonPath().get("Employee.employee_id");
        System.out.println(employee_id);
    }

    @Test
    public void c_getCreatedEmployee() {
        RequestSpecification request = given().header("Authorization", token).queryParam("employee_id", employee_id);
        Response response = request.when().get("/getOneEmployee.php");
        response.then().assertThat().statusCode(200);
        response.prettyPrint();

        String tempEmpId = response.jsonPath().getString("employee.employee_id");
        Assert.assertEquals(employee_id, tempEmpId);
    }

    @Test
    public void d_updateEmployee() {
        RequestSpecification request = given().header("Content-Type", "application/json").
                header("Authorization", token).body("{\n" +
                        "  \"employee_id\": \"" + employee_id + "\",\n" +
                        "  \"emp_firstname\": \"Branda\",\n" +
                        "  \"emp_lastname\": \"LetsGo\",\n" +
                        "  \"emp_middle_name\": \"JuL\",\n" +
                        "  \"emp_gender\": \"F\",\n" +
                        "  \"emp_birthday\": \"2025-07-29\",\n" +
                        "  \"emp_status\": \"smoking\",\n" +
                        "  \"emp_job_title\": \"senile\"\n" +
                        "}");
        Response response = request.when().put("/updateEmployee.php");
        response.then().assertThat().statusCode(200);
        response.then().assertThat().body("Message", equalTo("Employee record Updated"));
    }

    @Test
    public void e_getUpdatedEmployee() {
        RequestSpecification request = given().header("Authorization", token).queryParam("employee_id", employee_id);
        Response response = request.when().get("/getOneEmployee.php");
        response.then().assertThat().statusCode(200);
        response.prettyPrint();

        String tempEmpId = response.jsonPath().getString("employee.employee_id");
        Assert.assertEquals(employee_id, tempEmpId);
    }

    @Test
    public void f_partiallyUpdateEmployee() {
        RequestSpecification request = given().header("Content-Type", "application/json").
                header("Authorization", token).body("{\n" +
                        "  \"employee_id\": \"" + employee_id + "\",\n" +
                        "  \"emp_firstname\": \"Brandosa\"\n" +
                        "}");
        Response response = request.when().patch("/updatePartialEmplyeesDetails.php");
        response.then().assertThat().statusCode(201);
        response.then().assertThat().body("Message", equalTo("Employee record updated successfully"));
        response.then().assertThat().header("Server", equalTo("Apache/2.4.39 (Win64) PHP/7.2.18"));
        response.prettyPrint();
        String actualId = response.jsonPath().getString("employee.employee_id");
        Assert.assertEquals(employee_id, actualId);
    }

    @Test
    public void h_getPartiallyUpdatedEmployee() {
        RequestSpecification request = given().header("Authorization", token).queryParam("employee_id", employee_id);
        Response response = request.when().get("/getOneEmployee.php");
        response.then().assertThat().statusCode(200);
        response.prettyPrint();

        String tempEmpId = response.jsonPath().getString("employee.employee_id");
        Assert.assertEquals(employee_id, tempEmpId);
    }
}