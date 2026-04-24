import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostRawTest {
    @Test
    void postRawTextTest () {
        String requesBody = "This is expected to be sent back as part of response body.";
        given ()
                .body (requesBody)
                .when ()
                .post ("https://postman-echo.com/post")
                .then ()
                .log().all()
                .statusCode (200)
                .body("data", equalTo(requesBody));
    }
}
