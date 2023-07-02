package RestAPI;


import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class OAuth {
    
    @Test
    public void test() {
        Response response = RestAssured.given()
                .auth()
                .oauth("Pg1WPgAjp9lbhMEDWmIlqYlFV", "gLmjPexqCIpOCUalT0ho1YJebX1KXPuJoUsUBJhT6LT8hYDbUG",
                        "1673568345424109568-dMz5w7yOJOdNdFLOSxPXAb7MlgjdMj", "csZG4ZBICQN3ce5hBZ6GQKaVvHevDRrXnaJSxIV8IRQ1y")
                .post("https://api.twitter.com/1.1/statuses/update.json?status=This%20is%20first%20post");
        
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody().jsonPath().prettify());
        JsonPath json = response.jsonPath();
        String tweedId = json.get("id_str");
        System.out.println("My Tweet id is :" + tweedId);
        
    }
}