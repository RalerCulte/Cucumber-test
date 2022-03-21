package test;

import org.junit.jupiter.api.Test;
import pages.GroupPage;
import pages.LoginPage;
import pages.MainPage;
import pages.SettingsPage;
import utils.SeleniumUtilities;
import utils.User;

import static org.junit.jupiter.api.Assertions.*;

public class MyTest extends BaseTest{

    private static final User TEST_USER = new User("SECURE", "");
    private static final String TEST_ID_GROUP_FOR_ADULT = "64262221398255";

    @Test
    void minorUserCheckGroup() {
        LoginPage loginPage = new LoginPage(seleniumUtilities);
        MainPage mainPage = loginPage.login(TEST_USER);
        SettingsPage settingsPage = mainPage.receiveSettingsPage();
        settingsPage.setBirthdayYear(2006);
        GroupPage groupPage = new GroupPage(seleniumUtilities, TEST_ID_GROUP_FOR_ADULT);
        assertFalse(groupPage.checkAccessByAge());
    }

    @Test
    void adultUserCheckGroup() {
        LoginPage loginPage = new LoginPage(seleniumUtilities);
        MainPage mainPage = loginPage.login(TEST_USER);
        SettingsPage settingsPage = mainPage.receiveSettingsPage();
        settingsPage.setBirthdayYear(2000);
        GroupPage groupPage = new GroupPage(seleniumUtilities, TEST_ID_GROUP_FOR_ADULT);
        assertTrue(groupPage.checkAccessByAge());
    }
}