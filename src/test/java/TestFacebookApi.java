
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.basic;
import static org.hamcrest.Matchers.*;

public class TestFacebookApi {

    //private static final String URL = "https://reqres.in";

    protected static void setupRestAssured() {
        RestAssured.baseURI = "https://reqres.in";
    }

    @BeforeTest
    public void setUp() {
        setupRestAssured();
    }

    @Test(description = "Create post")
    public void CreatePost(){
        given().
                contentType(ContentType.JSON).
         when().get("/api/users?page=2")
                .then().statusCode(200);
    }

    
}
