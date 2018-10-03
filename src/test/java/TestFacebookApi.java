
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

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

    @Test(description = "Get user")
    public void getUser(){
        given().
                contentType(ContentType.JSON).
         when().get("/api/users?page=2")
                .then().statusCode(200);
    }

    @Test(description = "Post user")
    public void postUser(){
        Map<String,String> user = new HashMap<>();
        user.put("name", "morpheus" );
        user.put("job", "leader" );

        given().
                contentType("application/json")
                .body(user)
                .when().post("/api/users")
                .then().statusCode(201);
    }

    @Test(description = "Change user")
    public void changeUser(){
        Map<String,String> user = new HashMap<>();
        user.put("name", "morpheus" );
        user.put("job", "zion resident" );

        given().
                contentType("application/json")
                .body(user)
                .when().put("/api/users")
                .then().statusCode(200);

    }

    @Test(description = "Delete user")
    public void deleteUser(){
        given()
                .when()
                .delete("/api/users/2")
                .then()
                .statusCode(204);

    }


}
