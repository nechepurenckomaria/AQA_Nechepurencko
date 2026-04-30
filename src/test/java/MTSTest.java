import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

public class MTSTest {

    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

    private void acceptCookies() {
        try {
            WebElement cookieButton = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//button[contains(text(), 'Принять')]")));
            cookieButton.click();
        } catch (Exception e) {
            System.out.println("Баннер с куки не появился или уже принят");
        }
    }

    @Test
    void checkBlockTitle() {
        driver.get("https://mts.by");
        acceptCookies();

        WebElement title = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//h2[contains(., 'Онлайн пополнение') and contains(., 'без комиссии')]")));

        Assertions.assertTrue(title.isDisplayed());
    }

    @Test
    void checkVisaLogo() {
        driver.get("https://mts.by");
        acceptCookies();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@alt,'Visa')]")));
    }

    @Test
    void checkVerifiedByVisaLogo() {
        driver.get("https://mts.by");
        acceptCookies();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@alt,'Verified By Visa')]")));
    }

    @Test
    void checkMasterCardLogo() {
        driver.get("https://mts.by");
        acceptCookies();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@alt,'MasterCard')]")));
    }

    @Test
    void checkMasterCardSecureCodeLogo() {
        driver.get("https://mts.by");
        acceptCookies();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@alt,'MasterCard Secure Code')]")));
    }

    @Test
    void checkBelcartLogo() {
        driver.get("https://mts.by");
        acceptCookies();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@alt,'Белкарт')]")));
    }

    @Test
    void checkDetailsLink() {
        driver.get("https://mts.by");
        acceptCookies();

        WebElement link = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.linkText("Подробнее о сервисе")));

        link.click();

        Assertions.assertTrue(driver.getCurrentUrl().contains("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey"));
    }

    @Test
    void checkContinueButton() {
        driver.get("https://mts.by");
        acceptCookies();

        WebElement phoneInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='connection-phone']")));

        phoneInput.sendKeys("297777777");

        WebElement amountInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id = 'connection-sum']")));

        amountInput.sendKeys("50");

        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id = 'connection-email']")));

        emailInput.sendKeys("nmr@mail.ru");


        WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(.,'Продолжить')]")));

        continueBtn.click();

        WebElement paymentFrame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[contains(@class, 'payment-widget-iframe')]")));

        driver.switchTo().frame(paymentFrame);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe")));
    }
}


