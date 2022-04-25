package pages;

import org.openqa.selenium.By;
import utils.SeleniumUtilities;

public class MainPage extends Page {
    private static final By SETTINGS_BTN_XPATH = By.xpath("//*[@data-l='outlandertarget,USER_EDIT_CONFIG,t,USER_EDIT_CONFIG']");
    private static final By POST_LINE = By.xpath("//*[contains(@class,'pf-head')]//a[@class='pf-head_itx_a']");


    public MainPage(SeleniumUtilities seleniumUtilities) {
        super(seleniumUtilities);
    }

    public SettingsPage receiveSettingsPage() {
        seleniumUtilities.click(SETTINGS_BTN_XPATH);
        return new SettingsPage(seleniumUtilities);
    }

    public PostPage receivePostPage() {
        seleniumUtilities.click(POST_LINE);
        return new PostPage(seleniumUtilities);
    }
}
