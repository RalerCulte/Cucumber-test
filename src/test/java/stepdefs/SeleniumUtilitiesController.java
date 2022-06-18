package stepdefs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.SeleniumUtilities;

public class SeleniumUtilitiesController {
    private static final String BASE_URL = "https://ok.ru/";
    private static SeleniumUtilities seleniumUtilities;
    private static WebDriver driver;

    public static SeleniumUtilities getSeleniumUtilities() {
        if (seleniumUtilities == null) {
            System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(BASE_URL);
            seleniumUtilities = new SeleniumUtilities(driver);
        }
        return seleniumUtilities;
    }

    public static void close(){
        driver.quit();
        seleniumUtilities = null;
    }
}
