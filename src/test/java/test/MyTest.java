package test;

import org.junit.jupiter.api.Test;
import pages.GroupPage;
import pages.LoginPage;
import pages.MainPage;
import pages.SettingsPage;
import utils.User;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyTest extends BaseTest {
    private static final User TEST_USER = new User("SECURE", "");
    private static final String TEST_ID_GROUP_FOR_ADULT = "64262221398255";

    @Test
    void minorUserCheckGroup() {
        LoginPage loginPage = new LoginPage(seleniumUtilities);
        MainPage mainPage = loginPage.login(TEST_USER);
        SettingsPage settingsPage = mainPage.receiveSettingsPage();
        settingsPage.setBirthdayYear(MINOR_USER_YEAR);
        GroupPage groupPage = new GroupPage(seleniumUtilities, TEST_ID_GROUP_FOR_ADULT);
        assertFalse(groupPage.checkAccessByAge());
    }

    @Test
    void adultUserCheckGroup() {
        LoginPage loginPage = new LoginPage(seleniumUtilities);
        MainPage mainPage = loginPage.login(TEST_USER);
        SettingsPage settingsPage = mainPage.receiveSettingsPage();
        settingsPage.setBirthdayYear(ADULT_USER_YEAR);
        GroupPage groupPage = new GroupPage(seleniumUtilities, TEST_ID_GROUP_FOR_ADULT);
        assertTrue(groupPage.checkAccessByAge());
    }
}