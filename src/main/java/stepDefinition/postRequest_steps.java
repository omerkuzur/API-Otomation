package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import utilities.requestUtilities;

import static io.restassured.RestAssured.given;

public class postRequest_steps {

    requestUtilities requestUtilities = new requestUtilities();


    @Given("create request url")
    public void create_request_url() {
        requestUtilities.setUrl("https://jsonplaceholder.typicode.com/posts/44");

    }
    @Given("create body")
    public void create_body() {
        requestUtilities.createBody();
    }
    @Given("preparation of expected data")
    public void preparation_of_expected_data() {
        requestUtilities.exBodyPreparation();
    }
    @Given("compare response")
    public void compare_response() {
        requestUtilities.compareFun();
    }
    @Then("assertion processing")
    public void assertion_processing() {
     requestUtilities.assertionPost();
    }

}
