package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

    private By phoneInput = By.xpath("//input[@id='connection-phone-1']");
    private By amountInput = By.xpath("//input[@id='connection-sum']");
    private By emailInput = By.xpath("//input[@id='connection-email']");
    private By continueBtn = By.xpath("//button[contains(., 'Продолжить')]");

    private By iframe = By.xpath("//iframe");

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
                ExpectedConditions.presenceOfElementLocated(phoneInput)
        );

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", phoneField);

        wait.until(ExpectedConditions.elementToBeClickable(phoneField)).sendKeys(phone);

        driver.findElement(amountInput).sendKeys(amount);
        driver.findElement(emailInput).sendKeys(email);

        return this;
    }

    public MtsPage clickContinue() {
        driver.findElement(continueBtn).click();
        return this;
    }

    public MtsPage switchToPaymentFrame() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
        return this;
    }
}