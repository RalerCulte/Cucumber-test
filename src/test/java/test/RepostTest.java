package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.PostPage;
import pages.ProfilePage;
import utils.User;

public class RepostTest extends BaseTest {

    private static final User TEST_USER = new User("SECURE", "");
    private static final String TEST_MESSAGE = "TEST TEST TEST!!!!";
    private static final String USER_ID = "600587939102";

    @Test
    void checkBackgroundColorForPost() {
        LoginPage loginPage = new LoginPage(seleniumUtilities);
        MainPage mainPage = loginPage.login(TEST_USER);
        PostPage postPage = mainPage.receivePostPage();
        postPage.selectBeachDesign();
        postPage.sendPost(TEST_MESSAGE);
        ProfilePage profilePage = new ProfilePage(seleniumUtilities, USER_ID);
        Assertions.assertTrue(profilePage.isLastPostBackgroundColorSand());
    }
}
