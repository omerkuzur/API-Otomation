package utilities;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class requestUtilities {

    String url;
    JSONObject expBody = new JSONObject();
    Response response;
    JSONObject reqBody = new JSONObject();
    JsonPath actBody;

    public  void setUrl(String urlVar){
        url = urlVar;
    }
    public String getUrl(){
        return url;
    }

    public void setExpBody(){
        expBody.put("userId", 5);
        expBody.put("title", "optio dolor molestias sit");
    }

    public void responseFun(){
        response = given().when().get(getUrl());
    }

    public void assertionFun(){
        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON);

        JsonPath actBody = response.jsonPath();

        Assert.assertEquals(expBody.get("userId"), actBody.get("userId"));
        Assert.assertEquals(expBody.get("title"), actBody.get("title"));
    }


    public void createBody(){
        setUrl("https://jsonplaceholder.typicode.com/posts");

        reqBody.put("title", "API");
        reqBody.put("body", "API ogrenmek ne guzel");
        reqBody.put("userId", 10);
    }
    public void exBodyPreparation(){
        expBody.put("title", "API");
        expBody.put("body", "API ogrenmek ne guzel");
        expBody.put("userId", 10);
    }
    public void compareFun(){
        response = given().
                contentType(ContentType.JSON).
                when().
                body(reqBody.toString()).
                post(getUrl());
        actBody = response.jsonPath();

        response.then().assertThat().contentType(ContentType.JSON).statusCode(201);
    }

    public void assertionPost(){


        Assert.assertEquals(expBody.get("title"), actBody.get("title"));
        Assert.assertEquals(expBody.get("body"), actBody.get("body"));
        Assert.assertEquals(expBody.get("userId"), actBody.get("userId"));

    }
}
