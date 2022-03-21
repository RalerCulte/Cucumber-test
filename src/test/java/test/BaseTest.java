package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.SeleniumUtilities;

public class BaseTest {
    protected WebDriver driver;
    protected SeleniumUtilities seleniumUtilities;

    @BeforeAll
    static void allSetUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver.exe");
    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        seleniumUtilities = new SeleniumUtilities(driver);
    }

    @AfterEach
    void close() {
        driver.close();
    }
}
