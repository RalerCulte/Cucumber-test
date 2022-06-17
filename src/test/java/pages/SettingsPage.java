package pages;

import org.openqa.selenium.By;

import utils.SeleniumUtilities;

public class SettingsPage implements Page{
    private static final By USER_SETTINGS_XPATH = By.xpath("//*[@class='user-settings __profile']//*[@class='user-settings_i_tx textWrap']");
    private static final By CONFIRM_USER_SETTINGS_XPATH = By.xpath("//*[@data-l='t,profile_form_settings']");
    private static final String BIRTHDAY_XPATH = "//select[@name='fr.byear']//option[@value='%d']";

    private final SeleniumUtilities seleniumUtilities;

    public SettingsPage(SeleniumUtilities seleniumUtilities) {
        this.seleniumUtilities = seleniumUtilities;
    }

    public void setBirthdayYear(int year) {
        seleniumUtilities.click(USER_SETTINGS_XPATH);
        seleniumUtilities.click(getBirthdayXpath(year));
        seleniumUtilities.click(CONFIRM_USER_SETTINGS_XPATH);
    }

    private By getBirthdayXpath(int year) {
        return By.xpath(String.format(BIRTHDAY_XPATH, year));
    }
}
