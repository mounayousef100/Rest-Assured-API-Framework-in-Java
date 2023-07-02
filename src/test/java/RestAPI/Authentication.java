package RestAPI;

import org.testng.annotations.Test;

import io.restassured.*;

public class Authentication extends Base{
    @Test
	public void Test1() {
		
		int code = RestAssured.given()
		.get()
		.getStatusCode();
		System.out.println("The response code from server is : "+ code );

		
	}

}
