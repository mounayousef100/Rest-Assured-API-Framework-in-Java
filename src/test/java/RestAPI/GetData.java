package RestAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetData {
	  private static final String API_ENDPOINT = "https://api.stackexchange.com/2.3/questions?order=desc&sort=activity&site=stackoverflow";

	    @Test
	    public void testGetResponseCode() {
	        Response response = RestAssured.get(API_ENDPOINT);

	        int actualStatusCode = response.getStatusCode();
	        System.out.println("The Status Code is: " + actualStatusCode);

	        int expectedStatusCode = 200;
	        Assert.assertEquals( expectedStatusCode, actualStatusCode);
	    }

	    @Test
	    public void testGetResponseBody() {
	        Response response = RestAssured.get(API_ENDPOINT);

	        String responseBody = response.getBody().asString();
	        System.out.println("The data is: " + responseBody);
	        System.out.println("The Response time is: " + response.getTime());
	    }
}
