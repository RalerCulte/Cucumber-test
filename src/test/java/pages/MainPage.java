package pages;


import org.openqa.selenium.By;
import utils.SeleniumUtilities;

public class MainPage implements Page {
    public static final String URL = "https://ok.ru/";
    private static final By TOOLBAR_BTN = By.xpath("//*[@data-module='Toolbar']");
    private static final By SETTINGS_LINE = By.xpath("//*[@data-l='t,closed_profile']");
    private static final By POST_LINE = By.xpath("//*[contains(@class,'pf-head')]//a[@class='pf-head_itx_a']");

    private final SeleniumUtilities seleniumUtilities;

    public MainPage(SeleniumUtilities seleniumUtilities) {
        this.seleniumUtilities = seleniumUtilities;
    }

    public SettingsPage receiveSettingsPage() {
        seleniumUtilities.click(TOOLBAR_BTN);
        seleniumUtilities.click(SETTINGS_LINE);
        return new SettingsPage(seleniumUtilities);
    }

    public PostPage receivePostPage() {
        seleniumUtilities.click(POST_LINE);
        return new PostPage(seleniumUtilities);
    }
}
