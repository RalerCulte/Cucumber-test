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

    private static final String MAIN_URL = "https://ok.ru";
    private static final String GROUP_URL = "https://ok.ru/group/";
    private static final String PROFILE_URL = "https://ok.ru/profile/";
    private static final int TIMEOUT = 10;

    private final WebDriver driver;


    public SeleniumUtilities(WebDriver driver) {
        this.driver = driver;
    }

    /*
     * TODO 'inconsistent naming', waitForElementPrescence ожидает появления в DOM, waitForElement -- видимости,
     *      в текущем виде название метода сбивает с толку
     */
    public WebElement waitForElement(By xpath) {
        WebElement webElement = null;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        try {
            webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        } catch (WebDriverException ignore) {
            // TODO исключение следует обрабатывать здесь, а не...
        }
        // TODO ...здесь
        if (webElement == null) {
            fail("WebElement not found within " +
                    TIMEOUT + " seconds. Failing test!" + " of element: " +
                    xpath + "\nCurrent page: " + driver.getCurrentUrl());
        }
        // TODO никто не запрещает возвращать внутри блока try :)
        return webElement;
    }

    // TODO опечатка: Presence
    public WebElement waitForElementPrescence(String xpath) {
        WebElement webElement = null;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        try {
            webElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));

        } catch (WebDriverException ignore) {
            // TODO аналогичное замечание см. в waitForElement(By xpath)
        }

        if (webElement == null) {
            fail("WebElement not found within " +
                    TIMEOUT + " seconds. Failing test!" + " of element: " +
                    xpath + "\nCurrent page: " + driver.getCurrentUrl());
        }
        return webElement;
    }

    // TODO имя метода стоит переименовать в что-то типа goToGroup(String groupId)
    //      вообще не сразу понял, что post это глагол
    public void postGroupUrl(String url) {
        try {
            driver.get(GROUP_URL + url);
        } catch (WebDriverException ignore) {
            // TODO непонятно зачем ловить и игнорировать
            //      здесь или стоит пояснить, что игнорирование так и задумано,
            //      или не ловить, или не игнорировать
        }
    }

    // TODO дублируется код с postGroupUrl(String url), имя параметра лучше поменять на userId
    public void postProfileUrl(String url) {
        try {
            driver.get(PROFILE_URL + url);
        } catch (WebDriverException ignore) {

        }
    }

    // TODO дублируется код с postGroupUrl(String url)
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
            // TODO непонятно зачем ловить и игнорировать
            //      здесь или стоит пояснить, что игнорирование так и задумано,
            //      или не ловить, или не игнорировать

            // TODO + непонятно, почему ловится Exception, а не StaleElementReferenceException, например
        }
    }

    public void enterText(By xpath, String text) {
        WebElement webElement = waitForElement(xpath);
        webElement.clear();
        webElement.sendKeys(text);
    }

    // TODO неиспользуемый метод
    public void waitForPageLoad() {
        try {
            // TODO не рекомендуется использовать sleep
            Thread.sleep(250);
        } catch (InterruptedException ignore) {

        }
    }

    // TODO неиспользуемый метод
    public void refreshPage() {
        // TODO можно заинлайнить
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
