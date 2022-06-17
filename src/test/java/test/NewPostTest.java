package test;

import org.junit.jupiter.api.BeforeEach;

import pages.LoginPage;
import pages.MainPage;
import pages.PostPage;
import utils.User;

public class NewPostTest extends BaseTest {
    protected static final String TEST_MESSAGE = "TEST TEST TEST!!!!";
    protected static final String USER_ID = "sizhu.namedvede";

    @BeforeEach
    void repostPost() {
        /*User testUser = new User.UserBuilder()
                .setPhoneNumber("+79019076733")
                .setPassword("google_chrome")
                .build();
        seleniumUtilities.postUrl();
        LoginPage loginPage = new LoginPage(seleniumUtilities);
        MainPage mainPage = loginPage.loginByPhone(testUser);
        PostPage postPage = mainPage.receivePostPage();
        postPage.selectBeachDesign().sendPost(TEST_MESSAGE);*/
    }
}
