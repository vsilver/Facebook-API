
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

    protected static void setupRestAssured() {
        RestAssured.baseURI = "https://reqres.in";
    }

    @BeforeTest
    public void setUp() {
        setupRestAssured();
    }

    @Test(description = "Get user", priority = 2)
    public void getUser(){
        given().
                contentType(ContentType.JSON).
         when().get("/api/users?page=2")
                .then().statusCode(200);
    }

    @Test(description = "Post user", priority = 1)
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

    @Test(description = "Change user", priority = 3)
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

    @Test(description = "Delete user", priority = 4)
    public void deleteUser(){
        given()
                .when()
                .delete("/api/users/2")
                .then()
                .statusCode(204);
    }
}
