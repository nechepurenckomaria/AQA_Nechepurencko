import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PutTest {
    @Test
    void putTest () {
     String requestBody = "This is expected to be sent back as part of response body.";
     given()
             .body(requestBody)
             .headers("Content-Type", "text/plain")
             .when ()
             .put("https://postman-echo.com/put")
             .then()
             .log().all()
             .statusCode(200)
             .body("data", equalTo(requestBody));
    }
}
