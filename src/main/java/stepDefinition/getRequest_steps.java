package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import utilities.requestUtilities;

import static io.restassured.RestAssured.given;

public class getRequest_steps {

    requestUtilities requestUtilities = new requestUtilities();

    @Given("create request url and body")
    public void createBody() throws  Throwable{
        requestUtilities.setUrl("https://jsonplaceholder.typicode.com/posts/44");
    }

    @And("create expected data")
    public void createExpectedData() throws  Throwable{
        requestUtilities.setExpBody();

    }

    @And("save response")
    public void saveResponse() throws  Throwable{
        requestUtilities.responseFun();
    }

    @Then("assertion")
    public void assertion() throws  Throwable{
        requestUtilities.assertionFun();
    }
}
