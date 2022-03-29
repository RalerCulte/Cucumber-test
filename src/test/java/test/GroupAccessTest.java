package test;

import org.junit.jupiter.api.Test;
import pages.GroupPage;
import pages.LoginPage;
import pages.MainPage;
import pages.SettingsPage;
import utils.User;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GroupAccessTest extends BaseTest {
    private static final User TEST_USER = new User("SECURE", "");
    private static final String TEST_ID_GROUP_FOR_ADULT = "64262221398255";

    @Test
    void accessCheck() {
        minorUserCheckGroup();
        adultUserCheckGroup();
    }

    private void minorUserCheckGroup() {
        LoginPage loginPage = new LoginPage(seleniumUtilities);
        MainPage mainPage = loginPage.login(TEST_USER);
        SettingsPage settingsPage = mainPage.receiveSettingsPage();
        settingsPage.setBirthdayYear(Year.MINOR_YEAR.getYear());
        GroupPage groupPage = new GroupPage(seleniumUtilities, TEST_ID_GROUP_FOR_ADULT);
        assertFalse(groupPage.checkAccessByAge());
    }

    private void adultUserCheckGroup() {
        LoginPage loginPage = new LoginPage(seleniumUtilities);
        MainPage mainPage = loginPage.login(TEST_USER);
        SettingsPage settingsPage = mainPage.receiveSettingsPage();
        settingsPage.setBirthdayYear(Year.ADULT_YEAR.getYear());
        GroupPage groupPage = new GroupPage(seleniumUtilities, TEST_ID_GROUP_FOR_ADULT);
        assertTrue(groupPage.checkAccessByAge());
    }
}