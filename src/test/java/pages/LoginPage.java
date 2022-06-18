package pages;

import org.openqa.selenium.By;
import utils.SeleniumUtilities;
import utils.User;

public class LoginPage implements Page {
    private static final By EMAIL_INPUT_XPATH = By.xpath("//input[@id='field_email']");
    private static final By PASSWORD_INPUT_XPATH = By.xpath("//input[@id='field_password']");
    private static final By AUTH_BTN_XPATH = By.xpath("//*[@class='login-form-actions']//input[@data-l='t,sign_in']");

    private final SeleniumUtilities seleniumUtilities;

    public LoginPage(SeleniumUtilities seleniumUtilities) {
        this.seleniumUtilities = seleniumUtilities;
    }

    public MainPage loginByPhone(User user) {
        seleniumUtilities.enterText(EMAIL_INPUT_XPATH, user.getPhoneNumber());
        seleniumUtilities.enterText(PASSWORD_INPUT_XPATH, user.getPassword());
        seleniumUtilities.click(AUTH_BTN_XPATH);
        return new MainPage(seleniumUtilities);
    }

}
