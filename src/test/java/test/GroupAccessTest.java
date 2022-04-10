package test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @ValueSource(ints = {2007, 2008, 2009})
    void minorUserCheckGroup(int year) {
        LoginPage loginPage = new LoginPage(seleniumUtilities);
        MainPage mainPage = loginPage.login(TEST_USER);
        SettingsPage settingsPage = mainPage.receiveSettingsPage();
        settingsPage.setBirthdayYear(year);
        GroupPage groupPage = new GroupPage(seleniumUtilities, TEST_ID_GROUP_FOR_ADULT);
        assertFalse(groupPage.checkAccessByAge());
    }

    @ParameterizedTest
    @ValueSource(ints = {1993, 1998, 2002})
    void adultUserCheckGroup(int year) {
        LoginPage loginPage = new LoginPage(seleniumUtilities);
        MainPage mainPage = loginPage.login(TEST_USER);
        SettingsPage settingsPage = mainPage.receiveSettingsPage();
        settingsPage.setBirthdayYear(year);
        GroupPage groupPage = new GroupPage(seleniumUtilities, TEST_ID_GROUP_FOR_ADULT);
        assertTrue(groupPage.checkAccessByAge());
    }
}