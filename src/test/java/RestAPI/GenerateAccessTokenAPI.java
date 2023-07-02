package RestAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GenerateAccessTokenAPI {

    private static final String CLIENT_ID = "MunaReatAPI";
    private static final String CLIENT_SECRET = "5c2756bac8ce5e077e9954844bae89bc";
    private static final String TOKEN_ENDPOINT = "http://coop.apps.symfonycasts.com/token";
    private static final String BASE_URL = "http://coop.apps.symfonycasts.com/api/4587";

    @Test
    public void testAccessValidAPI() {
        // Obtain token
        Response tokenResponse = RestAssured.given()
                .formParam("client_id", CLIENT_ID)
                .formParam("client_secret", CLIENT_SECRET)
                .formParam("grant_type", "client_credentials")
                .post(TOKEN_ENDPOINT);

        String token = tokenResponse.jsonPath().get("access_token");

        // Make authenticated request
        Response apiResponse = RestAssured.given()
                .auth()
                .oauth2(token)
                .post(BASE_URL + "/chickens-feed");

        int actualStatusCode = apiResponse.getStatusCode();
        System.out.println("The Status Code is: " + actualStatusCode);
        Assert.assertEquals( 200, actualStatusCode);
    }

    @Test
    public void testAccessInvalidAPI() {
        // Obtain token
        Response tokenResponse = RestAssured.given()
                .formParam("client_id", CLIENT_ID)
                .formParam("client_secret", CLIENT_SECRET)
                .formParam("grant_type", "client_credentials")
                .post(TOKEN_ENDPOINT);

        String token = tokenResponse.jsonPath().get("access_token");

        // Make authenticated request to an invalid API
        Response apiResponse = RestAssured.given()
                .auth()
                .oauth2(token)
                .post(BASE_URL + "/eggs-collect");

        int actualStatusCode = apiResponse.getStatusCode();
        System.out.println("The Status Code is: " + actualStatusCode);
        System.out.println("Response Body: " + apiResponse.getBody().asString());
        Assert.assertEquals( 401, actualStatusCode);
    }
}