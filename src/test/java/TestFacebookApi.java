
import com.jayway.restassured.http.ContentType;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class TestFacebookApi {

    private static final String URL = "";

    @Test(description = "Create post")
    public void CreatePost(){
        given().
                contentType(ContentType.JSON).
         when().
    }
}
