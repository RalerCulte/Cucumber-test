package pages;

import utils.SeleniumUtilities;

public class MainPage extends Page {
    private static final String SETTINGS_BTN_XPATH = "//*[@data-l='outlandertarget,USER_EDIT_CONFIG,t,USER_EDIT_CONFIG']";


    public MainPage(SeleniumUtilities seleniumUtilities) {
        super(seleniumUtilities);
    }

    @Override
    public String getUrl() {
        return seleniumUtilities.getCurrentURL();
    }

    public SettingsPage receiveSettingsPage() {
        seleniumUtilities.click(SETTINGS_BTN_XPATH);
        return new SettingsPage(seleniumUtilities);
    }
}
