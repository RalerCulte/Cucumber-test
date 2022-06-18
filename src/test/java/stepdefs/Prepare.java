package stepdefs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.SeleniumUtilities;

public final class Prepare {
    private static final String BASE_URL = "https://ok.ru/";
    private static WebDriver driver;

    public static SeleniumUtilities before() {
        System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);
        return new SeleniumUtilities(driver);
    }

    public static void after() {
        driver.quit();
    }
}
