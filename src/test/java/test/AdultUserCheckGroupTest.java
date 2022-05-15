package test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import pages.GroupPage;
import pages.LoginPage;
import pages.MainPage;
import pages.SettingsPage;
import utils.User;

import static com.google.common.truth.Truth.assertWithMessage;

public class AdultUserCheckGroupTest extends BaseTest {
    @DisplayName("After 18")
    @ParameterizedTest
    @ValueSource(ints = {1993, 1998, 2002})
    void adultUserCheckGroup(int year) {
        User testUser = new User.UserBuilder()
                .setPhoneNumber("+79019076733")
                .setPassword("google_chrome")
                .build();
        String groupId = "64262221398255";

        seleniumUtilities.postMainUrl();
        LoginPage loginPage = new LoginPage(seleniumUtilities);
        MainPage mainPage = loginPage.loginByPhone(testUser);
        SettingsPage settingsPage = mainPage.receiveSettingsPage();
        settingsPage.setBirthdayYear(year);
        seleniumUtilities.postGroupUrl(groupId);
        GroupPage groupPage = new GroupPage(seleniumUtilities);
        assertWithMessage("Access should be granted but was denied").that(groupPage.checkAccessByAge()).isTrue();
    }
}
