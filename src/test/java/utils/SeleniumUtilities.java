package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.fail;

public class SeleniumUtilities {

    private static final String MAIN_URL = "https://ok.ru";
    private static final String GROUP_URL = "https://ok.ru/group/";

    private final WebDriver driver;


    public SeleniumUtilities(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForElement(By xpath) {
        WebElement webElement = null;
        int timeout = 10;
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        } catch (WebDriverException ignore) {

        }

        if (webElement == null) {
            fail("WebElement not found within " +
                    timeout + " seconds. Failing test!" + " of element: " +
                    xpath + "\nCurrent page: " + driver.getCurrentUrl());
        }
        return webElement;
    }


    public WebElement waitForElementPrescence(String xpath) {
        WebElement webElement = null;
        int timeout = 10;
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            webElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));

        } catch (WebDriverException ignore) {

        }

        if (webElement == null) {
            fail("WebElement not found within " +
                    timeout + " seconds. Failing test!" + " of element: " +
                    xpath + "\nCurrent page: " + driver.getCurrentUrl());
        }
        return webElement;
    }

    public void postGroupUrl(String url) {
        try {
            driver.get(GROUP_URL + url);
        } catch (WebDriverException ignore) {

        }
    }

    public void postMainUrl() {
        try {
            driver.get(MAIN_URL);
        } catch (WebDriverException ignore) {

        }
    }

    public void click(By xpath) {
        WebElement webElement = waitForElement(xpath);
        try {
            webElement.click();
        } catch (Exception ignore) {

        }
    }

    public void enterText(By xpath, String text) {
        WebElement webElement = waitForElement(xpath);
        webElement.clear();
        webElement.sendKeys(text);
    }

    public void waitForPageLoad() {
        try {
            Thread.sleep(250);
        } catch (InterruptedException ignore) {

        }
    }

    public void refreshPage() {
        String currentURL = getCurrentURL();
        driver.navigate().to(currentURL);
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public String getElementText(By xpath) {
        WebElement webElement = waitForElement(xpath);
        return webElement.getText();
    }
}
