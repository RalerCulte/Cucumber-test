package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.SeleniumUtilities;

import java.util.Calendar;

public class BaseTest {
    protected static final int CURRENT_YEAR = Calendar.getInstance().get(Calendar.YEAR);
    protected static final int MINOR_USER_YEAR = CURRENT_YEAR - 16;
    protected static final int ADULT_USER_YEAR = CURRENT_YEAR - 20;
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
