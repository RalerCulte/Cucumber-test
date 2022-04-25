package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.SeleniumUtilities;
import utils.User;

public class BaseTest {
    // TODO дублируется с SeleniumUtilities.MAIN_URL
    private static final String BASE_URL = "https://ok.ru/";

    // TODO нет нужды в protected, private подойдет лучше
    protected WebDriver driver;
    protected SeleniumUtilities seleniumUtilities;

    @BeforeAll
    static void allSetUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver.exe");
    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);
        // TODO ...тогда driver можно было бы сделать локальной переменной и
        //      скрыть от тестов за оберткой SeleniumUtilities
        seleniumUtilities = new SeleniumUtilities(driver);
    }

    @AfterEach
    void quit() {
        // TODO было бы неплохо обернуть в SeleniumUtilities и этот метод тоже...
        driver.quit();
    }

    protected static final User TEST_USER = new User.UserBuilder()
            .setPhoneNumber("+79019076733")
            .setPassword("google_chrome")
            .build();
}
