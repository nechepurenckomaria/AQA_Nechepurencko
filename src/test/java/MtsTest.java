import org.example.MtsPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

class MtsTest {

    static WebDriver driver;

    @BeforeAll
    static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterAll
    static void teardown() {
        driver.quit();
    }

    @Test
    void checkAllFlow() {

        MtsPage page = new MtsPage(driver);

        page.open()
                .acceptCookies()
                .checkTitle()
                .checkLogos()
                .fillForm("297777777", "50", "test@mail.ru")
                .clickContinue()
                .switchToPaymentFrame()
        .checkPaymentForm();


    }
}
