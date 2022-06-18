package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.fail;

public class SeleniumUtilities {

    private static final int TIMEOUT = 10;

    private final WebDriver driver;

    public SeleniumUtilities(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForElement(By xpath) {
        WebElement webElement;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        if (webElement == null) {
            fail("WebElement not found within " +
                    TIMEOUT + " seconds. Failing test!" + " of element: " +
                    xpath + "\nCurrent page: " + driver.getCurrentUrl());
        }
        return webElement;
    }

    public void postUrl(String url) {
        driver.get(url);
        driver.navigate().refresh();
    }

    public void click(By xpath) {
        WebElement webElement = waitForElement(xpath);
        webElement.click();
    }

    public void enterText(By xpath, String text) {
        WebElement enterElement = waitForElement(xpath);
        enterElement.clear();
        enterElement.sendKeys(text);
    }

    public String getElementText(By xpath) {
        WebElement webElement = waitForElement(xpath);
        return webElement.getText();
    }
}
