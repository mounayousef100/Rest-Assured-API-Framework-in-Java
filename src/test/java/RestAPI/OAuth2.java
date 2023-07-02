package RestAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class OAuth2 {

	private static final String ACCESS_TOKEN = "25c9871fa7acfc7c27e10b79c7dcc1f0eb73ba1a";
	private static final String BASE_URL = "http://coop.apps.symfonycasts.com";
	private static final String ENDPOINT = "/api/4587/chickens-feed";

	@Test
	public void testOAuth2Request() {
		Response response = RestAssured.given().auth().oauth2(ACCESS_TOKEN).post(BASE_URL + ENDPOINT);

		System.out.println("The Status Code is: " + response.getStatusCode());
		System.out.println("Response Body:");
		System.out.println(response.getBody().asString());
		System.out.println("Response JSON Pretty Print:");
		System.out.println(response.jsonPath().prettify());

		int actualCode = response.getStatusCode();
		System.out.println("The Status Code is: " + actualCode);

		int expectedCode = 401;
		Assert.assertEquals(actualCode, expectedCode);
	}
}