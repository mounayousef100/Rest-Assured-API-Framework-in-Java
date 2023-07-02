package RestAPI;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.http.Header;

import java.util.Map;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;

public class TestCookies {

    private static final String URL = "https://www.bayt.com/en/jordan/";

    @Test
    public void testCookiesHeader() {
        Response response = get(URL);

        Map<String, String> cookies = response.getCookies();
        System.out.println("Cookies:");
        for (Map.Entry<String, String> entry : cookies.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("\nHeaders:");
        for (Header header : response.getHeaders().asList()) {
            System.out.println(header.getName() + ": " + header.getValue());
        }

        int actualStatusCode = response.getStatusCode();
        System.out.println("The Status Code is: " + actualStatusCode);

        int expectedStatusCode = 200;
        Assert.assertEquals( expectedStatusCode, actualStatusCode);
    }

    @Test
    public void testDetailedCookies() {
        Response response = get(URL);

        Cookies cookies = response.getDetailedCookies();
        System.out.println("Detailed Cookies:");
        for (Cookie cookie : cookies) {
            System.out.println("Name: " + cookie.getName());
            System.out.println("Value: " + cookie.getValue());
            System.out.println("Domain: " + cookie.getDomain());
            System.out.println("Path: " + cookie.getPath());
            System.out.println("Expiry Date: " + cookie.getExpiryDate());
            System.out.println();
        }

        int actualStatusCode = response.getStatusCode();
        System.out.println("The Status Code is: " + actualStatusCode);

        int expectedStatusCode = 200;
        Assert.assertEquals( expectedStatusCode, actualStatusCode);
    }
}
    
    