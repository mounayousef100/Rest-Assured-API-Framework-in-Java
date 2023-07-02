package RestAPI;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostData {


    private static final String BASE_URL = "http://localhost:3000/posts";

    @Test
    public void testResponsePost() {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");

        JSONObject json = new JSONObject();
        json.put("id", "51");
        json.put("title", "Rest API");
        json.put("author", "Muna");

        request.body(json.toString());

        Response response = request.post(BASE_URL);
        int actualStatusCode = response.getStatusCode();
        System.out.println("The Status Code is: " + actualStatusCode);

        int expectedStatusCode = 201;
        Assert.assertEquals( expectedStatusCode, actualStatusCode);
    }
}
