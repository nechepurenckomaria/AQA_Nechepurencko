import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetTest {
    @Test
    void getWithParamsTest () {
        given ()
                .queryParam ("foo1", "bar1")
                .queryParam ("foo2", "bar2")
                .when()
                .get("https://postman-echo.com/get")
                .then()
                .log().all()
                .statusCode(200)
                .body("args.foo1",equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"));
    }
    @Test
    void getWithoutparamsTest() {
        when()
                .get("https://postman-echo.com/get")
                .then()
                .log().all()
                .statusCode(200)
                .body("args", anEmptyMap());
    }
}
