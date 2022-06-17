package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import utils.SeleniumUtilities;
import utils.User;

import static com.google.common.truth.Truth.assertWithMessage;

public class CheckAdultUserStepdefs {
    protected WebDriver driver;
    protected SeleniumUtilities seleniumUtilities;
    private static final String BASE_URL = "https://ok.ru/";

    private Page page;

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);
        seleniumUtilities = new SeleniumUtilities(driver);
    }

    @After
    public void after() {
        driver.quit();
    }

    @When("Ввойти в аккаунт с логином {string} и паролем {string}")
    public void ввойтиВАккаунтСЛогиномИПаролем(String arg0, String arg1) throws PageStateException {
        if (page != null) {
            throw new PageStateException("Данный метод должен вызываться перед всеми остальными");
        }
        User testUser = new User.UserBuilder()
                .setPhoneNumber(arg0)
                .setPassword(arg1)
                .build();

        seleniumUtilities.postUrl(MainPage.URL);
        LoginPage loginPage = new LoginPage(seleniumUtilities);
        page = loginPage.loginByPhone(testUser);
    }

    @Then("Перейти на экран с настройками")
    public void перейтиНаЭкранСНастройками() throws PageStateException {
        if (!(page instanceof MainPage mainPage)) {
            throw new PageStateException("Для перехода в экран с настройками вы должны находиться на главном экране");
        }
        page = mainPage.receiveSettingsPage();
    }

    @Then("Поменять дату на {string}")
    public void поменятьДатуНа(String arg0) throws PageStateException {
        int year = Integer.parseInt(arg0);
        if (!(page instanceof SettingsPage settingsPage)) {
            throw new PageStateException("Для перехода в экран с настройками вы должны находиться на экране настроек");
        }
        settingsPage.setBirthdayYear(year);
    }

    @Then("Проверить доступность группы {string} с учетом возраста")
    public void проверитьДоступностьГруппыСУчетомВозраста(String arg0) {
        seleniumUtilities.postUrl(arg0);
        GroupPage groupPage = new GroupPage(seleniumUtilities);
        assertWithMessage("Access should be granted but was denied")
                .that(groupPage.checkAccessByAge())
                .isTrue();
    }

    @Then("Проверить недоступность группы {string} с учетом возраста")
    public void проверитьНедоступностьГруппыСУчетомВозраста(String arg0) {
        seleniumUtilities.postUrl(arg0);
        GroupPage groupPage = new GroupPage(seleniumUtilities);
        assertWithMessage("Access should be denied but was granted")
                .that(groupPage.checkAccessByAge())
                .isFalse();
    }
}
