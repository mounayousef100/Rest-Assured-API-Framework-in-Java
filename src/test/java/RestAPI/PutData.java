package RestAPI;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutData {
	   private static final String BASE_URL = "http://localhost:3000/posts";
	    private static final String POST_ID = "26";

	    @Test
	    public void testResponsePut() {
	        RequestSpecification request = RestAssured.given();
	        request.header("Content-Type", "application/json");

	        JSONObject json = new JSONObject();
	        json.put("id", POST_ID);
	        json.put("title", "Rest API");
	        json.put("author", "alaa");

	        request.body(json.toString());

	        Response response = request.put(BASE_URL + "/" + POST_ID);
	        int actualStatusCode = response.getStatusCode();
	        System.out.println("The Status Code is: " + actualStatusCode);

	        int expectedStatusCode = 200;
	        Assert.assertEquals( expectedStatusCode, actualStatusCode);
	    }





}
