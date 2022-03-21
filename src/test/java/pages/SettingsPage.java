package pages;

import utils.SeleniumUtilities;

public class SettingsPage extends Page {
    private static final String USER_SETTINGS_XPATH = "//*[@class='user-settings __profile']//*[@class='user-settings_i_tx textWrap']";
    private static final String BIRTHDAY_SELECT_XPATH = "//select[@name='fr.byear']";
    private static final String CONFIRM_USER_SETTINGS_XPATH = "//*[@data-l='t,confirm']";


    public SettingsPage(SeleniumUtilities seleniumUtilities) {
        super(seleniumUtilities);
    }

    @Override
    public String getUrl() {
        return seleniumUtilities.getCurrentURL();
    }

    public void setBirthdayYear(int year) {
        seleniumUtilities.click(USER_SETTINGS_XPATH);
        seleniumUtilities.click(BIRTHDAY_SELECT_XPATH + "//option[@value='" + year + "']");
        seleniumUtilities.click(CONFIRM_USER_SETTINGS_XPATH);
    }
}
