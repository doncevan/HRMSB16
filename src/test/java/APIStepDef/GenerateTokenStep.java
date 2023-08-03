package APIStepDef;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class GenerateTokenStep {

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    public static String token;

    @Given("a JWT is generated")
    public void a_jwt_is_generated() {
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
}
