import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class DeleteTest {
    @Test
    void deleteTest() {
        String requestBody = "This is expected to be sent back as part of response body.";
        given()
                .body(requestBody)
                .header("Content-Type", "text/plain")
                .when()
                .delete("https://postman-echo.com/delete")
                .then()
                .log().all()
                .statusCode(200)
                .body("data", equalTo (requestBody));
    }
}
