package test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.PostPage;
import pages.ProfilePage;
import utils.User;

import static com.google.common.truth.Truth.assertThat;

@DisplayName("Check background with sand design")
public class RepostTest extends BaseTest {

    private static final User TEST_USER = new User("SECURE", "");
    private static final String TEST_MESSAGE = "TEST TEST TEST!!!!";
    private static final String USER_ID = "600587939102";
    private static final String SAND_COLOR_RGB = "rgb(247, 196, 67)";
    private static final String BACKGROUND_PIC = "url(\"//i.mycdn.me/i?r=A3FVj1t1rzgSLvsbLLN8xPEY2qvDEHE8faQ1rOSwuIFsyktH-I6dLXj4o-p3NCjoWJXv5WvSZFbEOnEQA05h_-Oge7THrgkDywWF44vljTmGcdkeZb6KfztSR4TYvmZPCv4rc0xrbcMbu58CWCBdQIRs\")";

    @Test
    void checkBackgroundColorForPost() {
        LoginPage loginPage = new LoginPage(seleniumUtilities);
        MainPage mainPage = loginPage.login(TEST_USER);
        PostPage postPage = mainPage.receivePostPage();
        postPage.selectBeachDesign();
        postPage.sendPost(TEST_MESSAGE);

        ProfilePage profilePage = new ProfilePage(seleniumUtilities, USER_ID);
        String style = profilePage.getStyleAttribute();

        assertThat(style).contains(SAND_COLOR_RGB);
        assertThat(style).contains(BACKGROUND_PIC);
    }
}
