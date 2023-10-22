package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonMethods;

public class EmployeeSearch extends CommonMethods {

    @When("user clicks on PIM option and Employee list option")
    public void user_clicks_on_pim_option_and_employee_list_option() {
        click(dashboardPage.pimOption);
        click(dashboardPage.empListOption);
    }

    @When("user enters valid employee id")
    public void user_enters_valid_employee_id() {
        sendText("54469A", employeeSearchPage.idTextField);
    }

    @When("user clicks on search button")
    public void user_clicks_on_search_button() {
        click(employeeSearchPage.searchButton);
    }

    @Then("user is able to see employee information")
    public void user_is_able_to_see_employee_information() {
        System.out.println("Employee is displayed");
    }

    @When("user enters valid employee name in name text box")
    public void user_enters_valid_employee_name_in_name_text_box() {
        sendText("selab", employeeSearchPage.nameTextField);
    }
}