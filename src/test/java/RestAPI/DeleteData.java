package RestAPI;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;



public class DeleteData {

	  private static final String BASE_URL = "http://localhost:3000";
	    private static final String POSTS_ENDPOINT = "/posts";
	    private static final int POST_ID = 2;

	    @Test
	    public void testDeleteRequest() {
	        String deleteUrl = BASE_URL + POSTS_ENDPOINT + "/" + POST_ID;

	        RequestSpecification request = RestAssured.given();

	        Response response = request.delete(deleteUrl);

	        int actualStatusCode = response.getStatusCode();
	        System.out.println("The Status Code is: " + actualStatusCode);

	        int expectedStatusCode = 200;
	        Assert.assertEquals( expectedStatusCode, actualStatusCode);
	    }
}
