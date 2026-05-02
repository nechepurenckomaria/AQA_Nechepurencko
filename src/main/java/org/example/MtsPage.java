package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MtsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public MtsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    private By cookieBtn = By.xpath("//button[contains(text(),'Принять')]");
    private By title = By.xpath("//h2[contains(., 'Онлайн пополнение') and contains(., 'без комиссии')]");

    private By visaLogo = By.xpath("//img[contains(@alt,'Visa')]");
    private By verifiedVisaLogo = By.xpath("//img[contains(@alt,'Verified By Visa')]");
    private By masterCardLogo = By.xpath("//img[contains(@alt,'MasterCard')]");
    private By secureCodeLogo = By.xpath("//img[contains(@alt,'MasterCard Secure Code')]");
    private By belkartLogo = By.xpath("//img[contains(@alt,'Белкарт')]");

    private By detailsLink = By.linkText("Подробнее о сервисе");

    private By phoneInput = By.xpath("//input[@id='connection-phone']");
    private By amountInput = By.xpath("//input[@id='connection-sum']");
    private By emailInput = By.xpath("//input[@id='connection-email']");
    private By continueBtn = By.xpath("//button[contains(., 'Продолжить')]");

    private By iframe = By.xpath("//iframe");

    private By serviceDropdown = By.xpath("//button[contains(@class, 'select__header')]");
    private By InternetPhoneInput = By.xpath("//input[contains(@placeholder, 'Номер абонента')]");
    private By installmentInput = By.xpath("//input[contains(@placeholder, 'Номер счета')]");
    private By debtInput = By.xpath("//input[contains(@placeholder, 'Номер счета на 2073')]");

    private By amountText = By.xpath("//span[contains(text(), 'BYN')]");
    private By phoneText = By.xpath("//span[contains(text(), 'Номер:')]");
    private By cardNumber = By.xpath("//input[@formcontrolname = 'cc-number']");
    private By expiry = By.xpath("//input[@formcontrolname = 'expDate']");
    private By cvc = By.xpath("//input[@placeholder = 'cvc']");
    private By cardName = By.xpath("//input[contains(@placeholder, 'Имя')]");

    private By payButton = By.xpath("//button[contains(., 'Оплатить')]");

    public MtsPage open() {
        driver.get("https://mts.by");
        return this;
    }

    public MtsPage acceptCookies() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(cookieBtn)).click();
        } catch (Exception e) {
            System.out.println("Куки не появились");
        }
        return this;
    }

    public MtsPage checkTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(title));
        return this;
    }

    public MtsPage checkLogos() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(visaLogo));
        wait.until(ExpectedConditions.visibilityOfElementLocated(verifiedVisaLogo));
        wait.until(ExpectedConditions.visibilityOfElementLocated(masterCardLogo));
        wait.until(ExpectedConditions.visibilityOfElementLocated(secureCodeLogo));
        wait.until(ExpectedConditions.visibilityOfElementLocated(belkartLogo));
        return this;
    }

    public MtsPage clickDetails() {
        wait.until(ExpectedConditions.elementToBeClickable(detailsLink)).click();
        return this;
    }

    public MtsPage fillForm(String phone, String amount, String email) {

        WebElement phoneField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(phoneInput)
        );

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", phoneField);

        phoneField.sendKeys(phone);

        driver.findElement(amountInput).sendKeys(amount);
        driver.findElement(emailInput).sendKeys(email);

        return this;
    }

    public MtsPage clickContinue() {
        driver.findElement(continueBtn).click();
        return this;
    }

    public MtsPage switchToPaymentFrame() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                By.xpath("//iframe[contains(@class,'payment-widget-iframe')]")));
        return this;

    }


    public MtsPage selectService(String serviceName) {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(serviceDropdown));

        dropdown.click();

        By option = By.xpath(String.format("//li[contains(@class, 'select__item') and normalize-space()='%s']", serviceName));

        wait.until(ExpectedConditions.elementToBeClickable(option)).click();
        return this;
    }

    public MtsPage checkPlaceholdersForMobile() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneInput));
        assertEquals("Номер телефона", driver.findElement(phoneInput).getAttribute("placeholder"));
        assertEquals("Сумма", driver.findElement(amountInput).getAttribute("placeholder"));
        assertEquals("E-mail для отправки чека", driver.findElement(emailInput).getAttribute("placeholder"));
        return this;

    }
    public MtsPage checkPlaceholdersForInternet () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(InternetPhoneInput));
        assertEquals("Номер абонента", driver.findElement(InternetPhoneInput).getAttribute("placeholder"));
        assertEquals("Сумма", driver.findElement(amountInput).getAttribute("placeholder"));
        assertEquals("E-mail для отправки чека", driver.findElement(emailInput).getAttribute("placeholder"));
        return this;
    }
    public MtsPage checkPlaceholdersForInstallment () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(installmentInput));
        assertTrue(
                driver.findElement(installmentInput)
                        .getAttribute("placeholder")
                        .contains("Номер счета")
        );
        assertEquals("Сумма", driver.findElement(amountInput).getAttribute("placeholder"));
        assertEquals("E-mail для отправки чека", driver.findElement(emailInput).getAttribute("placeholder"));
        return this;
    }
    public MtsPage checkPlaceholdersForDebt () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(debtInput));
        assertTrue(
                driver.findElement(debtInput)
                        .getAttribute("placeholder")
                        .contains("Номер счета")
        );
        assertEquals("Сумма", driver.findElement(amountInput).getAttribute("placeholder"));
        assertEquals("E-mail для отправки чека", driver.findElement(emailInput).getAttribute("placeholder"));
        return this;
    }
    public MtsPage checkAmount (String amount) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(amountText));
        assertTrue(driver.findElement(amountText).getText().contains(amount));
        return  this;
    }
    public MtsPage checkPhone (String phone) {
        assertTrue(driver.findElement(phoneText).getText().contains(phone));
        return this;
    }
    public MtsPage checkPlaceholdersCard () {
        assertEquals("Номер карты", driver.findElement(cardNumber).getAttribute("placeholder"));
        assertEquals("Срок действия", driver.findElement(expiry).getAttribute("placeholder"));
        assertEquals("CVC", driver.findElement(cvc).getAttribute("placeholder"));
        assertTrue(driver.findElement(cardName).getAttribute("placeholder").contains("Имя"));
        return this;
    }
    public MtsPage checkPayButton (String amount) {
        assertTrue(driver.findElement(payButton).getText().contains(amount));
        return this;
    }
}