package RestAPI;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;

public class Base {
    private static final String USERNAME = "mounayousef100";
    private static final String PASSWORD = "123mouna\"";
    private static final String BASE_URI = "https://api.github.com";

    @BeforeClass
    public static void setUpAuthentication() {
        RestAssured.authentication = RestAssured.preemptive().basic(USERNAME, PASSWORD);
        RestAssured.baseURI = BASE_URI;
    }
}
