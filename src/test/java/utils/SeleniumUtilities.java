package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.fail;

public class SeleniumUtilities {

    private static final int TIMEOUT = 10;

    private final WebDriver driver;

    public SeleniumUtilities(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForElement(By xpath) {
        WebElement webElement = null;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        try {
            webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        } catch (WebDriverException ignore) {

        }

        if (webElement == null) {
            fail("WebElement not found within " +
                    TIMEOUT + " seconds. Failing test!" + " of element: " +
                    xpath + "\nCurrent page: " + driver.getCurrentUrl());
        }
        return webElement;
    }

    public void postUrl(String url) {
        driver.get(url);
    }

    public void click(By xpath) {
        WebElement webElement = waitForElement(xpath);
        webElement.click();
    }

    public void enterText(By xpath, String text) {
        WebElement webElement = waitForElement(xpath);
        webElement.clear();
        webElement.sendKeys(text);
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public String getElementText(By xpath) {
        WebElement webElement = waitForElement(xpath);
        return webElement.getText();
    }
}
