package pages;

import com.sun.tools.javac.Main;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.SeleniumUtilities;
import utils.User;

public class LoginPage extends Page {
    private static final By EMAIL_INPUT_XPATH = By.xpath("//input[@id='field_email']");
    private static final By PASSWORD_INPUT_XPATH = By.xpath("//input[@id='field_password']");
    private static final By AUTH_BTN_XPATH = By.xpath("//*[@class='login-form-actions']//input[@data-l='t,sign_in']");


    public LoginPage(SeleniumUtilities seleniumUtilities) {
        super(seleniumUtilities);
        seleniumUtilities.postMainUrl();
    }

    @Override
    public String getUrl() {
        return seleniumUtilities.getCurrentURL();
    }

    public MainPage login(User user){
        seleniumUtilities.enterText(EMAIL_INPUT_XPATH, user.login());
        seleniumUtilities.enterText(PASSWORD_INPUT_XPATH, user.password());
        seleniumUtilities.click(AUTH_BTN_XPATH);
        return new MainPage(seleniumUtilities);
    }

}
